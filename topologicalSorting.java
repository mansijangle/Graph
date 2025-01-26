Topological sort
Difficulty: MediumAccuracy: 56.52%Submissions: 258K+Points: 4
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.

Examples:


class Solution {
    // Function to return list containing vertices in Topological order.
    
    public static void dfs(int start ,ArrayList<ArrayList<Integer>> adj, int [] vis, Stack<Integer> s ){
        
        vis[start] = 1;
        for(int i : adj.get(start)){
            
            if(vis[i]==0){
                
                dfs(i,adj,vis,s);
            }
        }
        
        
        s.push(start);
        
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        
        
        
        int v = adj.size();
        int vis[] = new int[v];
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<v; i++){
            
            if(vis[i]==0)
            {
                dfs(i,adj,vis,s);
            }
            
        }
        
        
        while(!s.isEmpty()){
            ans.add(s.peek());
            s.pop();
        }
        
        return ans;
        
    }
}