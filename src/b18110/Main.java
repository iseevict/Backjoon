package b18110;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(buf.readLine());
        if (n == 0) {
            System.out.println("0");
            return;
        }
        int a = (int)Math.round(n * 0.15);
        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(buf.readLine());
            arr.add(temp);
        }
        Collections.sort(arr);
        for (int i = a; i < n - a; i++) {
            sum += arr.get(i);
        }
        int down = n - 2 * a;
        int ans = (int)Math.round((double)sum / down);
        System.out.println(ans);
    }
}

