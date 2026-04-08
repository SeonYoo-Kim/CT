import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] box;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> tomato = new ArrayDeque<>();
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1)
					tomato.add(new int[] {0, i, j});
			}
		}
		
		int days = -1;
		
		while(!tomato.isEmpty()) {
			int[] cur = tomato.poll();
			days = cur[0];
			int x = cur[1];
			int y = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(inRange(nx, ny)) {
					box[nx][ny] = 1;
					tomato.add(new int[] {days+1, nx, ny});
				}
					
			}
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(box[i][j] == 0)
					days = -1;

		System.out.println(days);
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && box[x][y] == 0;
	}

}
