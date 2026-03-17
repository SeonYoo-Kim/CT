
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			//t[] pw = new int[8];
			LinkedList<Integer> pw = new LinkedList<>();
			for (int i = 0; i < 8; i++) 
				pw.add(Integer.parseInt(st.nextToken()));

			//System.out.println(pw.toString());
			int cur = 1;
			while(cur > 0) {
				for (int i = 1; i <= 5; i++) {
					cur = pw.removeFirst();
					cur -= i;
					if(cur <= 0) {
						pw.add(0);
					
						break;
					}
					pw.add(cur);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int a : pw) {
				sb.append(a).append(" ");
			}
			System.out.println(sb);
		}

	}

}
