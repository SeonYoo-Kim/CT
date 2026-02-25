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
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			arr[i] = (int) st.nval;
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
