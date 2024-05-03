package b1764;

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
        Map<String, Boolean> name = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = buf.readLine();
            name.put(s, true);
        }
        for (int i = 0; i < M; i++) {
            String s = buf.readLine();
            if (name.containsKey(s)) {
                count++;
                ans.add(s);
            }
        }
        Collections.sort(ans);
        sb.append(count + "\n");
        for (String s : ans) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}


