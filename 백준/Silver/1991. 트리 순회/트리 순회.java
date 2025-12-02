import java.io.*;
import java.util.*;

public class Main {
    static int[][] tree = new int[26][2];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            tree[i][0] = tree[i][1] = -1;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') tree[root - 'A'][0] = left - 'A';
            if (right != '.') tree[root - 'A'][1] = right - 'A';
        }
        
        preorder(0);
        inorder(0);
        postorder(0);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    
    static void preorder(int curr) {
        if (curr == -1) return;
        pre.append((char) (curr + 'A'));
        preorder(tree[curr][0]);
        preorder(tree[curr][1]);
    }
    
    static void inorder(int curr) {
        if (curr == -1) return;
        inorder(tree[curr][0]);
        in.append((char) (curr + 'A'));
        inorder(tree[curr][1]);
    }
    
    static void postorder(int curr) {
        if (curr == -1) return;
        postorder(tree[curr][0]);
        postorder(tree[curr][1]);
        post.append((char) (curr + 'A'));
    }
}