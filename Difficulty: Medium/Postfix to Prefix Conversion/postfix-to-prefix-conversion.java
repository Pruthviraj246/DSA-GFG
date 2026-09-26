class Solution {
    static String postToPre(String s) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(String.valueOf(ch));
            }else{
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                String temp=ch+t2+t1;
                st.push(temp);
            }
        }
        return st.peek();
        
    }
}
