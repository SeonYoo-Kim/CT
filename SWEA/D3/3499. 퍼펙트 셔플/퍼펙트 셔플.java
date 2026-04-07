
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] deque = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) 
				deque[i] = st.nextToken();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int half = N/2;
			if(N%2 != 0) half++;
			int cnt = 0;
			while(cnt < half) {
				sb.append(deque[cnt++]).append(" ");
				if(cnt+half-1 == N) break;
				sb.append(deque[cnt+half-1]).append(" ");
			}
			
			System.out.println(sb);
		}

	}

}
