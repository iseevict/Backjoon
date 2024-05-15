package b9019;

import java.io.*;
import java.util.*;

public class Main {
    static int T;

    static int D(int left) {
        left = left * 2;
        if (left > 9999) {
            left = left % 10000;
        }
        return left;
    }

    static int S(int left) {
        left -= 1;
        if (left == -1) left = 9999;
        return left;
    }

    static int L(int left) {
        left = (left * 10) % 10000 + (left / 1000);
        return left;
    }

    static int R(int left) {
        left = (left / 10) + (left % 10) * 1000;
        return left;
    }

    static class map {
        int value;
        String list;

        map(int n, String c) {
            this.value = n;
            this.list = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        Loop1:
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[10000];
            Queue<map> que = new LinkedList<>();
            String list = "";
            que.add(new map(left, list));
            visit[left] = true;

            while (!que.isEmpty()) {
                map m = que.poll();
                int value = m.value;
                String s = m.list;

                if (value == right) {
                    sb.append(s + "\n");
                    continue Loop1;
                }

                int tempD = D(value);
                int tempS = S(value);
                int tempL = L(value);
                int tempR = R(value);

                if (!visit[tempD]) {
                    String Ds = new String(s);
                    Ds = Ds + "D";
                    que.add(new map(tempD, Ds));
                    visit[tempD] = true;
                }

                if (!visit[tempS]) {
                    String Ss = new String(s);
                    Ss = Ss + "S";
                    que.add(new map(tempS, Ss));
                    visit[tempS] = true;
                }

                if (!visit[tempL]) {
                    String Ls = new String(s);
                    Ls = Ls + "L";
                    que.add(new map(tempL, Ls));
                    visit[tempL] = true;
                }

                if (!visit[tempR]) {
                    String Rs = new String(s);
                    Rs = Rs + "R";
                    que.add(new map(tempR, Rs));
                    visit[tempR] = true;
                }
            }
        }
        System.out.println(sb);
    }
}

