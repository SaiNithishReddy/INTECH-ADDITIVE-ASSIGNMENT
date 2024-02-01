class CountWaysToExpress {
    public static int countWays(int n) {
        int count = 0;

        for (int i = 1; i * (i + 1) < 2 * n; i++) {
            float a = (float) ((1.0 * n - (i * (i + 1)) / 2) / (i + 1));
            if (a == (int) a) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println("Total ways to express " + n + " as the sum of consecutive natural numbers: " + countWays(n));
    }
}
