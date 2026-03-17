
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0, end = 0, sum = arr[end], cnt = 0;
		
		while(true) {
//			System.out.println(start + " " + end);
//			System.out.println(sum);
		
		    if (sum >= M) {
		        if (sum == M) cnt++;
		        sum -= arr[start++];
		    } else {
		        if (end == N - 1) break;
		        sum += arr[++end];
		    }
								

			
		}
		
		
		
		System.out.println(cnt);
	}

}
