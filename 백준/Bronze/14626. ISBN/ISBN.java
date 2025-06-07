import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        int index = 0;
        int sum = 0;
        for (int i = 1; i <= 13; i++) {
            if (arr[i - 1].equals("*")) {
                index = i;
                continue;
            }

            if (i % 2 == 0) arr[i - 1] = String.valueOf(Integer.parseInt(arr[i - 1]) * 3);
            sum += Integer.parseInt(arr[i - 1]);
        }

        int answer = 0;
        while (true) {
            if (index % 2 == 0) {
                if ((sum + answer * 3) % 10 == 0) {
                    System.out.print(answer);
                    break;
                }
            } else {
                if ((sum + answer) % 10 == 0) {
                    System.out.print(answer);
                    break;
                }
            }
            answer++;
        }
    }
}