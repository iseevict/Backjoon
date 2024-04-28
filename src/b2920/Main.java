package b2920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int check = -1;
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                if (arr[i] == 1) {
                    check = 0;
                }
                else if (arr[i] == 8) {
                    check = 1;
                }
                else {
                    check = 2;
                    break;
                }
            }
            else {
                if (check == 0) {
                    if (arr[i] < arr[i - 1]) {
                        check = 2;
                        break;
                    }
                }
                else {
                    if (arr[i] > arr[i - 1]) {
                        check = 2;
                        break;
                    }
                }
            }
        }
        switch(check) {
            case 0 :
                System.out.println("ascending");
                break;
            case 1 :
                System.out.println("descending");
                break;
            case 2 :
                System.out.println("mixed");
        }
    }
}
