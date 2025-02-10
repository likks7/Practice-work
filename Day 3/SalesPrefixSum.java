import java.util.Scanner;

public class SalesPrefixSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of hours (n):");
        int n = scanner.nextInt();

        int[] sales = new int[n];

        System.out.println("Enter sales amounts for each hour:");
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }

        int[] prefixSum = new int[n];

        // Compute prefix sum using recursion
        computePrefixSum(sales, prefixSum, n - 1); // Start from the last index

        // Output the prefix sum array
        System.out.println("PrefixSum array:");
        for (int num : prefixSum) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // recursive function to compute prefix sum
    private static void computePrefixSum(int[] sales, int[] prefixSum, int index) {
        // Base case: First element remains the same
        if (index == 0) {
            prefixSum[index] = sales[index];
            return;
        }

        // Recursive call to compute the previous prefix sum
        computePrefixSum(sales, prefixSum, index - 1);

        // Calculate the current prefix sum using the previous value
        prefixSum[index] = prefixSum[index - 1] + sales[index];
    }
}
