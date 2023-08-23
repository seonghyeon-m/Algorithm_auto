import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            //tc시작
            int N = sc.nextInt();
            int[] tree = new int[N];
            for (int i = 0; i < N; i++) {
                tree[i] = sc.nextInt();
            }
            
            Arrays.sort(tree);
            
            int[] newTree = new int[N];
            int p = 0;
            int q = N-1;
            int idx = 0;
            while (idx < N) {
                newTree[p] = tree[idx];
                p++;
                idx++;
                if (idx == N) break;
                newTree[q] = tree[idx];
                q--;
                idx++;
            }
            
            int level = 0;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if (i == N-1) temp = Math.abs(newTree[0] - newTree[i]);
                else {
                    temp = Math.abs(newTree[i+1] - newTree[i]);
                }
                if (temp > level) level = temp;
            }
            
            System.out.println(level);
            
            //tc끝
        }
        sc.close();
    }
}