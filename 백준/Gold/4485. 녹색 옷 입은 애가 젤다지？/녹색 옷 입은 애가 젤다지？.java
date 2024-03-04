import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static class Index {
        int r, c;

        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최단거리 초기화를 위한 적당히 큰 수
        final int INF = 987654321;

        int N = sc.nextInt();
        int prob = 0; // while문이 몇 번 반복되었는지 기록할 정수

        while (N > 0) {
            prob++;

            int[][] black = new int[N][N]; // 각 칸의 도둑루피
            int[][] dist = new int[N][N]; // 그동안 획득한 도둑루피의 합
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    black[i][j] = sc.nextInt();
                    dist[i][j] = INF;
                }
            }

            // BFS
            Queue<Index> queue = new LinkedList<Index>();
            dist[0][0] = black[0][0];
            queue.offer(new Index(0, 0));

            while (!queue.isEmpty()) {
                Index idx = queue.poll();

                for (int n = 0; n < 4; n++) {
                    int nr = idx.r + dr[n];
                    int nc = idx.c + dc[n];

                    if (isRange(nr, nc, N)) {
                        int nd = dist[idx.r][idx.c] + black[nr][nc];
                        if (dist[nr][nc] > nd) {
                            // 기록해둔 최단거리가 새로 구한 최단거리보다 길면 짧은것으로 갱신한다
                            dist[nr][nc] = nd;
                            queue.offer(new Index(nr, nc));
                        }
                    }
                }

            }

            // 출력
            System.out.println("Problem "+prob+": "+dist[N-1][N-1]);

            N = sc.nextInt(); // 여기서 0이 입력되면 while문 종료
        }

        sc.close();
    }

    public static boolean isRange(int r, int c, int N) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}