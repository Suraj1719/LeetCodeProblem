class SeatManager {
    //using PQ
    //time :O(m*logn)  size=m  pop()=log(n) in PQ
    PriorityQueue<Integer>p;
    
    public SeatManager(int n) {
        p=new PriorityQueue<>();
        for(int i=1;i<=n;i++)p.add(i);
        
    }
    
    public int reserve() {
        int seat=p.peek();
        p.poll();
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        p.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */