import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();

		int N = (int) st.nval;
		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st.nextToken();
			arr[i] = (int) st.nval;
			if(arr[i] > max) max = arr[i];
		}
		boolean[] notPrime = new boolean[max + 1];
		notPrime[1] = true;
		
		// notPrime[1] = true;
//		for (int i = 2; i < notPrime.length; i++) {
//			for (int j = 2; j < Math.sqrt(notPrime.length) ; j++) {
//				if(i%j == 0) notPrime[i] = true;
//			}
//		}
		for (int j = 2; j < Math.sqrt(notPrime.length); j++) {
			for (int i = 2; i < notPrime.length; i++) {
				//if (i % j == 0) {//System.out.println( i + " % " + j + " = " + (i%j));
					try {
						notPrime[i*j] = true;
					} catch (Exception e) {
						// TODO: handle exception
						continue;
					}
					// 
				//}
			}
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			// System.out.println(arr[i] + " " + notPrime[arr[i]]);
			if (!notPrime[arr[i]]) {
				cnt++;
				//System.out.println(i);
			}
		}
		System.out.println(cnt);

	}

}
