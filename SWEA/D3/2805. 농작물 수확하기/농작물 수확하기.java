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
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0'; 
				}
			}
			//for(int[] a:map)System.out.println(Arrays.toString(a));
			
			int sum = 0;
			for (int i = 0; i < N; i++)
				sum += map[N/2][i];

			for (int i = 0; i < N/2; i++) {
				for (int j = (N/2) - i; j <= (N/2) + i ; j++) {
					sum += map[i][j];
					sum += map[N - 1 -i][j];
//					System.out.println("[" + i + ", " + j + "] : " + map[i][j]);
//					System.out.println("[" + (N - 1 - i) + ", " + j + "] : " + map[N - 1 -i][j]);
//					System.out.println(i + " : " + sum);
				}
			}
			
			
			System.out.println("#" + tc + " " + sum);
		}

	}

}
