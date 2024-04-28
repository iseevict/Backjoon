package b3052;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[42];
        int ans = 0;
        for (int i = 1; i <= 10; i++) {
            int temp = scan.nextInt();
            arr[temp % 42]++;
        }
        for (int i = 0; i <= 41; i++) {
            if (arr[i] > 0) ans++;
        }
        System.out.println(ans);
    }
}
