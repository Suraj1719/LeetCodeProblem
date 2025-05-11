class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutive=0;
        boolean res=false;

        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]%2==1){
                consecutive++;
                if(consecutive>=3){
                    res=true;
                    break;
                }
            }else{
                consecutive=0;
            }
        }
        return res;
    }
}