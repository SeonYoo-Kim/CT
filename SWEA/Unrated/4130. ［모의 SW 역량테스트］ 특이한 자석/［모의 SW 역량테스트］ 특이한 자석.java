
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] magnets = new int[4][8];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					// N극 0, S극 1
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}

			}
//			for(int[] a : magnets)
//				System.out.println(Arrays.toString(a));
			int[][] rotate = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				// 회전시킬 자석 번호
				rotate[i][0] = Integer.parseInt(st.nextToken()) - 1;
				// 시계방향 1, 반시계 -1
				rotate[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				visited = new boolean[4];
				magnets[rotate[i][0]] = rotateMagnet(rotate[i][0], rotate[i][1]);
			}

			System.out.println(
					"#" + tc + " " + (magnets[0][0] + magnets[1][0] * 2 + magnets[2][0] * 4 + magnets[3][0] * 8));

		}

	}

	static int[] rotateMagnet(int magnetNum, int dir) {
		if (visited[magnetNum])
			return magnets[magnetNum];
		visited[magnetNum] = true;
		// System.out.println("magnetNum : " + magnetNum + ", direction : " + dir);
		int[] pole = magnets[magnetNum];
		int[] tmp = new int[8];
		for (int i = 0; i < 8; i++) {
			int idx = (i - dir + 8) % 8;
			tmp[i] = pole[idx];
		}
		if (magnetNum - 1 >= 0 && magnets[magnetNum][6] != magnets[magnetNum - 1][2]) {
			magnets[magnetNum - 1] = rotateMagnet(magnetNum - 1, dir * -1);
		}
		if (magnetNum + 1 < 4 && magnets[magnetNum][2] != magnets[magnetNum + 1][6]) {
			magnets[magnetNum + 1] = rotateMagnet(magnetNum + 1, dir * -1);
		}
		return tmp;
	}

}
