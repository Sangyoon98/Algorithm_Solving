import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;

        for (int i = n / 5; i >= 0; i--) {
            int remain = n - (i * 5);
            if (remain % 3 == 0) {
                answer = i + (remain / 3);
                break;
            }
        }

        System.out.println(answer);
    }
}