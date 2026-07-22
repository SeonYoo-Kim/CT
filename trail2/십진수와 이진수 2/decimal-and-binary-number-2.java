import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split("");
        int sum = 0;
        int idx = num.length - 1;
        for (int i = 0; i < num.length; i++) {
            int a = Integer.parseInt(num[i]);
            for (int j = idx--; j > 0; j--) {
                a *= 2;
            }
            sum += a;
        }
        sum *= 17;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            sb.append(sum%2);
            if(sum<2)break;
            sum/=2;
        }
        System.out.println(sb.reverse());

    }

}
