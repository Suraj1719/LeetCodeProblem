/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

Watch YT :  https://www.youtube.com/watch?v=OLgXN2Yg3xQ

//Approach - 1 (Intuitive)
    //time :O(n)  space:O(n)  as we store current node to its corresponding copy node in map

class Solution {
    
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;

        Map<Node,Node>original_copy=new HashMap<>();
        Node cur=head;//original ll
        Node prev=null;//copy ll
        Node newHead=null;//copu ll

        while(cur!=null){
            Node temp=new Node(cur.val);
            original_copy.put(cur,temp);//store 
            if(newHead==null){
                newHead=temp;
                prev=newHead;
            }else{
                prev.next=temp;
                prev=temp;
            }

            cur=cur.next;
        }

        //fill random pointer
        cur=head;
        Node newCur=newHead;

        while(cur!=null){
            if(cur.random==null){
                newCur.random=null;
            }else{
                // Node randomOfOriginal=cur.random;
                // Node currexpondingrandomOfOriginal=original_copy.get(randomOfOriginal);
                // newCur.random=currexpondingrandomOfOriginal;
                newCur.random=original_copy.get(cur.random);
            }
            cur=cur.next;
            newCur=newCur.next;
        }
        return newHead;
    }
}

//approach -2 (time :O(n)  space:O(1) or O(n) debatable)

    //1. Insert new copy nodes in original ll
    //2. random pointers assign
    //3. Separate original and inserted
class Solution {
  
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;

        Node cur=head;
        //step -1
        while(cur!=null){
            Node temp=new Node(cur.val);
            temp.next=(cur.next==null)?null:cur.next;
            cur.next=temp;

            cur=cur.next.next;
        }

        //step -2 deep copy of random pointer
        cur=head;
        while(cur!=null && cur.next!=null){
            if(cur.random==null){
                cur.next.random=null;
            }else{
                cur.next.random=cur.random.next;//important
            }
            cur=cur.next.next;
        }

        //step - 3(separate original and copy)
        Node newHead=head.next;
        Node newCur=newHead;
        cur=head;
        while(cur!=null && newCur!=null){
            cur.next=cur.next==null?null:cur.next.next;
            newCur.next=newCur.next==null?null:newCur.next.next;
            cur=cur.next;
            newCur=newCur.next;
        }
    return newHead;
    }
}
