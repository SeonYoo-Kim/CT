
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			char[] bit = br.readLine().toCharArray();
			int cnt = 0;
			for (int i = 0; i < bit.length; i++) {
				if(bit[i] == '1') {
					cnt++;
					for (int j = i+1; j < bit.length; j++) {
						if(bit[j-1] != bit[j]) cnt++;
					}
					break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
