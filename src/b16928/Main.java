package b16928;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] move = new int[101];
    static boolean[] visit = new boolean[101];
    static int[] dx = {1, 2, 3, 4, 5, 6};

    static class pos {
        int pos;
        int count;

        public pos(int p, int c) {
            this.pos = p;
            this.count = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            move[left] = right;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            move[left] = right;
        }
        Queue<pos> que = new LinkedList<>();
        que.add(new pos(1, 0));
        visit[1] = true;
        int min = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            pos p = que.poll();
            int nowPos = p.pos;
            int count = p.count;
            if (nowPos == 100) {
                min = Math.min(min, count);
                continue;
            }

            for (int i = 0; i < 6; i++) {
                int nextPos = nowPos + dx[i];

                if (nextPos > 100) continue;

                if (move[nextPos] == 0) {
                    if (!visit[nextPos]) {
                        que.add(new pos(nextPos, count + 1));
                        visit[nextPos] = true;
                    }
                }
                else {
                    if (!visit[move[nextPos]]) {
                        que.add(new pos(move[nextPos], count + 1));
                        visit[move[nextPos]] = true;
                    }
                }
            }
        }
        System.out.println(min);
    }
}



