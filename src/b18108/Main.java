package b18108;

import java.io.*;
import java.util.*;

public class Main {
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        y = Integer.parseInt(buf.readLine());
        System.out.println(y - 543);
    }
}
