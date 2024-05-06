package b7576;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] tomato = new int[1002][1002];
    static boolean[][] exist = new boolean[1002][1002]; // true : 존재하지않음, // false : 존재함
    static boolean[][] visit = new boolean[1002][1002]; // true : 들린곳
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Deque<Map<Map<Integer, Integer>, Integer>> que = new LinkedList<>();
        boolean zero = false;
        for (int i = 1; i <= M; i++) {
            StringTokenizer st1 = new StringTokenizer(buf.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st1.nextToken());
                if (temp == -1) {
                    exist[j][i] = true;
                }
                else if (temp == 0) {
                    zero = true;
                }
                else if (temp == 1) {
                    Map<Integer, Integer> map = new HashMap<>();
                    Map<Map<Integer, Integer>, Integer> mmap = new HashMap<>();
                    map.put(j, i);
                    mmap.put(map, 0);
                    que.add(mmap);
                    exist[j][i] = true;
                }
                tomato[j][i] = temp;
            }
        }

        if (!zero) {
            System.out.println("0");
            return;
        }
        int ans = 0;
        while (!que.isEmpty()) {
            Map<Map<Integer, Integer>, Integer> tempMMap = que.removeFirst();
            for (Map.Entry<Map<Integer, Integer>, Integer> entry : tempMMap.entrySet()) {
                Map<Integer, Integer> tempMap = entry.getKey();
                int count = entry.getValue();
                for (Map.Entry<Integer, Integer> entryEntry : tempMap.entrySet()) {
                    int x = entryEntry.getKey();
                    int y = entryEntry.getValue();
                    visit[x][y] = true;
                    if (ans < count) ans = count;

                    if (x - 1 > 0 && tomato[x - 1][y] == 0 && !visit[x - 1][y]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        m.put(x - 1, y);
                        mm.put(m, count + 1);
                        que.add(mm);
                        visit[x - 1][y] = true;
                        tomato[x - 1][y] = 1;
                    }

                    if (x + 1 < N + 1 && tomato[x + 1][y] == 0 && !visit[x + 1][y]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        m.put(x + 1, y);
                        mm.put(m, count + 1);
                        que.add(mm);
                        visit[x + 1][y] = true;
                        tomato[x + 1][y] = 1;
                    }

                    if (y - 1 > 0 && tomato[x][y - 1] == 0 && !visit[x][y - 1]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        m.put(x, y - 1);
                        mm.put(m, count + 1);
                        que.add(mm);
                        visit[x][y - 1] = true;
                        tomato[x][y - 1] = 1;
                    }

                    if (y + 1 < M + 1 && tomato[x][y + 1] == 0 && !visit[x][y + 1]) {
                        Map<Integer, Integer> m = new HashMap<>();
                        Map<Map<Integer, Integer>, Integer> mm = new HashMap<>();
                        m.put(x, y + 1);
                        mm.put(m, count + 1);
                        que.add(mm);
                        visit[x][y + 1] = true;
                        tomato[x][y + 1] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (tomato[j][i] == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(ans);

    }
}

