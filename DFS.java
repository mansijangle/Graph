Given a connected undirected graph represented by an adjacency list adj, which is a vector of vectors where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Traversal (DFS) starting from vertex 0, visiting vertices from left to right as per the adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the adjacency list.

Examples:

Input: adj = [[2,3,1], [0], [0,4], [0], [2]]

Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 2 (the first neighbor of 0) → Output: 0, 2 
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1



class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    public static void dfs(int node,boolean[] visited, ArrayList<ArrayList<Integer>> adj, List<Integer> l){
        
        
        visited[node] = true;
        l.add(node);
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i,visited,adj,l);
                
            }
            
        }
    }
    
    
    
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        // ArrayList<Integer> res = new ArrayList<>();
        // Set<Integer> visited = new HashSet<>();
        // Stack<Integer> s = new Stack<>();
        // s.push(0);
        
        // while(!s.isEmpty()){
        //     int current = s.pop();
            
            
        //     if(!visited.contains(current)){
        //         res.add(current);
        //         visited.add(current);
        //     }
        //     for (int i = adj.get(current).size() - 1; i >= 0; i--) {
        //         int neighbor = adj.get(current).get(i);
        //         if (!visited.contains(neighbor)) {
        //             s.push(neighbor);
        //         }
        //     }
        // }
        
        // return res;
        
        int V = adj.size();
        ArrayList<Integer> l = new ArrayList<>();
        boolean visited[] = new boolean[V+1];
        visited[0] = true;
        dfs(0,visited, adj,l);
        return l;
        
        
       
    }
}