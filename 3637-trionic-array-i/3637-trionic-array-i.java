class Solution {
    boolean isInc(int l,int r,int a[]){
        while(l<r){
            if(a[l]>=a[l+1])return false;
            l++;
        }
        return true;
    }
    boolean isDec(int l,int r,int a[]){
        while(l<r){
            if(a[l]<=a[l+1])return false;
            l++;
        }
        return true;
    }
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n==3)return false;

        //boolean ans=false;
        for(int i=1;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if((isInc(0,i,nums) & isDec(i,j,nums) & isInc(j,n-1,nums))==true){
                    System.out.println(i+" "+j);
                return true;
                }
            }
        }
        return false;
    }
}