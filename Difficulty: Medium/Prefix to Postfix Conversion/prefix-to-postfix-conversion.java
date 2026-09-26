class Solution {
    static String preToPost(String s) {
        Stack<String> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(String.valueOf(ch));
            }else{
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                String temp=t1+t2+ch;
                st.push(temp);
            }
        }
        return st.peek();        
    }
}