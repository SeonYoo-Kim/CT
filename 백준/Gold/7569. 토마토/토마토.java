
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int[] dx = {0, 0, 0, 0, 1, -1};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int H, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[H][N][M];
		ArrayList<int[]> riped = new ArrayList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) {
						riped.add(new int[] {i, j, k});
					}
				}
			}
		}
		/*
		 * 1 : 익은 토마토
		 * 0 : 안익은 토마토, 인접한 익은 토마토 있으면 하루만에 익음
		 * -1 : 빈칸
		 */
		int days = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for(int[]a:riped) q.offer(new int[] {a[0], a[1], a[2], 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int z = cur[2];
			days = cur[3];
			
			for (int d = 0; d < 6; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];
				int ndays = days + 1;
				
				if(inRange(nx, ny, nz) && box[nx][ny][nz] == 0) {
					box[nx][ny][nz] = 1;
					q.offer(new int[] {nx, ny, nz, ndays});
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
				
			}
		}
		System.out.println(days);
		
	}
	private static boolean inRange(int x, int y, int z) {
		return x >= 0 && y >= 0 && z >= 0 && x < H && y < N && z < M;
	}

}
