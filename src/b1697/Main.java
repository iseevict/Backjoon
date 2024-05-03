package b1697;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visit = new int[100001];

    static int bfs(int pos) {
        Queue<Integer> que = new LinkedList<>();
        que.add(pos);
        while (!que.isEmpty()) {
            int n = que.poll();
            if (n == K) {
                return visit[n];
            }
            if (n - 1 >= 0 && visit[n - 1] == 0) {
                que.add(n - 1);
                visit[n - 1] = visit[n] + 1;
            }
            if (n + 1 <= 100000 && visit[n + 1] == 0) {
                que.add(n + 1);
                visit[n + 1] = visit[n] + 1;
            }
            if (n * 2 <= 100000 && visit[n * 2] == 0) {
                que.add(n * 2);
                visit[n * 2] = visit[n] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        System.out.println(bfs(N));
    }
}

