class Solution {
    public int longestSubarray(int[] nums) {
        //Arrays.sort(nums);
        int max_num=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max_num=Math.max(max_num,nums[i]);
        }
        int length=0;
        int max_len=0;
        int bit_array[]=new int[31];
        findBitArray(max_num,bit_array);
        for(int i=0;i<n;i++){
            int temp[]=new int[31];
            findBitArray(nums[i],temp);
            boolean possible=true;
            for(int j=0;j<31;j++){
                if(bit_array[j]==1 && temp[j]==0){
                    possible=false;
                    break;
                }
            }
            if(possible==true){
                length++;
                max_len=Math.max(max_len,length);
            }else length=0;

        }
        return max_len;
    }
    void findBitArray(int number,int a[]){
        int index=a.length-1;
        while(number>0){
            a[index--]=number%2;
            number=number/2;
        }
    }
}