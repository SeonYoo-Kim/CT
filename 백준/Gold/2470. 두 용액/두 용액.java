import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int a = 0, b = N-1;
		int x = 0, y = 0;
		while(a < b) {
			int sum = arr[a]+arr[b];

			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				x = arr[a];
				y = arr[b];
				if(min == 0) break;
			}else if (sum < 0){
				a++;
			}else if(sum>0) {
				b--;
			}
			
		}
		
		System.out.println(x + " " + y);
	}

}
