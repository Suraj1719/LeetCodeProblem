/*
      
      Company Tags                : GOOGLE
      Leetcode Link               : https://leetcode.com/problems/shortest-path-visiting-all-nodes/
      
      -------->  Find Q&A in the bottom of this page
*/

/*
Time Complexity : O(2^N * N^2).
Notice the while loop that performs the BFS traversal of the graph.
In the worst case, the while loop can run 2^N iterations, where N is the number of nodes in the graph. 
This is because the program explores all possible combinations of nodes using bit masking i.e. each bit can be either 0 or 1 (2 possibilities) —-> 2^N
Within each iteration, there is a nested loop that iterates through the neighbors of the current node. 
In the worst case, this inner loop iterates N times for each node.
So, the overall time complexity is 0(2^N * N^2).
*/

/********************************************************* JAVA *******************************************************/
class Solution {
	public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        
		if(n == 1 || n == 0)
			return 0;
        
        int allVisitedState = (1 << n) - 1;
        Queue<int []> que = new LinkedList<>();
        
		int [][] visited = new int [n][allVisitedState+1];

		for(int i=0; i<graph.length; i++) {
			que.add(new int [] {i, 1 << i});
            visited[i][(1 << i)] = 1;  
		}



		int shortestPath = 0;
		while(!que.isEmpty()){
			int size = que.size();
			shortestPath++;
			for(int i=0; i<size; i++){
                
				int [] curr  = que.poll();
				int currNode = curr[0];
				int currMask = curr[1];
                
				for(int adj : graph[currNode]){
					int nextMask = currMask | (1 << adj);

					if(visited[adj][nextMask] == 1)
                        continue;
                    
                    if(nextMask == allVisitedState)
						return shortestPath;
                    
                    visited[adj][nextMask] = 1;
					que.add(new int [] {adj, nextMask});
				}
			}
		}
		return -1;
	}
}


******** Q&A *********
Qn : what is the need of bit masking? i mean cant we simply use a 2d array which tracks the state of (parent, child)
i.e if i am coming from 0th node and going to 1st node then, i will simply set it as isvisited[0][1] = true.
next time, when i come in this same situation i.e 0 to 1, i can simply check if isvisited[0][1] = true or not.

Ans : That’s such an IMPORTANT qn you asked.  Actually i took a very small example in my YouTube video.
In big examples- the repeated path can be large as well .
For example :  you came to 3 via 0,1,2
Path - 0 -> 1  -> 2 -> 3

Suppose you came to 3 via 0,4,2,3
Here if you notice, you came to 3 from 2 but the entire path is different.
Hence keeping track of only precise node will not be enough, we need entire trail path to see if we have seen the path before or not.

----------------
