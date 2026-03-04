

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int T = (int) st.nval;

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st.nextToken();
			int N = (int) st.nval;
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st.nextToken();
				maxHeap.add((int) st.nval);
				minHeap.add(maxHeap.poll());
				if (minHeap.size() > maxHeap.size())
					maxHeap.add(minHeap.poll());

				if (i % 2 == 0)
					list.add(maxHeap.peek());
			}
			
			sb.append(list.size()).append("\n");
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
				if((i+1)%10 == 0) sb.append("\n");
				else sb.append(" ");
			}
				
			
			System.out.println(sb);
		} // tc

	}

}
