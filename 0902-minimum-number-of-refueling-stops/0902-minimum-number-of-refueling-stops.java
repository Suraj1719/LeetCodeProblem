class Solution {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        //approach 1: Approach 2: Heap  time:O(nlogn) space:O(n)
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int ans = 0, prev = 0;

        for (int[] station: stations) {
            int location = station[0];
            int capacity = station[1];
            tank = tank - (location - prev);

            //checking whether we can reach every station or not
            while (!pq.isEmpty() && tank < 0) {  // must refuel in past
                tank += pq.poll();
                ans++;
            }

            if (tank < 0) return -1;//we do not have sufficent fuel to reach next station

            pq.offer(capacity);
            prev = location;
        }

        // Repeat body for station = (target, inf)
        
        tank =tank -(target - prev);
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }

        if (tank < 0) return -1;//we do not have sufficent fuel to reach end
        

        return ans;
    }
}