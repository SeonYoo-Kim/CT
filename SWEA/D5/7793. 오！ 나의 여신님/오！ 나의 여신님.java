import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map, curseMap;
	static int N, M;
	static boolean[][] visited, curse;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ArrayDeque<int[]> q = new ArrayDeque<>();
			ArrayDeque<int[]> devil = new ArrayDeque<>();
			map = new int[N][M];
			curseMap = new int[N][M];
            for(int[]a:curseMap)Arrays.fill(a, Integer.MAX_VALUE);
			visited = new boolean[N][M];
			curse = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					switch (line[j]) {
					case 'S': { // 시작위치
						q.offer(new int[] {i, j, 0});
						map[i][j] = 0;
						visited[i][j] = true;
						break;
					}case 'D': { // 여신님
						map[i][j] = 2;
						break;
					}case 'X': { // 돌
						map[i][j] =1;
						break;
					}case '*': { // 악마
						map[i][j] = 0;
						curse[i][j] = true;
						devil.offer(new int[] {i, j, 0});
						break;
					}
					default:
						map[i][j] = 0;
					}
				}
			}
			//for(int[]a:map)System.out.println(Arrays.toString(a));

			while(!devil.isEmpty()) {
				
				int[] cur = devil.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];
				
				curseMap[x][y] = t;
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(inRgane(nx, ny) && map[nx][ny] == 0 && !curse[nx][ny]) {
						curse[nx][ny] = true;
						devil.offer(new int[] {nx, ny, t +1});
					}
				}
			}
			
			// for(int[]a:curseMap)System.out.println(Arrays.toString(a));
			boolean arrived = false;
			while(!q.isEmpty()){
				
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];
				
				if(map[x][y] == 2) {
					System.out.println("#" + tc + " " + t);
					arrived = true;
				}
				
				if(map[x][y] == 0 && curseMap[x][y] <= t) continue;
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(inRgane(nx, ny) && map[nx][ny] != 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, t + 1});
					}
				}
			}
			if(!arrived) System.out.println("#" + tc + " GAME OVER");
		}
		
	}

	private static boolean inRgane(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
