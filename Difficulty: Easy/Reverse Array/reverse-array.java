class Solution {
    public void reverseArray(int arr[]) {
       reverse(arr,arr.length-1,0);
    }
    
    static void reverse(int[] arr,int lastindex,int firstindex){
        if(firstindex>lastindex) return;
        swap(arr,firstindex,lastindex);
        reverse(arr,lastindex-1,firstindex+1);
    }
    
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}