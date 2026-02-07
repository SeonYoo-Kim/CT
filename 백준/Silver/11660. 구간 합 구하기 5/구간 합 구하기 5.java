
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		int[][] prefix = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int t = Integer.parseInt(st.nextToken());
				prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + t - prefix[i-1][j-1];
				arr[i-1][j-1] = t;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i ++) {
			int x1, y1, x2, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int sum = prefix[x2][y2] + prefix[x1-1][y1-1] - prefix[x1-1][y2]- prefix[x2][y1-1];
			sb.append(sum + "\n");
			
		}System.out.println(sb);
		
		
	}
}
