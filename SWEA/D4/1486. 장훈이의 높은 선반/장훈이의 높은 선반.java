
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int heights[], diff, tower, B, N;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			heights = new int[N];
			selected = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) 
				heights[i] = Integer.parseInt(st.nextToken()); 
			
			tower = Integer.MAX_VALUE;
			diff = Integer.MAX_VALUE;
			subset(-1, 0);
			
			
			System.out.println("#" + tc + " " + diff);
		}

	}

	private static void subset(int idx, int height) {
		//System.out.println(idx + " " + height);
		
		if(height > tower) return;
		if(diff == 0) return;
		
		if(height >= B) {
			tower = height;
			diff = tower - B;
			// System.out.println(tower + " " + diff);
		}
		
		if(idx + 1 < N) {
			selected[idx+1] = true;
			subset(idx + 1, height + heights[idx+1]);
			selected[idx+1] = false;
			subset(idx + 1, height);
		}
	}

}
