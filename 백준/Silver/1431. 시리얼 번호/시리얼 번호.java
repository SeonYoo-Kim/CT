
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] serial = new String[N];

		for (int i = 0; i < N; i++) {
			serial[i] = br.readLine();
		}

		Arrays.sort(serial, (s1, s2)->{
			if(s1.length() == s2.length()) {
				char[] c1 = s1.toCharArray();
				char[] c2 = s2.toCharArray();
				int sum1 = 0, sum2 = 0;
				for (int i = 0; i < s1.length(); i++) {
					int first = c1[i] - 48;
					int second = c2[i] - 48;
					if(first >= 1 && first <= 9) {
						sum1 += first;
					}
					if(second >= 1 && second <= 9) {
						sum2 += second;
					}
				}
				if(sum1 < sum2) return -1;
				else if(sum1 > sum2) return 1;
				else return s1.compareTo(s2);
			}
				
			return Integer.compare(s1.length(), s2.length());
		});
		
		for(String a: serial)
			System.out.println(a);
		
	}

}
