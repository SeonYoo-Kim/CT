import java.io.*;
import java.util.*;

class Solution {
    //int[] dx = {0, 0, -1, 1};
    //int[] dy = {1, -1, 0, 0};
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            
            
            if(!visited[i]){
                dfs(i, computers, n); 
                answer++;
            }
            //for(int j = 0; j < n; j++){
             //   if(!visited[j] && computers[i][j] == 1){
              //      visited[j] = true;
               //     dfs(j, computers, n);   
                //    
                //}
           // }
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