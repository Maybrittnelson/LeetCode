package medium.string;

public class LeetCode_11 {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        int area;
        while (left < right) {
            area = (right - left) * (height[left] < height[right] ? height[left] : height[right]);
            maxArea = area > maxArea ? area : maxArea;

            if (height[left] < height[right]) {
                do {
                    left++;
                } while (left < right && height[left - 1] >= height[left]);
            } else {
                do {
                    right--;
                } while (right > left && height[right + 1] >= height[right]);
            }
        }

        return maxArea;
    }
}
