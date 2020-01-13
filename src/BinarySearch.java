public class BinarySearch {
    public static int binarySeartch(Comparable arr[],Comparable target){
        int len=arr.length,l=0,r=arr.length-1;
        while(l<=r){//在左闭右闭的区间寻找target
            int mid=l+(r-l)/2;
            if(arr[mid].compareTo(target)==0)
                return mid;
            else if(arr[mid].compareTo(target)<0)
                r=mid-1;
            else
                l=mid+1;
        }
        //在左闭右开的区间寻找target
        /*while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid].compareTo(target)==0)
                return mid;
            else if(arr[mid].compareTo(target)<0)
                r=mid;
            else
                l=mid+1;
        }*/
        return -1;
    }
}
