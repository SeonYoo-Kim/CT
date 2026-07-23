import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            
            if(!visited[i]){
                dfs(i, computers, n); 
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int x, int[][] computers, int n){
        for(int j = 0; j < n; j++){
            if(!visited[j] && computers[x][j] == 1){
                visited[j] = true;
                dfs(j, computers, n);  
            }
        }
    }
}
