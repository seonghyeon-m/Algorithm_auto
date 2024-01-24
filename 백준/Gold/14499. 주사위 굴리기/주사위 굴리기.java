import java.util.Scanner;

public class Main {

    static class Dice {

        // 북쪽은 back, 서쪽은 left로 표시하였다.
        int up, down, right, left, back, front;

        public Dice(int up, int down, int right, int left, int back, int front) {
            this.up = up;
            this.down = down;
            this.right = right;
            this.left = left;
            this.back = back;
            this.front = front;
        }
    }

    static Dice dice = new Dice(0, 0, 0, 0, 0, 0);
    static int N, M, x, y;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 지도의 세로 크기
        M = sc.nextInt(); // 지도의 가로 크기
        x = sc.nextInt(); // 주사위의 좌표(가로)
        y = sc.nextInt(); // 주사위의 좌표(세로)
        int K = sc.nextInt(); // 명령의 개수

        // 지도 정보 받기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 명령 처리
        for (int o = 0; o < K; o++) {
            int order = sc.nextInt();
            roll(order);
        }

        sc.close();
    }

    public static void roll(int order) {

        // 주사위를 굴려보자
        if (order == 1) {
            // 동쪽으로 굴러라
            if (isOnMap(x, y+1)) {
                dice = new Dice(dice.left, dice.right, dice.up, dice.down, dice.back, dice.front);
                y = y+1;
            } else {
                return;
            }
        } else if (order == 2) {
            // 서쪽으로 굴러라
            if (isOnMap(x, y-1)) {
                dice = new Dice(dice.right, dice.left, dice.down, dice.up, dice.back, dice.front);
                y = y-1;
            } else {
                return;
            }
        } else if (order == 3) {
            // 북쪽으로 굴러라
            if (isOnMap(x-1, y)) {
                dice = new Dice(dice.front, dice.back, dice.right, dice.left, dice.up, dice.down);
                x = x-1;
            } else {
                return;
            }
        } else {
            // 남쪽으로 굴러라
            if (isOnMap(x+1, y)) {
                dice = new Dice(dice.back, dice.front, dice.right, dice.left, dice.down, dice.up);
                x = x+1;
            } else {
                return;
            }
        }

        // 실제로 주사위가 굴렀으면 주사위 바닥면이랑 지도의 숫자를 교환한다.
        if (map[x][y] == 0) {
            map[x][y] = dice.down;
        } else {
            dice.down = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice.up);
    }

    public static boolean isOnMap(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}