import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[3][N];
        int[][] minCost = new int[3][N];

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < 3; i++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // 첫 줄 채워넣기
        for (int i = 0; i < 3; i++) {
            minCost[i][0] = cost[i][0];
        }

        // 나머지 줄 채워넣기
        for (int i = 1; i < N; i++) {

            /*
             * 0번 열의 정보를 채워 넣을 때에는
             * 앞의 행 1번이나 2번 열의 값 중 최소값을 채택해
             * 해당 집을 0번 색으로 칠하는 값을 더해 기록한다.
             */

            minCost[0][i] = Math.min(minCost[1][i - 1], minCost[2][i - 1]) +cost[0][i];
            minCost[1][i] = Math.min(minCost[0][i - 1], minCost[2][i - 1]) +cost[1][i];
            minCost[2][i] = Math.min(minCost[0][i - 1], minCost[1][i - 1]) +cost[2][i];

        }

        System.out.println(Math.min(Math.min(minCost[0][N-1], minCost[1][N-1]), minCost[2][N-1]));

        sc.close();
    }
}