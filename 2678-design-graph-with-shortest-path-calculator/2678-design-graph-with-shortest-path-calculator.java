class Graph {
    //Dijkstra's Algorithm
    //time :O(M)*O(v+ E log v)
    Map<Integer, List<Node>> adj;
    int N;
    int[] result;
    PriorityQueue<Node> pq;

    public Graph(int n, int[][] edges) {
        N = n;
        adj = new HashMap<>();
        result = new int[N];
        Arrays.fill(result, Integer.MAX_VALUE);
        pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];
            int cost = vec[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, cost));
        }
        
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];

        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, cost));
    }
    
    public int shortestPath(int node1, int node2) {
        Arrays.fill(result, Integer.MAX_VALUE);
        result[node1] = 0;
        pq.offer(new Node(node1, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int d = pq.poll().cost;

            for (Node vec : adj.getOrDefault(node, Collections.emptyList())) {
                int adjNode = vec.node;
                int dist = vec.cost;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new Node(adjNode, d + dist));
                }
            }
        }

        return result[node2] == Integer.MAX_VALUE ? -1 : result[node2];
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */