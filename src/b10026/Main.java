package b10026;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] pic = new int[102][102]; // 0 : B / 1 : R / 2 : G
    static boolean[][] noVisit = new boolean[102][102];
    static boolean[][] yesVisit = new boolean[102][102];

    static class xyPos {
        int x;
        int y;

        public xyPos(int xPos, int yPos) {
            x = xPos;
            y = yPos;
        }
    }

    static void run(int xPos, int yPos, boolean btn) {
        int colorNum = pic[xPos][yPos];
        Queue<xyPos> que = new LinkedList<>();
        que.add(new xyPos(xPos, yPos));

        if (btn) {
            boolean a = false;
            if (colorNum == 1 || colorNum == 2) {
                a = true;
            }
            yesVisit[xPos][yPos] = true;
            if (a) {
                while (!que.isEmpty()) {
                    xyPos xy = que.poll();
                    int x = xy.x;
                    int y = xy.y;

                    if (x - 1 > 0 && !yesVisit[x - 1][y] && (pic[x - 1][y] == 1 || pic[x - 1][y] == 2)) {
                        yesVisit[x - 1][y] = true;
                        xyPos tempXY = new xyPos(x - 1, y);
                        que.add(tempXY);
                    }

                    if (x + 1 <= N && !yesVisit[x + 1][y] && (pic[x + 1][y] == 1 || pic[x + 1][y] == 2)) {
                        yesVisit[x + 1][y] = true;
                        xyPos tempXY = new xyPos(x + 1, y);
                        que.add(tempXY);
                    }

                    if (y - 1 > 0 && !yesVisit[x][y - 1] && (pic[x][y - 1] == 1 || pic[x][y - 1] == 2)) {
                        yesVisit[x][y - 1] = true;
                        xyPos tempXY = new xyPos(x, y - 1);
                        que.add(tempXY);
                    }

                    if (y + 1 <= N && !yesVisit[x][y + 1] && (pic[x][y + 1] == 1 || pic[x][y + 1] == 2)) {
                        yesVisit[x][y + 1] = true;
                        xyPos tempXY = new xyPos(x, y + 1);
                        que.add(tempXY);
                    }
                }
            }
            else {
                while (!que.isEmpty()) {
                    xyPos xy = que.poll();
                    int x = xy.x;
                    int y = xy.y;

                    if (x - 1 > 0 && !yesVisit[x - 1][y] && pic[x - 1][y] == colorNum) {
                        yesVisit[x - 1][y] = true;
                        xyPos tempXY = new xyPos(x - 1, y);
                        que.add(tempXY);
                    }

                    if (x + 1 <= N && !yesVisit[x + 1][y] && pic[x + 1][y] == colorNum) {
                        yesVisit[x + 1][y] = true;
                        xyPos tempXY = new xyPos(x + 1, y);
                        que.add(tempXY);
                    }

                    if (y - 1 > 0 && !yesVisit[x][y - 1] && pic[x][y - 1] == colorNum) {
                        yesVisit[x][y - 1] = true;
                        xyPos tempXY = new xyPos(x, y - 1);
                        que.add(tempXY);
                    }

                    if (y + 1 <= N && !yesVisit[x][y + 1] && pic[x][y + 1] == colorNum) {
                        yesVisit[x][y + 1] = true;
                        xyPos tempXY = new xyPos(x, y + 1);
                        que.add(tempXY);
                    }
                }
            }

        }
        else {
            noVisit[xPos][yPos] = true;
            while (!que.isEmpty()) {
                xyPos xy = que.poll();
                int x = xy.x;
                int y = xy.y;

                if (x - 1 > 0 && !noVisit[x - 1][y] && pic[x - 1][y] == colorNum) {
                    noVisit[x - 1][y] = true;
                    xyPos tempXY = new xyPos(x - 1, y);
                    que.add(tempXY);
                }

                if (x + 1 <= N && !noVisit[x + 1][y] && pic[x + 1][y] == colorNum) {
                    noVisit[x + 1][y] = true;
                    xyPos tempXY = new xyPos(x + 1, y);
                    que.add(tempXY);
                }

                if (y - 1 > 0 && !noVisit[x][y - 1] && pic[x][y - 1] == colorNum) {
                    noVisit[x][y - 1] = true;
                    xyPos tempXY = new xyPos(x, y - 1);
                    que.add(tempXY);
                }

                if (y + 1 <= N && !noVisit[x][y + 1] && pic[x][y + 1] == colorNum) {
                    noVisit[x][y + 1] = true;
                    xyPos tempXY = new xyPos(x, y + 1);
                    que.add(tempXY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        for (int i = 1; i <= N; i++) {
            String[] s = buf.readLine().split("");
            for (int j = 0; j < N; j++) {
                switch (s[j]) {
                    case "R" :
                        pic[j + 1][i] = 1;
                        break;
                    case "B" :
                        pic[j + 1][i] = 0;
                        break;
                    case "G" :
                        pic[j + 1][i] = 2;
                        break;
                }
            }
        }
        int noCount = 0;
        int yesCount = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!noVisit[j][i] && !yesVisit[j][i]) {
                    run(j, i, true);
                    run(j, i, false);
                    noCount++;
                    yesCount++;
                }
                else if (!noVisit[j][i]) {
                    run(j, i, false);
                    noCount++;
                }
                else if (!yesVisit[j][i]) {
                    run(j, i, true);
                    yesCount++;
                }
            }
        }
        sb.append(noCount + " " + yesCount);
        System.out.println(sb);
    }
}


