import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

			int iter = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < iter; j++) {
					sb.append(arr[i]);
				}
			}			
			System.out.println(sb);
			
		}

	}

}
