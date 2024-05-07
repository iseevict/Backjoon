package b14940;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] ground = new boolean[1002][1002];
        int[][] street = new int[1002][1002];
        boolean[][] visit = new boolean[1002][1002];
        int startX = 0;
        int startY = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            for (int j = 1; j <= M; j++) {
                int n = Integer.parseInt(st2.nextToken());
                if (n == 2) {
                    startX = j;
                    startY = i;
                    ground[j][i] = true;
                }
                else if (n == 1) {
                    ground[j][i] = true;
                }
            }
        }
        Queue<Map<Map<Integer, Integer>, Integer>> que = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(startX, startY);
        Map<Map<Integer, Integer>, Integer> mmap = new HashMap<>();
        mmap.put(map, 0);
        visit[startX][startY] = true;
        street[startX][startY] = 0;
        que.add(mmap);

        while (!que.isEmpty()) {
            Map<Map<Integer, Integer>, Integer> tempMMap = que.poll();
            for (Map.Entry<Map<Integer, Integer>, Integer> mEntry : tempMMap.entrySet()) {
                int count = mEntry.getValue();
                Map<Integer, Integer> tempMap = mEntry.getKey();
                for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                    int x = entry.getKey();
                    int y = entry.getValue();

                    if (x - 1 > 0 && !visit[x - 1][y] && ground[x - 1][y]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(x - 1, y);
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        mm.put(m, count + 1);
                        visit[x - 1][y] = true;
                        street[x - 1][y] = count + 1;
                        que.add(mm);
                    }
                    if (x + 1 <= M && !visit[x + 1][y] && ground[x + 1][y]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(x + 1, y);
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        mm.put(m, count + 1);
                        visit[x + 1][y] = true;
                        street[x + 1][y] = count + 1;
                        que.add(mm);
                    }
                    if (y - 1 > 0 && !visit[x][y - 1] && ground[x][y - 1]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(x, y - 1);
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        mm.put(m, count + 1);
                        visit[x][y - 1] = true;
                        street[x][y - 1] = count + 1;
                        que.add(mm);
                    }
                    if (y + 1 <= N && !visit[x][y + 1] && ground[x][y + 1]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(x, y + 1);
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        mm.put(m, count + 1);
                        visit[x][y + 1] = true;
                        street[x][y + 1] = count + 1;
                        que.add(mm);
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (street[j][i] == 0) {
                    if (j != startX || i != startY) {
                        if (ground[j][i]) {
                            sb.append("-1 ");
                            continue;
                        }
                    }
                }
                sb.append(street[j][i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

