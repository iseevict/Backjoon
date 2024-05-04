package b2606;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        K = Integer.parseInt(buf.readLine());
        boolean[] visit = new boolean[N + 1];
        boolean[][] connect = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (!connect[left][right]) {
                connect[left][right] = true;
                connect[right][left] = true;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        visit[1] = true;
        que.add(1);
        int count = 0;

        while (!que.isEmpty()) {
            int n = que.poll();
            for (int i = 1; i <= N; i++) {
                if (n != i) {
                    if (connect[n][i]) {
                        if (!visit[i]) {
                            visit[i] = true;
                            que.add(i);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

