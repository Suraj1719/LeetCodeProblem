class Solution {
    public int minimumPushes(String word) {
        int frq[]=new int[26];
        int len=word.length();
        for(int i=0;i<len;i++){
            char ch=word.charAt(i);
            frq[ch-'a']++;
        }
        Arrays.sort(frq);
        int cur_pos=0;
        int ans=0;
        for(int i=25;i>=0;i--){
            if(frq[i]==0)break;
            else{
            cur_pos++;
            if(cur_pos<=8){
                ans+=frq[i];
            }else if(cur_pos>8 && cur_pos<=16){
                ans+=2*frq[i];
            }else if(cur_pos>16 && cur_pos<=24){
                ans+=3*frq[i];
            }else{
                ans+=4*frq[i];
            }
            }
        }
        return ans;
    }
}