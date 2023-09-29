class Solution {
    public boolean isMonotonic(int[] nums) {
        int n=nums.length;
        return isDecreasing(nums)||isIncreasing(nums);
    }
    boolean isDecreasing(int a[]){
        int n=a.length;
        for(int i=1;i<n;i++){
            if(a[i]>a[i-1])return false;
        }
        return true;
    }
    boolean isIncreasing(int a[]){
        int n=a.length;
        for(int i=1;i<n;i++){
            if(a[i]<a[i-1])return false;
        }
        return true;
    }
}
