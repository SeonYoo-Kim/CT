
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[Integer.parseInt(st.nextToken())];
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int sum = 0, cnt = 0;
		int s = 0, e = 0;
		while(true) {
			if(sum <= M) {
				if(sum == M)
					cnt++;
				if(e == arr.length) break;
				sum += arr[e++];
			}else
				sum -= arr[s++];
			
		}
		System.out.println(cnt);
	}
}
