public class InsertionSort {
    public static void insertionSort(Comparable[] arr, int n) {
        if (arr.length < 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            Comparable element = arr[i];
            int j;
            for (j = i; j > 0 && element.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = element;
        }
    }

    public static void insertionSort(Comparable[] arr, int l, int r) {
        if (arr.length < 1) {
            return;
        }
        for (int i = l; i < r + 1; i++) {
            Comparable element = arr[i];
            int j;
            for (j = i; j > l && element.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = element;
        }
    }
}
