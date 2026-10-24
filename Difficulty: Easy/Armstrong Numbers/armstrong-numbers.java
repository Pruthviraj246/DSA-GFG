class Solution {
    static boolean armstrongNumber(int n) {
        int num=n;
        int digits=digits(n);
        int arm=0;
        while(n>0){
            int d=n%10;
            arm=arm+power(d,digits);
            n=n/10;
        }
        return arm==num;
        
    }
    
    static int digits(int n){
        if(n==0) return 1;
        int count=0;
        while(n>0){
            count++;
            n=n/10;
        }
        return count;
    }
    
    static int power(int d,int digits){
        int pow=1;
        for(int i=0;i<digits;i++){
            pow=pow*d;
        }
        return pow;
    }
}