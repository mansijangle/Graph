Topological sort
Difficulty: MediumAccuracy: 56.52%Submissions: 258K+Points: 4
Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.

Examples:


class Solution {
    // Function to return list containing vertices in Topological order.
    
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[v];
        int k = 0;
        for(int i = 0; i<v; i++){
            for(int neg : adj.get(i)){
                
                indegree[neg]++;
            }
        }
        
        for(int i = 0; i<v; i++){
            
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            ans.add(node);
            
            for(int neg : adj.get(node)){
                indegree[neg]--;
                if(indegree[neg]==0){
                    q.add(neg);
                }
            }
        }
        
        
        return ans;
        
    }
}