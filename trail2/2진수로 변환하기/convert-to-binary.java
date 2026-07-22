import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        if(n==0) {
            System.out.println(0);
            return;
        }
        
        while(n>=1) {
            sb.append(n%2);
            n/=2;
        }
        System.out.println(sb.reverse());

    }

}
