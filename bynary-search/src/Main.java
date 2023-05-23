import java.util.logging.Logger;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static int binarySearch(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 8, 9, 10 };
        int target = 5;
        int index = binarySearch(nums, target);
        if (index != -1) {
            logger.info("Element found at index " + index);
        }
        else {
            logger.info("Element not found in the array");
        }
    }
}