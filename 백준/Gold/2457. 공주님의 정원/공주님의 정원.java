import java.io.*;
import java.util.*;

public class Main {
    static class Flower {
        int start, end;
        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] arr = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            arr[i] = new Flower(start, end);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return b.end - a.end;
        });

        int current = 301;
        int index = 0;
        int answer = 0;

        while (current < 1201) {
            int end = current;

            while (index < N && arr[index].start <= current) {
                if (arr[index].end > end) end = arr[index].end;
                index++;
            }

            if (end == current) {
                System.out.println(0);
                return;
            }

            answer++;
            current = end;
        }

        System.out.println(answer);
    }
}