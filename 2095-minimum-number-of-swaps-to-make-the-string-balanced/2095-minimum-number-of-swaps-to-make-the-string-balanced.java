class Solution {
    public int minSwaps(String s) {
        //Algorithm - 1 (Counting Imbalance) Stack
        int len=s.length();
        // Stack<Character>st=new Stack();
        // int imbalance_count=0;
        // for(char c:s.toCharArray()){
        //     if(c=='['){
        //         st.push(c);
        //     }else{
        //         if(st.isEmpty()){
        //             imbalance_count++;
        //         }else{
        //             st.pop();
        //         }
        //     }
        // }

        // int imb_pair=(imbalance_count+st.size())/2;
        // return (imb_pair+1)/2;

        //Algorithm - 2 (closing balance overbalance)
        //closing bracket count must be <= opening bracket count
        //time :O(n)  space:O(1)

        int closing=0;//at the end it always '0' as equal number of open and close
        int max_closing=0;

        for(char c:s.toCharArray()){
            if(c=='['){
                closing--;
            }else{
                closing++;
                max_closing=Math.max(closing,max_closing);
            }
        }
        return (max_closing+1)/2;
    }
}