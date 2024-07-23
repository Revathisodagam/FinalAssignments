package bitwiseTasks;

public class NonRepeatingElements {
	public static void findNonRepeatingElements(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rightmost_set_bit = xor & -xor; 
        
        int first_non_repeating = 0;
        int second_non_repeating = 0;
        for (int num : nums) {
            if ((num & rightmost_set_bit) == 0) {
                first_non_repeating ^= num;
            } else {
                second_non_repeating ^= num;
            }
        }
        
        System.out.println("Non-repeating elements are: " + first_non_repeating + " and " + second_non_repeating);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 2, 2, 4};
        findNonRepeatingElements(nums);
    }
}
