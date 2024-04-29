package b1181;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static int compareWord (String s1, String s2) {
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return 1;
            }
            else if (s1.charAt(i) > s2.charAt(i)) {
                return 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> arr = new LinkedList<>();
        N = Integer.parseInt(buf.readLine());
        while(N-- > 0) {
            String s = buf.readLine();
            if(arr.isEmpty()) {
                arr.add(s);
            }
            else {
                if (!arr.contains(s)) {
                    arr.add(s);
                }
            }
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return 1;
                else if (o1.length() < o2.length()) return -1;
                else {
                    if (compareWord(o1, o2) == 1) {
                        return -1;
                    }
                    else return 1;
                }
            }
        });
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
