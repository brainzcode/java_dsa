package arrays;

import java.util.Arrays;
import java.util.List;

public class NThreeRepeatNumber {
    public int repeatedNumber(final List<Integer> a) {
        int num1 = -1, num2 = -1;
        int count1 = 0, count2 = 0;
        int n = a.size();

        // Phase 1: Finding two potential candidates
        for (int num : a) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                // Only decrement if the current number differs from BOTH candidates
                if (num != num1 && num != num2) {
                    count1--;
                    count2--;
                }
            }
        }

        // Phase 2: Verify if either candidate occurs more than N/3 times
        count1 = 0;
        count2 = 0;
        for (int num : a) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            return num1;
        }
        if (count2 > n / 3) {
            return num2;
        }

        return -1; // No majority element
    }

    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(1, 5, 3, 2, 6, 2, 2, 6, 0, 4, 0, 2, 2);
        NThreeRepeatNumber solution = new NThreeRepeatNumber();
        int result = solution.repeatedNumber(inputArray);
        System.out.println("Majority Element: " + result);
    }
}

//class Main {
//    public static void main(String[] args) {
//        List<Integer> array = Arrays.asList(1, 2, 5, 3, 2, 6, 2, 6, 0, 4, 0);
//        NThreeRepeatNumber solution = new NThreeRepeatNumber();
//        int result = solution.repeatedNumber(array);
//        System.out.println("Answer: " + result);
//    }
//}
