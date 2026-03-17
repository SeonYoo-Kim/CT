
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()) + 1;
			String[] deque = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < N/2; i++) {
				sb.append(deque[i]).append(" ");
				try {
					sb.append(deque[i+N/2]).append(" ");
				} catch (Exception e) {
					break;
				}
			}
			System.out.println(sb);
		}
	}
}