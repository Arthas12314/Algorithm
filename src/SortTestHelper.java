import java.util.Random;

public class SortTestHelper {
    public Integer[] generateRandomArray(int n,int rangeL,int rangeR){
        Random random=new Random();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=random.nextInt(n);
        }
        return arr;
    }
    public Integer[] generateNearlyOrderedArray(int n,int range){
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=i;
        }
        Random random=new Random();
        for(int i=0;i<range;i++){
            int posx=random.nextInt(range);
            int posy=random.nextInt(range);
            int temp=arr[posx];
            arr[posy]=arr[posx];
            arr[posx]=temp;
        }
        return arr;
    }

    public boolean isSorted(Comparable[] arr,int n){
        for(int i=1;i<n;i++){
            if(arr[i].compareTo(arr[i-1])<0)
                throw new IllegalArgumentException("Sort error.");
        }
        return true;
    }
    public void testSort(){

    }
}
