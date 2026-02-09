import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] magnets;
	static int[][] rotate;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int K = Integer.parseInt(br.readLine());
			magnets = new int[4][8];
			rotate = new int[K][2];
			
			for (int i = 0; i < 4; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = (byte) Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				rotate[i][0] = Integer.parseInt(st.nextToken())-1;
				rotate[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				visited = new boolean[4];
				rotateMagnets(rotate[i][0], rotate[i][1]);
			}
			
			System.out.println("#" + tc + " " + (magnets[0][0] + magnets[1][0]*2 + magnets[2][0]*4 + magnets[3][0]*8));
		}
	}

	private static void rotateMagnets(int magnetNum, int dir) {
		// System.out.println("magnet : " + magnetNum + ", dir : " + dir);
		if (visited[magnetNum])
			return;
		visited[magnetNum] = true;

		if (magnetNum - 1 >= 0 && magnets[magnetNum][6] != magnets[magnetNum - 1][2]) {
			rotateMagnets(magnetNum - 1, dir*-1);
		}
		if (magnetNum + 1 < 4 && magnets[magnetNum][2] != magnets[magnetNum + 1][6]) {
			rotateMagnets(magnetNum + 1, dir*-1);
		}
		int[] temp = new int[8];
		for (int i = 0; i < 8; i++) {
			temp[i] = magnets[magnetNum][(i - dir + 8) % 8];
		}
		magnets[magnetNum] = temp;
		//return;
	}

}
