class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
//Approach 1: Breadth-First Search (BFS) with Bus Stops as Nodes
//time :O(m^2  * k)  space:O(m*k)
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Create a map from the bus stop to all the routes that include this stop.
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                // Add all the routes that have this stop.
                adj.computeIfAbsent(stop, k -> new ArrayList<>()).add(route);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[501];

        // Insert all the routes in the queue that have the source stop.
        for (int route : adj.getOrDefault(source, Collections.emptyList())) {
            q.add(route);
            visited[route] = true;
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int route = q.poll();

                // Iterate over the stops in the current route.
                for (int stop : routes[route]) {
                    // Return the current count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }

                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adj.getOrDefault(stop, Collections.emptyList())) {
                        if (!visited[nextRoute]) {
                            visited[nextRoute] = true;
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}