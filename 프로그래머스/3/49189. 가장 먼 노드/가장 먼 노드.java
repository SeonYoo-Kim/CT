import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();
        
        for(int[] a : edge){
            list[a[0]].add(a[1]);
            list[a[1]].add(a[0]);
        }
            
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer[]> q = new ArrayDeque<>();
        
        for(int a : list[1]){
            if(visited[a]) continue;
            visited[a] = true;
            q.offer(new Integer[] {1, a}); // level, node idx
        }
            
        List<Integer> levelList = new ArrayList<>();
        
        int max = 0;
        while(!q.isEmpty()){
            
            Integer[] a = q.poll();
            int lev = a[0];
            int idx = a[1];
            
            levelList.add(lev);

            if(max < lev)
                max = lev;  
                
            for(int b : list[idx]){
                if(visited[b]) continue;
                visited[b] = true;
                q.offer(new Integer[] {lev + 1, b});
            }
        }
        
        for(int l : levelList)
            if(l==max)answer++;
        
        return answer;
    }
}