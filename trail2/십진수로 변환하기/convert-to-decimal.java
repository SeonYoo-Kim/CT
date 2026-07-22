import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().split("");
        int j = 0, sum = 0;
        for (int i = n.length; i > 0; i--) {
            int a = Integer.parseInt(n[j++]);
            for (int k = 1; k < i; k++) {
                a *= 2;
            }
            sum += a;
        }
        
        System.out.println(sum);

    }

}
