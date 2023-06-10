Binary Search (Important)
  
class Solution {
    public int maxValue(int n, int index, int maxSum) {

        //time :O(log n) space :O(1)
        int right_empty_pos=n-index-1;//as 0 based indexingg so extra -1 
        int left_empty_pos=index;

        //range value of index position 1 to maxSum
        long high=maxSum;
        long low=1;

        long res=0;
        while(low<=high){
            long mid=low+(high-low)/2;

            long right_possible_sum=0;
            long left_possibble_sum=0;
            long element=mid-1;//both side different element we can take
            //like if 4 is mid  : 1 2 3 4 3 2 1  this is the arrangement

            if(right_empty_pos<=element){
        right_possible_sum=(element*(element+1))/2 - ((element-right_empty_pos)*
                                                      (element-right_empty_pos+1))/2;
            }else{
                right_possible_sum=(element*(element+1))/2 +(right_empty_pos-element);
            }

            if(left_empty_pos<=element){
                left_possibble_sum=(element*(element+1))/2 - ((element-left_empty_pos)*
                                                      (element-left_empty_pos+1))/2;
            }else{
                left_possibble_sum=(element*(element+1))/2 +(left_empty_pos-element);
            }

            long cur_sum=right_possible_sum+left_possibble_sum+mid;
            if(cur_sum<=maxSum){
                low=mid+1;
                res=mid;
            }else
                high=mid-1;
        }

        return (int)res;
    }
} 
