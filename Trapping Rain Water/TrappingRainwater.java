class TrappingRainwater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 3, 0, 1, 2, 3};
        System.out.println("Trapped water: " + trap(height));
    }
}
