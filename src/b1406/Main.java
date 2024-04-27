package b1406;

import java.util.*;
import java.io.*;

public class Main {
    static String str;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        str = buf.readLine();
        M = Integer.parseInt(buf.readLine());
        List<String> arrChar = new LinkedList<String>();
        String temp[] = str.split("");
        for (String t : temp) {
            arrChar.add(t);
        }
        ListIterator<String> origin = arrChar.listIterator();
        while (origin.hasNext()) {
            origin.next();
        }
        do {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            String tempStr = st.nextToken();
            switch(tempStr.charAt(0)) {
                case 'L' :
                    if (origin.hasPrevious()) {
                        origin.previous();
                    }
                    break;
                case 'D' :
                    if (origin.hasNext()) {
                        origin.next();
                    }
                    break;
                case 'B' :
                    if (origin.hasPrevious()) {
                        origin.previous();
                        origin.remove();
                    }
                    break;
                case 'P' :
                    String x = st.nextToken();
                    origin.add(x);
                    break;
            }
        } while (--M > 0);
        System.out.println(String.join("", arrChar));
    }
}
