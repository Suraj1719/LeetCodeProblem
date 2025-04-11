class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        while(low<=high){
            String s=""+low;
            if(s.length()%2==1){
                low++;
            continue;
            }

            int sum=0;
            int i=0;
            while(i<s.length()/2){
                sum+=(int)(s.charAt(i));
                i++;
            }
            while(i<s.length()){
                sum-=(int)(s.charAt(i));
                i++;
            }

            if(sum==0)ans++;

            low++;
        }

        return ans;
    }
}