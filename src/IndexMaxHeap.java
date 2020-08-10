import java.util.Arrays;

public class IndexMaxHeap<E extends Comparable<E>> {
    private E[] data;
    private int size;
    private int[] indexes;
    private int[] reverse;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity];
        indexes = new int[capacity];
        reverse = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public IndexMaxHeap() {
        data = (E[]) new Comparable[100];
        indexes = new int[100];
        reverse = new int[100];
        size = 0;
    }

    public IndexMaxHeap(E[] arr) {
        int k = arr.length;
        data = (E[]) new Comparable[k];
        indexes = new int[k];
        reverse = new int[k];
        for (int i = 0; i < k; i++) {
            data[i] = arr[i];
        }
        size = k;
        for (int i = parent(k - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void swapIndexes(int i, int j) {
        int temp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = temp;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    private void siftUp(int index) {
        while (index > 0 && data[indexes[parent(index)]].compareTo(data[indexes[index]]) < 0) {
            swapIndexes(parent(index), index);
            index = parent(index);
        }
    }

    private void siftDown(int index) {
        while (leftChild(index) < size) {
            int j = leftChild(index);
            if (j + 1 < size && data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0) {
                j++;
            }
            if (data[indexes[index]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swapIndexes(index, j);
            index = j;
        }
    }

    public void add(int i, E e) {
        data[i] = e;
        indexes[size] = i;
        reverse[i] = size;
        size++;
        siftUp(size - 1);
    }

    public E remove() {
        E ret = getMax();
        swap(0, size - 1);
        data[size - 1] = null;
        size--;
        siftDown(0);
        return ret;
    }

    public E getMax() {
        return data[0];
    }

    public void change(int i, E newE) {
        data[i] = newE;
        siftUp(reverse[i]);
        siftDown(reverse[i]);
    }

    // 测试索引堆中的索引数组index和反向数组reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes() {

        int[] copyIndexes = new int[size];
        int[] copyReverseIndexes = new int[size];

        for (int i = 0; i < size; i++) {
            copyIndexes[i] = indexes[i];
            copyReverseIndexes[i] = reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...count这count个索引
        boolean res = true;
        for (int i = 1; i < size; i++) {
            if (copyIndexes[i - 1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i - 1] + 1 != copyReverseIndexes[i]) {
                res = false;
                break;
            }
        }

        if (!res) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(N);
        for (int i = 0; i < N; i++) {
            indexMaxHeap.add(i, (int) (Math.random() * N));
        }
        assert indexMaxHeap.testIndexes();
    }
}