class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //using min heap/priority queue
        //time :O(n log n)  space :O(n)
        PriorityQueue<Double> pq = new PriorityQueue();
        for (int i = 0; i < dist.length; i++) {
            pq.add ((double) dist[i] / speed[i]);
        }
        
        int killed_mionster = 0;
        while (!pq.isEmpty()) {
            if (pq.remove() <= killed_mionster) {
                break;
            }
            
            killed_mionster++;
        }
        
        return killed_mionster;
    }
}