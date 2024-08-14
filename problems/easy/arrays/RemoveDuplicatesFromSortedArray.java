package problems.easy.arrays;

public class RemoveDuplicatesFromSortedArray {

    // Method to remove duplicates from a sorted array
    // Returns the new length of the array after removing duplicates
    public static int removeDuplicates(int[] nums) {
        // 'l' is the pointer that tracks the position of the next unique element
        int l = 1;

        // Iterate through the array starting from the second element
        for (int r = 1; r < nums.length; r++) {
            // If the current element is not the same as the previous element
            if (nums[r] != nums[r - 1]) {
                // Assign the current element to the position at index 'l'
                nums[l] = nums[r];
                // Increment 'l' to point to the next position
                l += 1;
            }
        }

        // Return the new length of the array, which is the value of 'l'
        return l;
    }

    public static void main(String[] args) {
        // Initialize an array 'nums' with some integers (sorted with duplicates)
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // Call the 'removeDuplicates' method and store the result in 'k'
        // 'k' will represent the new length of the array after removing duplicates
        int k = removeDuplicates(nums);

        // Print the elements of the array up to index 'k'
        // This will only print the unique elements from the original array
        System.out.print("[ ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
    }
}