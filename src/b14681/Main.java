package b14681;

import java.io.*;
import java.util.*;

public class Main {
    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        x = Integer.parseInt(buf.readLine());
        y = Integer.parseInt(buf.readLine());

        if (x > 0 && y > 0) {
            System.out.println("1");
        }
        else if (x > 0 && y < 0) {
            System.out.println("4");
        }
        else if (x < 0 && y > 0) {
            System.out.println("2");
        }
        else if (x < 0 && y < 0) {
            System.out.println("3");
        }
    }
}

