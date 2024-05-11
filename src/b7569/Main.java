package b7569;

import java.io.*;
import java.util.*;

class posXYZ {
    int x;
    int y;
    int z;
    int date;

    public posXYZ(int xPos, int yPos, int zPos, int date) {
        x = xPos;
        y = yPos;
        z = zPos;
        this.date = date;
    }
}

public class Main {
    static int N, M, H;
    static int[][][] tomato = new int[102][102][102];
    static boolean[][][] visit = new boolean[102][102][102];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Queue<posXYZ> que = new LinkedList<>();
        int count = 0; // case 1. 전부 익었는지 확인하기 위함
        int all = N * M * H; // case2. 1과 -1로만 들어올 경우를 확인하기 위함
        int oneCount = 0; // case2
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= M; j++) {
                StringTokenizer st2 = new StringTokenizer(buf.readLine());
                for (int k = 1; k <= N; k++) {
                    int tempNum = Integer.parseInt(st2.nextToken());
                    tomato[k][j][i] = tempNum;
                    if (tempNum == -1) {
                        visit[k][j][i] = true;
                        all--;
                    }
                    else if (tempNum == 0) {
                        count++;
                    }
                    else {
                        que.add(new posXYZ(k, j, i, 0));
                        oneCount++;
                    }
                }
            }
        }
        int ans = 0;
        if (oneCount == all) { // case2
            System.out.println(ans);
            return;
        }
        while (!que.isEmpty()) {
            posXYZ temp = que.poll();

            int x = temp.x;
            int y = temp.y;
            int z = temp.z;
            int date = temp.date;

            if (ans < date) {
                ans = date;
            }

            if (!visit[x][y][z]) visit[x][y][z] = true;

            if (x - 1 > 0 && !visit[x - 1][y][z] && tomato[x - 1][y][z] == 0) { // 좌 이동
                visit[x - 1][y][z] = true;
                tomato[x - 1][y][z] = 1;
                que.add(new posXYZ(x - 1, y, z, date + 1));
                count--;
            }

            if (x + 1 <= N && !visit[x + 1][y][z] && tomato[x + 1][y][z] == 0) { // 우 이동
                visit[x + 1][y][z] = true;
                tomato[x + 1][y][z] = 1;
                que.add(new posXYZ(x + 1, y, z, date + 1));
                count--;
            }

            if (y - 1 > 0 && !visit[x][y - 1][z] && tomato[x][y - 1][z] == 0) { // 상 이동
                visit[x][y - 1][z] = true;
                tomato[x][y - 1][z] = 1;
                que.add(new posXYZ(x, y - 1, z, date + 1));
                count--;
            }

            if (y + 1 <= M && !visit[x][y + 1][z] && tomato[x][y + 1][z] == 0) { // 하 이동
                visit[x][y + 1][z] = true;
                tomato[x][y + 1][z] = 1;
                que.add(new posXYZ(x, y + 1, z, date + 1));
                count--;
            }

            if (z - 1 > 0 && !visit[x][y][z - 1] && tomato[x][y][z - 1] == 0) { // 위 이동
                visit[x][y][z - 1] = true;
                tomato[x][y][z - 1] = 1;
                que.add(new posXYZ(x, y, z - 1, date + 1));
                count--;
            }

            if (z + 1 <= H && !visit[x][y][z + 1] && tomato[x][y][z + 1] == 0) { // 아래 이동
                visit[x][y][z + 1] = true;
                tomato[x][y][z + 1] = 1;
                que.add(new posXYZ(x, y, z + 1, date + 1));
                count--;
            }
        }
        if (count != 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(ans);
    }
}

