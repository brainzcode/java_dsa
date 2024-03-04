package arrays;

public class AddToNumber {
        public int[] plusOne(int[] A) {
            int n = A.length;
            int carry = 1; // Start with carry as 1

            for (int i = n - 1; i >= 0; i--) {
                int sum = A[i] + carry;
                A[i] = sum % 10;
                carry = sum / 10;
                if (carry == 0) {
                    // If no carry, no need to continue the loop
                    break;
                }
            }

            // If carry is still 1, it means we need to add a new digit at the beginning of the array
            if (carry == 1) {
                int[] result = new int[n + 1];
                result[0] = 1;
                // Copy the original array into the new array, starting from index 1
                System.arraycopy(A, 0, result, 1, n);
                return result;
            } else {
                // Check if the first digit is 0, if so, remove it
                int index = 0;
                while (index < n && A[index] == 0) {
                    index++;
                }
                // If index is not 0, that means there are leading zeroes to remove
                if (index != 0) {
                    int[] result = new int[n - index];
                    System.arraycopy(A, index, result, 0, n - index);
                    return result;
                } else {
                    return A;
                }
            }
        }
}


class PlusOneExample {
    public static void main(String[] args) {
        int[] number = {0, 3, 7, 6, 4, 0, 5, 5, 5}; // A large number
        AddToNumber solution = new AddToNumber();
        int[] incrementedNumber = solution.plusOne(number);

        // Print the incremented number
        System.out.print("Incremented Number: ");
        for (int digit : incrementedNumber) {
            System.out.print(digit);
        }
        System.out.println();
    }
}


