import java.util.Scanner;

public class UniqueDigitsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the number of elements:");
        int k = scanner.nextInt();
        int[] numbers = new int[k];

        // Input numbers
        System.out.println("Enter " + k + " numbers:");
        for (int i = 0; i < k; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Use recursion to find unique digits
        Set<Integer> digitSet = new HashSet<>();
        findUniqueDigitsRecursive(numbers, k - 1, digitSet);

        // Convert to sorted list
        List<Integer> sortedDigits = new ArrayList<>(digitSet);
        Collections.sort(sortedDigits);

        // Output result
        System.out.println(sortedDigits);

        scanner.close();
    }

    //  Recursive function to extract unique digits
    private static void findUniqueDigitsRecursive(int[] numbers, int index, Set<Integer> digitSet) {
        if (index < 0) return; // Base case: Stop when all numbers are processed

        extractDigits(numbers[index], digitSet); // Extract digits of current number
        findUniqueDigitsRecursive(numbers, index - 1, digitSet); // Process next number
    }

    //  Helper recursive function to extract digits of a single number
    private static void extractDigits(int num, Set<Integer> digitSet) {
        if (num == 0) return; // Base case: Stop when no digits are left

        digitSet.add(num % 10); // Extract last digit
        extractDigits(num / 10, digitSet); // Recursive call with remaining number
    }
}
