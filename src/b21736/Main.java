package b21736;

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
        int[][] campus = new int[602][602];
        int x = 0;
        int y = 0;
        for (int i = 1; i <= N; i++) {
            char[] arr = buf.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                if (arr[j - 1] == 'O') {
                    campus[j][i] = 1;
                }
                else if (arr[j - 1] == 'P') {
                    campus[j][i] = 2;
                }
                else if (arr[j - 1] == 'I') {
                    x = j;
                    y = i;
                }
                else {
                    campus[j][i] = -1;
                }
            }
        }
        int count = 0;

        Queue<Map<Integer, Integer>> que = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(x, y);
        que.add(map);
        boolean[][] visit = new boolean[602][602];
        visit[x][y] = true;

        while (!que.isEmpty()) {
            Map<Integer, Integer> m = que.poll();
            for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int xPos = entry.getKey();
                int yPos = entry.getValue();

                if (xPos - 1 > 0 && !visit[xPos - 1][yPos] && campus[xPos - 1][yPos] > 0) {
                    if (campus[xPos - 1][yPos] == 2) {
                        count++;
                    }
                    visit[xPos - 1][yPos] = true;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos - 1, yPos);
                    que.add(mm);
                }

                if (xPos + 1 <= M && !visit[xPos + 1][yPos] && campus[xPos + 1][yPos] > 0) {
                    if (campus[xPos + 1][yPos] == 2) {
                        count++;
                    }
                    visit[xPos + 1][yPos] = true;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos + 1, yPos);
                    que.add(mm);
                }

                if (yPos - 1 > 0 && !visit[xPos][yPos - 1] && campus[xPos][yPos - 1] > 0) {
                    if (campus[xPos][yPos - 1] == 2) {
                        count++;
                    }
                    visit[xPos][yPos - 1] = true;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos, yPos - 1);
                    que.add(mm);
                }

                if (yPos + 1 <= N && !visit[xPos][yPos + 1] && campus[xPos][yPos + 1] > 0) {
                    if (campus[xPos][yPos + 1] == 2) {
                        count++;
                    }
                    visit[xPos][yPos + 1] = true;
                    Map<Integer, Integer> mm = new HashMap<>();
                    mm.put(xPos, yPos + 1);
                    que.add(mm);
                }
            }
        }
        if (count == 0) {
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }
}

