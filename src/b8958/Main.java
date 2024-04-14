package b8958;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buf.readLine());
        for(int i = 0; i < N; i++) {
            String st = buf.readLine();
            int count = 0;
            boolean check = false;
            int checkNum = 1;
            String[] arr = st.split("");
            for(int j = 0; j < arr.length; j++) {
                if (arr[j].equals("O")) {
                    if (check) {
                        count += checkNum;
                        checkNum++;
                    }
                    else {
                        count++;
                        check = true;
                        checkNum++;
                    }
                }
                else {
                    check = false;
                    checkNum = 1;
                }
            }
            System.out.println(count);
        }
    }
}
