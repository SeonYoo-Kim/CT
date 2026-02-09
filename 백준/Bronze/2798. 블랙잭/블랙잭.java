
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] cards;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(subset(0, 0, 0));
	}
	private static int subset(int idx, int cnt, int sum) {
		if(sum > M)	return 0;
		if(cnt == 3) return sum;
		if(idx == N) return 0;
		return Math.max(subset(idx+1, cnt+1, sum+cards[idx]), subset(idx+1, cnt, sum));
	}

}
