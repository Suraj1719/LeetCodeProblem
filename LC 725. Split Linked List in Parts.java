Explanation video : 

lc Q: https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2023-09-06
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] ans=new ListNode[k];
//calculate length 
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }


        int min_len=len/k;
        int extra=len%k;

        int i=0;
        ListNode cur_head=head;
        ListNode prev=null;
        while(cur_head!=null && i<k){
            ans[i]=cur_head;
            for(int j=0;j<min_len+(extra>0?1:0);j++){
                prev=cur_head;
                cur_head=cur_head.next;
            }
            prev.next=null;
            i++;
            extra--;
        }
    return ans;
    }
}
