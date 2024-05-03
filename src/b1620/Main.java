package b1620;

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
        String[] numIn = new String[100001];
        Map<String, Integer> nameIn = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String poketmon = buf.readLine();
            numIn[i] = poketmon;
            nameIn.put(poketmon, i);
        }
        for (int i = 0; i < M; i++) {
            String in = buf.readLine();
            char check = in.charAt(0);
            if (Character.isDigit(check)) { // 숫자 입력받음
                int num = Integer.parseInt(in);
                sb.append(numIn[num] + "\n");
            }
            else {
                sb.append(nameIn.get(in) + "\n");
            }
        }
        System.out.println(sb);
    }
}

