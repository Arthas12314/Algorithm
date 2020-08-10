public class MergeSort {
    public static void mergeSort(Comparable[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    public static void mergeSortBU(Comparable[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz)
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
        }
    }

    private static void mergeSort(Comparable[] arr, int l, int r) {
        /*if(l>=r)
            return;*/
        if (r - l <= 15) {
            InsertionSort.insertionSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = arr.clone();
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
