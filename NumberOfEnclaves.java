
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:

Input:
grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
Output:
3
Explanation:
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
The highlighted cells represents the land cells.




class Pair{
    
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
        
    }
}
class Solution {

    int numberOfEnclaves(int[][] grid) {

        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                    }    
                    
                }
            }
        }
        
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0,+1,+0,-1};
        
        
        while(!q.isEmpty()){
            
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            
            for(int i = 0; i<4; i++)
            {
             int nrow = row+delrow[i];
             int ncol = col+delcol[i];
             
             if(nrow >=0 && nrow < n && ncol >=0 && ncol <m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                 
                 
                 q.add(new Pair(nrow,ncol));
                 visited[nrow][ncol] = 1;
             }
                
            }
        }
        
        
        int count = 0;
        for(int i = 0; i<n; i++){
            
            for(int j = 0; j<m; j++){
                
                if(grid[i][j]==1 && visited[i][j]==0){
                    count++;
                }
            }
        }
        
        
        return count;
        
        
        
        
        // Your code here
    }
}