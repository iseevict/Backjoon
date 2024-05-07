package b11723;

import java.io.*;
import java.util.*;

public class Main {
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(buf.readLine());
        Set<Integer> set = new TreeSet<>();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            String s = st.nextToken();
            switch(s) {
                case "add":
                    int inAdd = Integer.parseInt(st.nextToken());
                    if (!set.contains(inAdd)) {
                        set.add(inAdd);
                    }
                    break;
                case "check":
                    int inCheck = Integer.parseInt(st.nextToken());
                    if (set.contains(inCheck)) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;
                case "remove":
                    int inRemove = Integer.parseInt(st.nextToken());
                    if (set.contains(inRemove)) {
                        set.remove(inRemove);
                    }
                    break;
                case "toggle":
                    int inToggle = Integer.parseInt(st.nextToken());
                    if (set.contains(inToggle)) {
                        set.remove(inToggle);
                    }
                    else {
                        set.add(inToggle);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
                case "all":
                    set.clear();
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}

