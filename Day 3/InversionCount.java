import java.util.Scanner;

public class InversionCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " processing times:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call recursive inversion count function
        int inversionCount = countInversions(arr, 0, n - 1);
        System.out.println("The inversion count is " + inversionCount);

        scanner.close();
    }

    // Recursive function to count inversions using Merge Sort
    private static int countInversions(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        // Recursive calls for left and right halves
        int leftInversions = countInversions(arr, left, mid);
        int rightInversions = countInversions(arr, mid + 1, right);

        // Merge step with inversion count
        int mergeInversions = mergeAndCount(arr, left, mid, right);

        return leftInversions + rightInversions + mergeInversions;
    }

    // Merge two halves and count inversions
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Count inversions
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy back sorted values into original array
        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }
}
