
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int N = sc.nextInt();
//		int M = sc.nextInt();
		int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(prefix[b] - prefix[a - 1]).append('\n');
        }System.out.println(sb);

//        System.out.print(sb);
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < N; i ++) {
//			list.add(sc.nextInt());
//		}
//		for (int i = 0; i < M; i ++) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			int sum = 0;
//			for (int j = a - 1; j < b; j++) {
//				sum += list.get(j);
//			}
//			System.out.println(sum);
//		}
		// sc.close();	

		       
		//    }
		// }

		
		
	}
	
	
	
}
