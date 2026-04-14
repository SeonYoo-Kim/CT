import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static int[] cardsK, cardsI, set;
	static int winK, winI;
	static boolean[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cardsK = new int[9];
			cardsI = new int[9];
			set = new int[9];
			winK = winI = 0;
			selected = new boolean[9];
			for (int i = 0; i < 9; i++)
				cardsK[i] = Integer.parseInt(st.nextToken());
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				int tmp = i;
				if (Arrays.stream(cardsK).noneMatch(x -> x == tmp))
					cardsI[idx++] = i;
			}
			dfs(0, 0);
			System.out.println("#" + tc + " " + winK + " " + winI);
		}
	}

	private static void dfs(int turn, int idx) {
		if(turn == 9) {
			int scoreK = 0;
			int scoreI = 0;
			for (int i = 0; i < 9; i++) {
				int score = cardsK[i] + set[i];
				if(cardsK[i] > set[i]) scoreK += score; 
				else scoreI += score;
			}
			if(scoreK > scoreI) winK++;
			else winI++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			set[idx] = cardsI[i];
			dfs(turn+1, idx + 1);
			selected[i] = false;
		}
	}
}
