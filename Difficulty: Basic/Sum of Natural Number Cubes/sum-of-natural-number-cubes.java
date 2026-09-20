class Solution {
    int sumOfSeries(int n) {
       if(n==0){
           return 0;
       }
       
       int digits=(n*n*n)+sumOfSeries(n-1);
       return digits;
    }
}