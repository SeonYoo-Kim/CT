
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int[] paskal = null;
			
			for (int i = 1; i <= N; i++) {
				int[] line = new int[i];
				for (int j = 0; j < line.length; j++) {
					if(j == 0 || j == line.length-1) {
						line[j] = 1;
					}
					else {
						line[j] = paskal[j-1] + paskal[j];
					}
				}
				paskal = line;
				for (int j2 = 0; j2 < paskal.length; j2++) {
					sb.append(paskal[j2]).append(" ");
				}sb.append("\n");
			}
			
			
			
			System.out.println("#" + tc);
			System.out.print(sb);
		}

	}

}
