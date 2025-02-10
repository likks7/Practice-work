import java.util.Scanner;

public class FuelPostfixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the number of delivery points:");
        int m = scanner.nextInt();
        int[] fuel = new int[m];
        int[] postfixSum = new int[m];

        // Taking input for fuel consumption
        System.out.println("Enter fuel consumption at each point:");
        for (int i = 0; i < m; i++) {
            fuel[i] = scanner.nextInt();
        }

        // Compute postfix sum using recursion
        computePostfixSum(fuel, postfixSum, 0, m);

        // Output the postfix sum array
        System.out.println("PostfixSum array:");
        for (int num : postfixSum) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Recursive function to compute postfix sum
    private static int computePostfixSum(int[] fuel, int[] postfixSum, int index, int m) {
        // Base case: If we reach the last element, assign it and return
        if (index == m - 1) {
            postfixSum[index] = fuel[index];
            return postfixSum[index];
        }

        // Recursive case: Compute sum for next index first
        int nextSum = computePostfixSum(fuel, postfixSum, index + 1, m);
        postfixSum[index] = fuel[index] + nextSum;

        return postfixSum[index];
    }
}
