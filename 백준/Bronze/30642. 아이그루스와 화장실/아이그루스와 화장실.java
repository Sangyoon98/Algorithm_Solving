import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int K = Integer.parseInt(br.readLine());

        if (M.equals("annyong")) {
            if (K % 2 == 1) System.out.print(K);
            else {
                if (K + 1 > N) System.out.print(K - 1);
                else System.out.print(K + 1);
            }
        } else {
            if (K % 2 == 0) System.out.print(K);
            else {
                if (K + 1 > N) System.out.println(K - 1);
                else System.out.println(K + 1);
            }
        }
    }
}