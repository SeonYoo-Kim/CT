import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();
		st.nextToken();
		int N = (int) st.nval;
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			arr[i][0] = (int)st.nval;
			st.nextToken();
			arr[i][1] = (int)st.nval;
		}
		Arrays.sort(arr, (a1, a2)->{
			if(a1[1] == a2[1])
				return Integer.compare(a1[0], a2[0]);
			return Integer.compare(a1[1], a2[1]);
		});
		for(int[]a : arr)
			sb.append(a[0]).append(" ").append(a[1]).append("\n");
		System.out.println(sb);
	}

}
