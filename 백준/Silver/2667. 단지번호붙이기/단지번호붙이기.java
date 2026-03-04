

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean visited[][];
	static int map[][], N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}//for(int[]a:map)System.out.println(Arrays.toString(a));

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0)
// 				dfs(i, j, 0);
				bfs(i, j, 0);
			}
		}
		
		Integer[] arr = list.toArray(new Integer[0]);
		Arrays.sort(arr);
		System.out.println(arr.length);
		for(int a : arr)
			System.out.println(a);
		
	}

	private static void bfs(int i, int j, int cnt) {
		if(visited[i][j]) return;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++;
			int x = cur[0];
			int y = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(inRange(nx, ny)) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		list.add(cnt);
	}

	private static void dfs(int x, int y, int cnt) {
		
		if(visited[x][y] || map[x][y] == 0) return;
		
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inRange(nx, ny)) {
				dfs(nx, ny, cnt+1);
				return;
			}
		}
		list.add(cnt);
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[x][y] !=0;
	}

}
