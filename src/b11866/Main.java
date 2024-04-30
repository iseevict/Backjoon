package b11866;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            que.add(i);
        }
        while (!que.isEmpty()) {
            for(int i = 1; i <= K; i++) {
                int temp;
                if (i == K) {
                    temp = que.remove();
                    ans.add(temp);
                }
                else {
                    temp = que.remove();
                    que.add(temp);
                }
            }
        }
        sb.append("<");
        int count = ans.size();
        for (int n : ans) {
            sb.append(n);
            count--;
            if (count >= 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
