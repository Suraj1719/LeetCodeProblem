class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap=new PriorityQueue<>();
        this.maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()|| maxHeap.peek()>=num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        if(maxHeap.size()>minHeap.size()+1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size()<minHeap.size())
            maxHeap.add(minHeap.poll());
        
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return maxHeap.peek()/2.0+minHeap.peek()/2.0;
        
        return maxHeap.peek();
        
    }
}