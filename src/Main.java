public class Main {
    public static void main(String[] args) {
        //数组生成
        int n = 10000;
        SortTestHelper sortTestHelper = new SortTestHelper();
        Integer[] arr = sortTestHelper.generateRandomArray(n, 0, n);
        //测试近乎有序数组
        //Integer[] arr=sortTestHelper.generateNearlyOrderedArray(10000,10);

        Integer[] arr2 = arr.clone();
        Integer[] arr3 = arr.clone();
        Integer[] arr4 = arr.clone();

        //归并排序测试
        double startTime = System.nanoTime();
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, n);
        sortTestHelper.isSorted(arr, n);
        double endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Merge Sort: " + time + " s");

        //插入排序测试
        startTime = System.nanoTime();
        InsertionSort.insertionSort(arr2, n);
        sortTestHelper.isSorted(arr2, n);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("Insertion Sort: " + time + " s");

        //希尔排序测试
        ShellSort shellSort = new ShellSort();
        startTime = System.nanoTime();
        shellSort.shellSort(arr3, n);
        sortTestHelper.isSorted(arr3, n);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("Shell Sort: " + time + " s");

        //快速排序测试
        startTime = System.nanoTime();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr4, n);
        sortTestHelper.isSorted(arr4, n);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("Quick Sort: " + time + " s");
    }
}
