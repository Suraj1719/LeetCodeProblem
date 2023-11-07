class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //we can use min heap
        //time :O(n)*O(log n)  space :O(n)
        PriorityQueue<Double> pq = new PriorityQueue();
        for (int i = 0; i < dist.length; i++) {
            pq.add ((double) dist[i] / speed[i]);
        }
        
        int killed_mionster = 0;//this work as time 
        while (!pq.isEmpty()) {
            if (pq.remove() <= killed_mionster) {
                break;
            }
            
            killed_mionster++;
        }
        
        return killed_mionster;
    }
}