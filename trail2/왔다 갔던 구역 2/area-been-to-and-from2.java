import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000];
        int idx = 1000;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = st.nextToken().equals("R") ? 1 : -1;
            if(d == 1) {
                for (int j = 0; j < x; j++) {
                    arr[idx]++;
                    idx += d;
                }
            }
            else {
                for (int j = 0; j < x; j++) {
                    arr[idx-1]++;
                    idx += d;
                }
            }
        }
        int cnt = 0;
        for (int i : arr) {
            if( i >= 2) cnt ++;
        }
        System.out.println(cnt);

    }

}
