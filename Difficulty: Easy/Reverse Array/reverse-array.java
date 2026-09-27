class Solution {
    public void reverseArray(int arr[]) {
        reverse(arr,0,arr.length-1);
        
    }
    
    static void reverse(int[] arr,int first,int last){
        if(first>last){
            return;
        }
        swap(arr,first,last);
        reverse(arr,first+1,last-1);
        
    }
    
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}