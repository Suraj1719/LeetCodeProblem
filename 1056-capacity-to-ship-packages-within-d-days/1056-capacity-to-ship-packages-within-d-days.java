class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //we can also do by brute force approach
        //we check from minimum capacity which is maximum value in weight to maximum capacity
        //that is total sum of weight array
        int minLoad=0;
        int maxLoad=0;
        for(int i=0;i<weights.length;i++){
            minLoad=Math.max(minLoad,weights[i]);
            maxLoad+=weights[i];
        }
        int res=maxLoad;
        //binary search approach
        while(minLoad<=maxLoad){
            int mid=(minLoad+maxLoad)/2;
            if(canShiped(mid,days,weights)){
                res=Math.min(res,mid);
                maxLoad=mid-1;
            }else
                minLoad=mid+1;
        }
        return res;
    }
    boolean canShiped(int space,int totalday,int []w){
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