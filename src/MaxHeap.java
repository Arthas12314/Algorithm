public class MaxHeap<E extends Comparable<E>>{
    private E[] data;
    private int size;
    public MaxHeap(int capacity){
        data=(E[])new Comparable[capacity];
        size=0;
    }
    public MaxHeap(){
        data=(E[])new Comparable[100];
        size=0;
    }
    public MaxHeap(E[] arr){
        int k=arr.length;
        data=(E[])new Comparable[k];
        for(int i=0;i<k;i++){
            data[i]=arr[i];
        }
        size=k;
        for(int i=parent(k-1);i>=0;i--){
            siftDown(i);
        }
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int parent(int k){
        return (k-1)/2;
    }
    private int leftChild(int k){
        return 2*k+1;
    }
    private int rightChild(int k){
        return 2*k+2;
    }
    private void swap(int i,int j){
        E temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    // 将 ShiftUp 和 ShiftDown 函数使用类似插入排序算法的方式进行优化的最大堆
    private void siftUp(int index){
        E e=data[index];
        while(index>0 && data[parent(index)].compareTo(data[index])<0){
            //swap(parent(index),index);
            data[index]=data[parent(index)];
            index=parent(index);
        }
        data[index]=e;
    }
    private void siftDown(int index){
        E e=data[index];
        while(leftChild(index)<size){
            int j=leftChild(index);
            if(j+1<size && data[j].compareTo(data[j+1])<0)
                j++;
            if(data[index].compareTo(data[j])>=0)
                break;
            //swap(index,j);
            data[index]=data[j];
            index=j;
        }
        data[index]=e;
    }
    public void add(E e){
        data[size]=e;
        size++;
        siftUp(size-1);
    }
    public E remove(){
        E ret=getMax();
        swap(0,size-1);
        data[size-1]=null;
        size--;
        siftDown(0);
        return ret;
    }
    public E getMax(){
        return data[0];
    }
    public E replace(E e){
        E ret=getMax();
        data[0]=e;
        siftDown(0);
        return ret;
    }
}