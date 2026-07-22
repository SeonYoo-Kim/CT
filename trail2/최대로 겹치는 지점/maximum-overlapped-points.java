import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            for (int j = x1; j <= x2; j++) {
                arr[j]++;
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        System.out.println(max);
    }

}
