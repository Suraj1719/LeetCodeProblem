class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minLoad=0;
        int maxLoad=0;
        for(int i=0;i<weights.length;i++){
            minLoad=Math.max(minLoad,weights[i]);
            maxLoad+=weights[i];
        }
        int res=maxLoad;
        //binary search approach
        while(minLoad<=maxLoad){//a ship can carry
            int mid=(minLoad+maxLoad)/2;
            if(possibleToShip(mid,days,weights)){
                res=Math.min(res,mid);
                maxLoad=mid-1;
            }else
                minLoad=mid+1;
        }
        return res;
    }
    boolean possibleToShip(int space,int totalday,int []w){
        int ship=1;
        int cur=space;
        for(int i=0;i<w.length;i++){
            if(cur-w[i]<0){
                ship++;
                cur=space;
            }
            cur=cur-w[i];
        }
        return ship<=totalday;

    }
}