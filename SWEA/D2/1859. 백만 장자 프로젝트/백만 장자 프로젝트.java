import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			int totalBenifit = 0; // 시간초과
//			for (int i = 0; i < N - 1; i++) {
//				int dailyMax = 0;
//				for (int j = i + 1; j < N; j++) {
//					int benifit = arr[j] - arr[i];
//					if (benifit > dailyMax)
//						dailyMax = benifit;
//				}
//				totalBenifit += dailyMax;
//			}
//			System.out.println("#" + tc + " " + totalBenifit);
			int max = arr[N - 1];
			long sum = 0L; //최대 백억임 시발ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
			for (int i = N - 2; i >= 0; i--) {
				if (arr[i] > max) max = arr[i];
				else sum += max - arr[i];

			}
			System.out.println("#" + tc + " " + sum);
		}

	}

}
