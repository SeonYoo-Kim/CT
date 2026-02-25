
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int l = 1; l <= 10; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
//			System.out.println("N : " + N);
			int[] first = new int[100];
			int[] second = new int[100];
			boolean[] visited = new boolean[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				//System.out.println("idx : " + idx);
				if (first[idx] == 0) {
					first[idx] = Integer.parseInt(st.nextToken());
					//System.out.println(first[idx]);
				}
				else {
					second[idx] = Integer.parseInt(st.nextToken());
					//System.out.println(second[idx]);
				}
					
			}
//			System.out.println("first : ");
//			System.out.println(Arrays.toString(first));
//			System.out.println("second : ");
//			System.out.println(Arrays.toString(second));
			
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(0);
			visited[0] = true;
			int flag = 0;
			
			while(!q.isEmpty()) {
				
				int cur = q.poll();
				if(cur == 99) {
					flag = 1;
					break;
				}
					
				
				if(!visited[first[cur]]) {
					q.offer(first[cur]);
					visited[first[cur]] = true;
				}
				if(!visited[second[cur]]) {
					q.offer(second[cur]);
					visited[second[cur]] = true;
				}
				
				
				
			}
			System.out.println("#" + tc + " " + flag);
		}

	}

}
