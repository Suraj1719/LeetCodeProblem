class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        int ans=0;
        for(int i=0;i<len;i++){
            if(citations[i]>=(len-i)){
            ans=Math.max(ans,len-i);
            
            }
        }
        return ans;
    }
}