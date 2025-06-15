import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int A = 300;
        int B = 60;
        int C = 10;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        while (T > 0) {
            if (T - A >= 0) {
                T -= A;
                aCount++;
            }
            else if (T - B >= 0) {
                T -= B;
                bCount++;
            }
            else {
                T -= C;
                cCount++;
            }
        }

        if (T != 0) System.out.println(-1);
        else System.out.println(aCount + " " + bCount + " " + cCount);
    }
}