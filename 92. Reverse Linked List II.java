// YT video :  https://www.youtube.com/watch?v=bRZ_Fy4zRRY


class Solution {
   
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(-1);//IMPORTANT
        ListNode prev = temp;
        temp.next = head;
        
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode cur = prev.next;
        //important
        for (int i = 0; i < right - left; i++) {
            ListNode ptr = prev.next;//step - 1
            prev.next = cur.next;//step - 2
            cur.next = cur.next.next;//step - 3
            prev.next.next = ptr;//step - 4
        }
        
        return temp.next;
    }
}
