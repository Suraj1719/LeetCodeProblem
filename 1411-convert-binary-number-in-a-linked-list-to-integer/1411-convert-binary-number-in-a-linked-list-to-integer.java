/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        Stack<Integer>st=new Stack<>();
        while(head!=null){
            st.add(head.val);
            head=head.next;
        }
        int ans=0;
        int bit_pos=0;
        while(!st.isEmpty()){
            int num=st.pop();
            //System.out.println("num"+ num);
            ans+=(num*(int)Math.pow(2,bit_pos));
            bit_pos++;
        }
        return ans;
    }
}