
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int L, info[][], max, N;
	static boolean selected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			info = new int[N][2]; // score, calrory
			selected = new boolean[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}

			
			subSet(-1, 0, 0);

			System.out.println("#" + tc + " " + max);
		}

	}

	private static void subSet(int idx, int score, int calory) {
		
		if(calory > L) return;
		
		if(score > max)
			max = score;
		
		if(idx < N - 1) {
			selected[idx + 1] = true;
			subSet(idx + 1, score + info[idx + 1][0], calory + info[idx + 1][1]);
			selected[idx + 1] = false;
			subSet(idx + 1, score, calory);
		}
	}
}
