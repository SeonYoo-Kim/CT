import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < buildings.length; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for (int i = 2; i < buildings.length - 2; i++) {
				int min = 255;
				for (int j = 1; j <= 2; j++) {
					if(buildings[i] <= buildings[i-j] || buildings[i] <= buildings[i+j]) {
						min = 0;
						continue;
					}
					if(buildings[i] - buildings[i-j] < min) min = buildings[i] - buildings[i-j];
					if(buildings[i] - buildings[i+j] < min) min = buildings[i] - buildings[i+j];
				}
				cnt+=min;

			}
			System.out.println("#" + tc + " " + cnt);
		}

	}

}
