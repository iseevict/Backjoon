package b1157;

import java.io.*;
import java.util.*;

public class Main { // 32차이 대문자 - 소문자 = 32 A = 65
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[150];
        int max = -1;
        int pos = 0;
        char[] arr = buf.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 65; i < 91; i++) {
            count[i] += count[i+32];
        }
        for (int i = 65; i < 91; i++) {
            if (count[i] > max) {
                max = count[i];
                pos = i;
            }
        }
        int temp = 0;
        for (int i = 65; i < 91; i++) {
            if (count[i] == max) temp++;
        }
        if (temp > 1) {
            System.out.println("?");
        }
        else {
            System.out.println((char)pos);
        }
    }
}
