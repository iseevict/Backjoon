package b2667;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] home = new boolean[627][627];
    static boolean[][] visit = new boolean[627][627];

    static int bfs(int x, int y) {
        visit[x][y] = true;
        int number = 1;
        Queue<Map<Integer, Integer>> que = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(x, y);
        que.add(map);

        while (!que.isEmpty()) {
            Map<Integer, Integer> m = que.poll();
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int xPos = entry.getKey(); // 2
                int yPos = entry.getValue(); // 1

                if (xPos - 1 > 0 && home[xPos - 1][yPos] && !visit[xPos - 1][yPos]) { // 왼쪽 이동
                    visit[xPos - 1][yPos] = true;
                    number++;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos - 1, yPos);
                    que.add(mm);
                }

                if (xPos + 1 <= N && home[xPos + 1][yPos] && !visit[xPos + 1][yPos]) {
                    visit[xPos + 1][yPos] = true;
                    number++;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos + 1, yPos);
                    que.add(mm);
                }

                if (yPos - 1 > 0 && home[xPos][yPos - 1] && !visit[xPos][yPos - 1]) {
                    visit[xPos][yPos - 1] = true;
                    number++;
                    Map<Integer,Integer> mm = new HashMap<>();
                    mm.put(xPos, yPos - 1);
                    que.add(mm);
                }

                if (yPos + 1 <= N && home[xPos][yPos + 1] && !visit[xPos][yPos + 1]) {
                    visit[xPos][yPos + 1] = true;
                    number++;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos, yPos + 1);
                    que.add(mm);
                }
            }
        }

        return number;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        for (int i = 1; i <= N; i++) {
            char[] cArr = buf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (cArr[j] == '1') {
                    home[j + 1][i] = true;
                }
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (home[j][i] && !visit[j][i]) {
                    int num = bfs(j, i);
                    count++;
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        sb.append(count + "\n");
        for (int i : list) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}


