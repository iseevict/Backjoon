package b17219;

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
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            String s1 = st2.nextToken();
            String s2 = st2.nextToken();
            map.put(s1, s2);
        }
        for (int i = 0; i < M; i++) {
            String s = buf.readLine();
            sb.append(map.get(s) + "\n");
        }
        System.out.println(sb);
    }
}

