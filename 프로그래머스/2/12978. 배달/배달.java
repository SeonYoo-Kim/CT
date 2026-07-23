import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<int[]>[] roads = new ArrayList[N+1];
        int[] visited = new int[N+1];
        for(int i = 0; i <= N; i++){
            roads[i] = new ArrayList<>();
            visited[i] = -1;
        }
        for(int[] r : road){
            roads[r[0]].add(new int[] {r[1], r[2]});
            roads[r[1]].add(new int[] {r[0], r[2]});
        }
        
        //for(int i = 0; i < roads.length; i++)
        //    for(int[] b : roads[i])
        //        System.out.println(Arrays.toString(b));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.offer(new int[] {1, 0});
        int len = 0;
        
        while(!pq.isEmpty()){
            int[] n = pq.poll();
            int idx = n[0];
            int dist = n[1];
            
            if(visited[idx] == -1 || visited[idx] > len + dist){
                
                visited[idx] = len + dist;   
                for(int[] next : roads[idx]){
                    //System.out.println(Arrays.toString(visited));
                    pq.offer(new int[] {next[0], visited[idx] + next[1]});
                }
            }
        }
        
        for(int a : visited){
           // System.out.println(a);
            if(a != -1 && a <= K) answer++;
        }

        return answer;
    }
}