

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] heights = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			heights[i] = Integer.parseInt(st.nextToken());
		
		Stack<int[]> receive = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			
			while(!receive.isEmpty() && heights[i] >= receive.peek()[1])
				receive.pop();
			
			if(receive.isEmpty()) sb.append("0 ");
			else sb.append(receive.peek()[0]).append(" ");
			
			receive.add(new int[] {i + 1, heights[i]});
			
		}
		System.out.println(sb);
	}

}
