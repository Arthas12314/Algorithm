import java.util.Random;

public class QuickSort {
    public static void quickSort(Comparable[] arr,int n){
        //quickSort3Ways(arr,0,n-1);
        quickSort(arr,0,n-1);
    }
    private static void quickSort(Comparable[] arr,int l,int r){
        if(r-l<=15){
            InsertionSort.insertionSort(arr,l,r);
            return;
        }

        int v=partition(arr,l,r);
        quickSort(arr,l,v-1);
        quickSort(arr,v+1,r);
    }
    private static void quickSort3Ways(Comparable[] arr,int l,int r){
        if(r-l<=15){
            InsertionSort.insertionSort(arr,l,r);
            return;
        }
        if(l>=r)
            return;
        int index=(int)(Math.random()%(r-l+1)+l);
        swap(arr,index,l);
        Comparable e=arr[l];
        int lt=l,gt=r+1,i=l+1;
        while(i<gt){
            if(arr[i].compareTo(e)>0){
                swap(arr,i,gt-1);
                gt--;
            }
            else if(arr[i].compareTo(e)<0){
                swap(arr,i,lt+1);
                lt++;
                i++;
            }
            else {
                i++;
            }
        }
        swap(arr,l,lt);
        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }
    private static int partition(Comparable[] arr,int l,int r){
        int index=(int)(Math.random()%(r-l+1)+l);
        swap(arr,index,l);
        Comparable e=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++){
            if(arr[i].compareTo(e)<0){
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static int partition2(Comparable[] arr,int l,int r){
        int index=(int)(Math.random()%(r-l+1)+l);
        swap(arr,l,index);
        Comparable e=arr[l];
        int i=l+1,j=r;
        while(true){
            while(i<=r && arr[i].compareTo(e)<=0)    i++;
            while(j>=l+1 && arr[j].compareTo(e)>=0)  j--;
            if(i>j)
                break;
            swap(arr,i,j);
            i++;j--;
        }
        swap(arr,l,j);
        return j;
    }
    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int n=10000;
        Integer[] a=new Integer[n];
        for(int i=0;i<n;i++){
            a[i]=(int)(Math.random()%n);
        }
        QuickSort.quickSort(a,n);
        for(int i=1;i<n;i++){
            if(a[i]<a[i-1])
                throw new IllegalArgumentException("Sorted Error!");
        }
        System.out.println("Done!");
    }
}
