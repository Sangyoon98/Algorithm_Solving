import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int[] weight = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'A';
                weight[index] += (int) Math.pow(10, word.length() - i - 1);
            }
        }

        Integer[] alphabet = new Integer[26];
        for (int i = 0; i < 26; i++) alphabet[i] = i;
        Arrays.sort(alphabet, (o1, o2) -> weight[o2] - weight[o1]);

        int num = 9;
        int[] result = new int[26];
        Arrays.fill(result, -1);

        for (int i = 0; i < 26; i++) {
            if (weight[alphabet[i]] == 0) break;
            result[alphabet[i]] = num--;
        }

        int answer = 0;
        for (String word : words) {
            int value = 0;
            for (int i = 0; i < word.length(); i++) {
                value = value * 10 + result[word.charAt(i) - 'A'];
            }
            answer += value;
        }

        System.out.println(answer);
    }
}