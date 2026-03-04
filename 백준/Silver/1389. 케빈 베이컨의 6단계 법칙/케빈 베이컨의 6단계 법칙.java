

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] freind = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			freind[a][b] = 1;
			freind[b][a] = 1;
		}
//		int[] levels = new int[N+1];
		int min = Integer.MAX_VALUE;
		int winner = 0;
		for (int i = N; i > 0; i--) {
			boolean[] selected = new boolean[N+1];
			int levSum = 0;
			Queue<int[]> q = new ArrayDeque<>();
			int lev = 0;
			q.offer(new int[] {i, lev});
			selected[i] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int idx = cur[0];
				lev = cur[1];
				levSum += lev;
// 				System.out.println(i + " levSum : " + levSum);
				for(int j = N; j > 0; j--) {
					if(!selected[j] && (freind[idx][j] != 0 || freind[j][idx] != 0)) {
						q.offer(new int[] {j, lev+1});
//						System.out.println("idx : " + idx + ", j : " +j+ ", lev+1 : " + (lev+1));
						selected[j] = true;
					}
				}
			}
			if(levSum <= min) {
				min = levSum;
				winner = i;
			}
		}
		
		System.out.println(winner);
	}

}
