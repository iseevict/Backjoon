package b1259;

import java.io.*;
import java.util.*;

public class Main {

    static boolean check(int num) {
        int len = (int)Math.log10(num) + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = num % 10;
            num /= 10;
        }
        for(int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if (n == 0) break;
            else {
                if (check(n)) {
                    sb.append("yes\n");
                }
                else {
                    sb.append("no\n");
                }
            }
        }
        System.out.println(sb);
    }
}
