
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	static int N, M, arr[], perm[];
	static boolean selected[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		perm = new int[M];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}
	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int a : perm) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			perm[cnt] = arr[i];
			dfs(cnt + 1);
			selected[i] = false;
		}
	}

}
