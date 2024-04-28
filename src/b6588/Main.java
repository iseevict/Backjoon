package b6588;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[1000001]; // true : 소수 아님 false : 소수임

    static boolean run(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        check[1] = true;
        for (int i = 2; i * i <= check.length; i++) {
            if (check[i]) {
                continue;
            }
            else {
                if (run(i)) {
                    for (int j = 2; j * i < check.length; j++) {
                        if (!check[j * i]) check[j * i] = true;
                    }
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            if (num == 0) break;
            else {
                for (int i = 3; i <= num / 2; i++) {
                    if (!check[i]) {
                        if (!check[num - i]) {
                            sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append("\n");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
