import java.util.Scanner;

public class Main {

    static int N, max;
    static int[][] bamboo;
    static int[][] save;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        bamboo = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bamboo[i][j] = sc.nextInt();
            }
        }

        // DFS
        save = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max( dfs(i, j), max );
            }
        }

        System.out.println(max);
        sc.close();
    }

    public static int dfs(int r, int c) {
        if (save[r][c] == 0) {
            int depth = 1;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isRange(nr, nc) && bamboo[nr][nc] > bamboo[r][c]) {
                    depth = Math.max(depth, dfs(nr, nc)+1);
                }
            }
            save[r][c] = depth;
        }
        return save[r][c];
    }

    public static boolean isRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}