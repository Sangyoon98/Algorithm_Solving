import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = 1, end = M;

        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine());
            if (start > pos) {
                answer += start - pos;
                end -= start - pos;
                start = pos;
            } else if (end < pos) {
                answer += pos - end;
                start += pos - end;
                end = pos;
            }
        }

        System.out.print(answer);
    }
}