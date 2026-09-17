class Solution {
    int[] countGreater(int arr[], int indices[]) {
        int[] ans=new int[indices.length];
        for(int i=0;i<indices.length;i++){
            int j = indices[i] + 1;
            int count = 0;
            
            while(j<arr.length){
                if(arr[j]>arr[indices[i]]){
                    count++;
                }
                j++;
            }
            ans[i]=count;
        }
        return ans;
        
    }
}
