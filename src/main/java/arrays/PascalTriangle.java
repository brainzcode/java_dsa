package arrays;

public class PascalTriangle {
    public int[] getRow(int rowIndex) {
        int[] result = new int[rowIndex + 1];
        result[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result[j] += result[j - 1];
            }
            result[i] = 1;
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int rowIndex = 5; // Set the desired row index (0-based)
        int[] result = solution.getRow(rowIndex);

//        System.out.println("Row " + rowIndex + ": " + Arrays.toString(result));

        // Print the result
        System.out.print("Row " + rowIndex + ": ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class PascalTriangle1 {
    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            // Calculate the number of spaces for formatting
            int numSpaces = numRows - i - 1;

            // Print leading spaces
            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }

            // Calculate and print the row elements
            int number = 1;  // First element is always 1
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1); // Calculate the next element
            }

            System.out.println(); // Move to the next line
        }
    }

    public static void main(String[] args) {
        int numRows = 10;
        printPascalTriangle(numRows);
    }
}


class PascalTriangle2 {
    public static int[] getRow(int rowIndex) {
            int[] result = new int[rowIndex + 1];
            result[0] = 1;

            for (int i = 1; i <= rowIndex; i++) {
                for (int j = i - 1; j > 0; j--) {
                    result[j] += result[j - 1];
                }
                result[i] = 1;
            }

            return result;
    }

    public static void printPascalTriangle(int numRows) {
        for (int i = 0; i < numRows; i++) {
            int[] row = getRow(i);

            // Calculate and print spaces for formatting
            int numSpaces = numRows - i - 1;
            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }

            // Print the elements of the row
            for (int element : row) {
                System.out.print(element + " ");
            }

            System.out.println(); // Move to the next line
        }
    }

    public static void main(String[] args) {
        int numRows = 7;
        printPascalTriangle(numRows);
    }
}


class Solution {
    public int[][] solve(int A) {
        int[][] pascalTriangle = new int[A][];

        for (int i = 0; i < A; i++) {
            pascalTriangle[i] = new int[i + 1]; // Row i has i+1 elements

            // Fill the first and last element of each row with 1
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;

            // Fill the elements in the middle of the row
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }

        return pascalTriangle;
    }

}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int A = 5;

        // Calling the solve method to generate Pascal's triangle
        int[][] pascalTriangle = solution.solve(A);

        // Printing the generated Pascal's triangle
        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalTriangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}

