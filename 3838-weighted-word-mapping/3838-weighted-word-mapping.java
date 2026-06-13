class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans=new StringBuilder();
        for(String temp:words){
            char ch[]=temp.toCharArray();
            int len=ch.length;
            int cur_sum=0;
            for(int i=0;i<len;i++){
                cur_sum+=weights[ch[i]-'a'];
                cur_sum=cur_sum%26;
            }
            ans.append((char)('a'+(26-cur_sum-1)));
        }

        return ans.toString();
    }
}