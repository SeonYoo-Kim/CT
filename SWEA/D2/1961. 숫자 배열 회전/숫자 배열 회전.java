
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

		st.nextToken();
		int T = (int) st.nval;

		for (int tc = 1; tc <= T; tc++) {
			st.nextToken();
			int N = (int) st.nval;
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					st.nextToken();
					arr[i][j] = (int) st.nval;
				}
			}
			System.out.println("#" +tc);
//			for(int[]a : arr)
//				System.out.println(Arrays.toString(a));

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[N - 1 - j][i]);
				}System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr[N - 1 - i][N - 1 - j]);
				}System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr[j][N - 1 - i]);
				}
				System.out.println();
			}

		}

	}

}
