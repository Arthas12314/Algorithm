public class ShellSort<T extends Comparable<T>> {
    public void shellSort(T[] arr,int n){
        int h=0;
        while(h<n/3){
            h=3*h+1;
        }
        while(h>=1){
            for(int i=0;i<n;i++){
                T e=arr[i];
                int j;
                for(j=i;j>=h && e.compareTo(arr[j-h])<0;j--){
                    arr[j]=arr[j-h];
                }
                arr[j]=e;
            }
            h/=3;
        }
    }
}
