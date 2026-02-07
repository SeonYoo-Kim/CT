import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] dna = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] cond = new int[4][S + 1];
		
		for(int i = 1; i < S + 1; i++) {
			cond[0][i] = cond[0][i-1];
			cond[1][i] = cond[1][i-1];
			cond[2][i] = cond[2][i-1];
			cond[3][i] = cond[3][i-1];
			if (dna[i - 1] == 'A') {
				cond[0][i]++;
			}else if (dna[i-1] == 'C') {
				cond[1][i]++;
			}else if (dna[i-1] == 'G') {
				cond[2][i]++;
			}else if (dna[i-1] == 'T') {
				cond[3][i]++;
			}
		}
		int cnt = 0;
		for (int i = 1; i <= S - P + 1; i++) {
			if (
				(cond[0][P - 1 + i] - cond[0][i-1] >= A) &&
				(cond[1][P - 1 + i] - cond[1][i-1] >= C) &&
				(cond[2][P - 1 + i] - cond[2][i-1] >= G) &&
				(cond[3][P - 1 + i] - cond[3][i-1] >= T)
			) cnt++;
		}
		System.out.println(cnt);
	}
}
