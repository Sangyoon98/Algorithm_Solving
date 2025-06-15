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
        int minPack = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            minPack = Math.min(minPack, pack);
            minOne = Math.min(minOne, one);
        }

        int one = N * minOne;
        int pack = ((N + 5) / 6) * minPack;
        int mix = (N / 6) * minPack + (N % 6) * minOne;

        System.out.println(Math.min(mix, Math.min(pack, one)));
    }
}