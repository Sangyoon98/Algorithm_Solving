import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int count = 0;
            
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

                for (int k = 0; k < j + 1; k++) {
                    if (arr[k] > arr[j]) {
                        int temp = arr[k];
                        arr[k] = arr[j];
                        arr[j] = temp;
                        count++;
                    }
                }
            }
            sb.append(T).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}