package b1260;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static Stack<Integer> dfs = new Stack<>();
    static Stack<Integer> bfs = new Stack<>();
    static Queue<Integer> que = new LinkedList<>();

    static void bfs (int start, boolean[] check) {
        if (!check[start]) {
            check[start] = true;
            bfs.push(start);
            if (tree.containsKey(start)) {
                List<Integer> arr = tree.get(start);
                for (int i = 0; i < arr.size(); i++) {
                    que.add(arr.get(i));
                }
                while (!que.isEmpty()) {
                    int num = que.remove();
                    bfs(num, check);
                }
            }
        }
    }

    static void dfs (int start, boolean[] check) {
        if (!check[start]) {
            check[start] = true;
            dfs.push(start);
            if (tree.containsKey(start)) {
                List<Integer> arr = tree.get(start);
                for (int i = 0; i < arr.size(); i++) {
                    dfs(arr.get(i), check);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        boolean[] checkDFS = new boolean[N + 1];
        boolean[] checkBFS = new boolean[N + 1];
        for (int i = 0; i < M; i++) { // 그래프 생성
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st2.nextToken());
            int right = Integer.parseInt(st2.nextToken());
            if (tree.containsKey(left)) {
                tree.get(left).add(right);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(right);
                tree.put(left, temp);
            }
            if (tree.containsKey(right)) {
                tree.get(right).add(left);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                tree.put(right, temp);
            }
        }

        for (int i = 1; i <= N; i++) { // 오름차순 정렬
            if (tree.containsKey(i)) {
                Collections.sort(tree.get(i));
            }
        }

        dfs(V, checkDFS);
        bfs(V, checkBFS);
        Stack<Integer> ans = new Stack<>();

        int dfsSize = dfs.size();
        int bfsSize = bfs.size();

        for (int i = 0; i < dfsSize; i++) {
            ans.push(dfs.pop());
        }
        for (int i = 0; i < dfsSize; i++) {
            sb.append(ans.pop() + " ");
        }
        sb.append("\n");
        for (int i = 0; i < bfsSize; i++) {
            ans.push(bfs.pop());
        }
        for (int i = 0; i < bfsSize; i++) {
            sb.append(ans.pop() + " ");
        }
        System.out.println(sb);
    }
}

