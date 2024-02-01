public class StringCompression {

    public static String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < input.length(); i++) {
            countConsecutive++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < input.length() ? compressed.toString() : input;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        String compressed = compress(input);
        System.out.println(compressed);

        // Bonus 1
        String compressed2 = compress(compressed);
        System.out.println(compressed2);

        // Bonus 2
        String decompressed2 = decompress2(compressed2);
        System.out.println(decompressed2);
    }

    // Bonus 2 - Decompression method
    public static String decompress2(String input) {
        StringBuilder decompressed = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char character = input.charAt(i);
            int count = Character.getNumericValue(input.charAt(i + 1));

            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }

        return decompressed.toString();
    }
}
