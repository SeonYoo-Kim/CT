import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[201][201];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;
            
            for (int j = x1; j < x2; j++) {
                for (int j2 = y1; j2 < y2; j2++) {
                    board[j][j2] = 1;
                }
            }

        }
        int sum = 0;
        for (int[] js : board) {
            for (int js2 : js) {
                sum += js2;
            }
        }
    
        System.out.println(sum);

    }

}
