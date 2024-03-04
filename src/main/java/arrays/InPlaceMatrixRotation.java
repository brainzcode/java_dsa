package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InPlaceMatrixRotation {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        if (a.size() > a.get(0).size()) {
            reverseColumns(a);
        } else {
            reverseRows(a);
        }
    }


    private void transpose(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < a.get(i).size(); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> row : a) {
            Collections.reverse(row);
        }
    }

//    private void reverseColumns(ArrayList<ArrayList<Integer>> a) {
//        for (int j = 0; j < a.get(0).size(); j++) {
//            for (int i = 0, k = a.size() - 1; i < k; i++, k--) {
//                int temp = a.get(i).get(j);
//                a.get(i).set(j, a.get(k).get(j));
//                a.get(k).set(j, temp);
//            }
//        }
//    }

    private void reverseColumns(ArrayList<ArrayList<Integer>> a) {
        for (int j = 0; j < a.get(0).size() / 2; j++) { // Change here
            for (ArrayList<Integer> integers : a) {
                int temp = integers.get(j);
                integers.set(j, integers.get(a.get(0).size() - 1 - j)); // Change here
                integers.set(a.get(0).size() - 1 - j, temp); // Change here
            }
        }
    }
}

class MainInPlace {
    public static void main(String[] args) {
        // Create a sample matrix
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Rotate the matrix
        InPlaceMatrixRotation rotator = new InPlaceMatrixRotation();
        rotator.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    // Helper function to print the matrix
    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }
}


class CounterClockwiseMatrixRotation {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private void transpose(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < a.get(i).size(); j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        Collections.reverse(a);
    }
}

class MainCounterClockwiseMatrixRotation {
    public static void main(String[] args) {
        // Create a sample matrix
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Rotate the matrix
        CounterClockwiseMatrixRotation rotator = new CounterClockwiseMatrixRotation();
        rotator.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    // Helper function to print the matrix
    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }
}


class OneEightyDegreeMatrixRotation {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        reverseRows(a);
        reverseColumns(a);
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        Collections.reverse(a);
    }

    private void reverseColumns(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> row : a) {
            Collections.reverse(row);
        }
    }
}

class MainOneEightyDegreeMatrixRotation {
    public static void main(String[] args) {
        // Create a sample matrix
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        matrix.add(new ArrayList<>(Arrays.asList(7, 8, 9)));

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Rotate the matrix
        OneEightyDegreeMatrixRotation rotator = new OneEightyDegreeMatrixRotation();
        rotator.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    // Helper function to print the matrix
    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }
}
