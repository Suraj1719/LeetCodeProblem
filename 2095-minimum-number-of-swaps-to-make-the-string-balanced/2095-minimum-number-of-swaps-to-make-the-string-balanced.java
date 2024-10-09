class Solution {
    public int minSwaps(String s) {
        //Algorithm - 1 (Counting Imbalance) Stack
        int len=s.length();
        Stack<Character>st=new Stack();
        int imbalance_count=0;
        for(char c:s.toCharArray()){
            if(c=='['){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    imbalance_count++;
                }else{
                    st.pop();
                }
            }
        }

        int imb_pair=(imbalance_count+st.size())/2;
        return (imb_pair+1)/2;
    }
}