package b2178;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] miro = new boolean[102][102];
    static boolean[][] visit = new boolean[102][102];
    static int count = Integer.MAX_VALUE;

    static void bfs(int x, int y) {
        Queue<Map<Map<Integer, Integer>, Integer>> que = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
        map.put(x, y);
        m.put(map, 1);
        que.add(m);

        while (!que.isEmpty()) {
            Map<Map<Integer, Integer>, Integer> tPos = que.poll();
            int move = -1;
            int xPos = -1;
            int yPos = -1;

            for (Map.Entry<Map<Integer, Integer>, Integer> entry : tPos.entrySet()) {
                Map<Integer, Integer> pos = entry.getKey();
                move = entry.getValue();
                for (Map.Entry<Integer, Integer> ent : pos.entrySet()) {
                    xPos = ent.getKey();
                    yPos = ent.getValue();

                    if (visit[xPos][yPos]) {
                        continue;
                    }
                    else {
                        visit[xPos][yPos] = true;
                    }

                    if (xPos == M && yPos == N) {
                        if (count > move) {
                            count = move;
                        }
                    }
                    else {
                        if (xPos - 1 > 0 && !visit[xPos - 1][yPos] && miro[xPos - 1][yPos]) { // 왼쪽으로 이동

                            Map<Integer, Integer> mm = new HashMap<>();
                            Map<Map<Integer, Integer>, Integer> mmi = new HashMap<>();
                            mm.put(xPos - 1, yPos);
                            mmi.put(mm, move + 1);
                            que.add(mmi);
                        }
                        if (xPos + 1 <= M && !visit[xPos + 1][yPos] && miro[xPos + 1][yPos]) { // 오른쪽으로 이동

                            Map<Integer, Integer> mm = new HashMap<>();
                            Map<Map<Integer, Integer>, Integer> mmi = new HashMap<>();
                            mm.put(xPos + 1, yPos);
                            mmi.put(mm, move + 1);
                            que.add(mmi);
                        }
                        if (yPos - 1 > 0 && !visit[xPos][yPos - 1] && miro[xPos][yPos - 1]) { // 위로 이동

                            Map<Integer, Integer> mm = new HashMap<>();
                            Map<Map<Integer, Integer>, Integer> mmi = new HashMap<>();
                            mm.put(xPos, yPos - 1);
                            mmi.put(mm, move + 1);
                            que.add(mmi);
                        }
                        if (yPos + 1 <= N && !visit[xPos][yPos + 1] && miro[xPos][yPos + 1]) { // 아래로 이동

                            Map<Integer, Integer> mm = new HashMap<>();
                            Map<Map<Integer, Integer>, Integer> mmi = new HashMap<>();
                            mm.put(xPos, yPos + 1);
                            mmi.put(mm, move + 1);
                            que.add(mmi);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            char[] c = buf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (c[j] == '1') {
                    miro[j + 1][i] = true;
                }
            }
        }
        bfs(1, 1);
        System.out.println(count);
    }
}

