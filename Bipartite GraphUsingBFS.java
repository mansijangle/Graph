Bipartite Graph
Difficulty: MediumAccuracy: 31.25%Submissions: 187K+Points: 4
Given an adjacency list of a graph adj. Check whether the graph is bipartite or not.

A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color. This means we can divide the graph’s vertices into two distinct sets where:

All edges connect vertices from one set to vertices in the other set.
No edges exist between vertices within the same set.


class Solution {
    
    
    public boolean isCheck(int startNode ,ArrayList<ArrayList<Integer>> adj, int color[] ){
        
        color[startNode] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        
        while(!q.isEmpty()){
            
            int node = q.peek();
            q.remove();
        for(int i : adj.get(node)){
            
            if(color[i]==-1){
                color[i] = 1 - color[node];
                q.add(i);
                
            }else if(color[i]==color[node]){
                return false;
                
            }
        }
        
        
        }    
        return true;
    }
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int v = adj.size();
        int color[] = new int[v];
        Arrays.fill(color,-1);
        for(int i = 0; i<v; i++){
            if(color[i]==-1){
                if(isCheck(i,adj,color) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
}