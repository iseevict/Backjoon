package b2475;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int temp = scan.nextInt();
            ans = ans + (int)Math.pow(temp, 2);
        }
        System.out.println(ans % 10);
    }
}
