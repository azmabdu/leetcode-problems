package problems.easy;

public class RemoveElement {
    public static void main(String[] args) {
        // Initialize an array 'nums' with some integers
        int[] nums = new int[]{3, 2, 2, 3};

        // Define the value 'val' that needs to be removed from the array
        int val = 3;

        // Call the 'removeElement' method and store the result in 'k'
        // 'k' will represent the new length of the array after removing elements
        int k = removeElement(nums, val);

        // Print the elements of the array up to index 'k'
        // This will only print the elements that are not equal to 'val'
        System.out.print("[ ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]\n");
    }

    // Method to remove all instances of 'val' from the array 'nums'
    // Returns the new length of the array after removal
    public static int removeElement(int[] nums, int val) {
        // 'l' is the pointer that tracks the position of elements that should remain
        int l = 0;

        // Iterate through each element of the array using 'r' as the index
        for (int r = 0; r < nums.length; r++) {
            // If the current element is not equal to 'val'
            if (nums[r] != val) {
                // Assign the current element to the position at index 'l'
                nums[l] = nums[r];
                // Increment 'l' to point to the next position
                l += 1;
            }
        }

        // Return the new length of the array, which is the value of 'l'
        return l;
    }
}