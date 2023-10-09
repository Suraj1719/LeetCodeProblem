Brute Force :
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //brute force force approach

        int left=-1;
        int right=-1;
        int n=nums.length;
        //for left index
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                left=i;
                break;
            }
        }
//right index
        for(int i=n-1;i>=0;i--){
            if(nums[i]==target){
                right=i;
                break;
            }
        }

        return new int[]{left,right};
    }
}



Optimal : Binary Search
  class Solution {
    int left;
    int right;
    public int[] searchRange(int[] nums, int target) {
        //binary search time :O(log n)

        int n=nums.length;
        left=-1;
        right=-1;

        left=BS(nums,target);
        right=BS(nums,target);

        return new int[]{left,right};
    }
    
    int BS(int a[],int t){
        int l=0;
        int r=a.length-1;
        int ind=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]<t){
                l=mid+1;
            }else if(a[mid]>t){
                r=mid-1;
            }else{
                ind=mid;
                if(left==-1)
                r=mid-1;
                else 
                l=mid+1;
            }
        }

        return ind;
    }
}
