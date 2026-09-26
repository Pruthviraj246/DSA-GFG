class Solution {
    static String preToInfix(String s) {
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
                String temp="("+t1+ch+t2+")";
                st.push(temp);
            }
        }
        return st.peek();
    }
}
