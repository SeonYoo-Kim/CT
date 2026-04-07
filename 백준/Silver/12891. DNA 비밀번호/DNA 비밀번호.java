import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] cnt = {0, 0, 0, 0}; // ACGT
		
		char[] arr = br.readLine().toCharArray();
		int[] req = new int[4]; // ACGT
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < P; i++) {
			switch (arr[i]) {
			case 'A': {
				cnt[0]++;
				break;
			}case 'C': {
				cnt[1]++;
				break;
			}case 'G': {
				cnt[2]++;
				break;
			}case 'T': {
				cnt[3]++;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + arr[i]);
			}
		}
		for (int i = 0; i < 4; i++) 
			req[i] = Integer.parseInt(st.nextToken());
		int success = 0;
		
		if(req[0]<=cnt[0]&&req[1]<=cnt[1]&&req[2]<=cnt[2]&&req[3]<=cnt[3])
			success++;
		
		for (int i = P; i < S; i++) {
			
			switch (arr[i-P]) {
			case 'A': {
				cnt[0]--;
				break;
			}case 'C': {
				cnt[1]--;
				break;
			}case 'G': {
				cnt[2]--;
				break;
			}case 'T': {
				cnt[3]--;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + arr[i]);
			}
			switch (arr[i]) {
			case 'A': {
				cnt[0]++;
				break;
			}case 'C': {
				cnt[1]++;
				break;
			}case 'G': {
				cnt[2]++;
				break;
			}case 'T': {
				cnt[3]++;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + arr[i]);
			}
			if(req[0]<=cnt[0]&&req[1]<=cnt[1]&&req[2]<=cnt[2]&&req[3]<=cnt[3])
				success++;
		}
		System.out.println(success);

	}

}
