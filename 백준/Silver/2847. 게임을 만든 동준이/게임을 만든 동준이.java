import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                int newScore = arr[i + 1] - 1;
                count += arr[i] - newScore;
                arr[i] = newScore;
            }
        }

        System.out.print(count);
    }
}