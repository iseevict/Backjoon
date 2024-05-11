package b9375;

import java.io.*;
import java.util.*;

public class Main {
    static int T, n;

    static int nCn (int n, int c) {
        int result = 0;
        if (n == c) {
            return 1;
        }
        if (n - c < c) {
            c = n - c;
        }
        int top = 1;
        int down = 1;
        for (int i = n; i > n - c; i--) {
            top = top * i;
        }
        for (int i = 1; i <= c; i++) {
            down = down * i;
        }
        result = top / down;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(buf.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(buf.readLine());
                String right = st.nextToken();
                String left = st.nextToken();
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                }
                else {
                    map.put(left, 2);
                }
            }
            int ans = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String s = entry.getKey();
                int count = entry.getValue();
                ans = ans * count;
            }
            sb.append(ans - 1 + "\n");
        }
        System.out.println(sb);
    }
}


