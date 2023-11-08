class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diff=Math.max(Math.abs(sx-fx),Math.abs(sy-fy));
        //diff--;
        //base cases
        if(diff==0 && t==1)return false;
        if(diff==0 && t==0)return true;

        if(t==0)return false;

        //diff-=2;
        System.out.println(diff);
        if(t<diff)return false;

        return true;
    }
}