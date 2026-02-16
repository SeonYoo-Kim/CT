
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution{

	static boolean[] selected;
	static int kindOf, maxCal, score[], cal[], maxScore;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int T = (int) st.nval;

		for (int tc = 1; tc <= T; tc++) {
			st.nextToken();
			kindOf = (int) st.nval;
			st.nextToken();
			maxCal = (int) st.nval;
			score = new int[kindOf];
			cal = new int[kindOf];
			selected = new boolean[kindOf];
			maxScore = 0;
			for (int i = 0; i < kindOf; i++) {
				st.nextToken();
				score[i] = (int) st.nval;
				st.nextToken();
				cal[i] = (int) st.nval;
			}

			subset(0, 0, 0);
			System.out.println("#" + tc + " " + maxScore);
		}
	}

	private static void subset(int idx, int calSum, int scoreSum) {

		if (calSum > maxCal)
			return;
		if (scoreSum > maxScore) {
			// System.out.println("max changed : " + maxScore);
			maxScore = scoreSum;
			// System.out.println(maxScore);

		}
		if (idx >= kindOf)
			return;
		selected[idx] = true;
		subset(idx + 1, calSum + cal[idx], scoreSum + score[idx]);
		selected[idx] = false;
		subset(idx + 1, calSum, scoreSum);

	}
}
