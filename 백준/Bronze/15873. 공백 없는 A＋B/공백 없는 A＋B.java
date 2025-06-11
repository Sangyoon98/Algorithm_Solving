import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = 0;
        
        if (a == 1010) System.out.print(20);
        else if (a % 10 == 0) System.out.print((a / 100) + 10);
        else {
            b += a % 10;
            a /= 10;
            if (a == 10) System.out.print(10 + b);
            else System.out.print(a + b);
        }
    }
}