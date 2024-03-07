import java.util.Scanner;

public class Main {

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point A = new Point(sc.nextLong(), sc.nextLong());
        Point B = new Point(sc.nextLong(), sc.nextLong());
        Point C = new Point(sc.nextLong(), sc.nextLong());
        Point D = new Point(sc.nextLong(), sc.nextLong());

        // 만약 네 점이 일직선 상에 위치하는 경우
        if (oneLine(A, B, C, D)) {
//            boolean x = (Math.abs(B.x-A.x) >= Math.abs(C.x-A.x) && (B.x-A.x)*(C.x-A.x) >= 0)
//                    || (Math.abs(B.x-A.x) >= Math.abs(D.x-A.x) && (B.x-A.x)*(D.x-A.x) >= 0); // x범위 교차여부
//            boolean y = (Math.abs(B.y-A.y) >= Math.abs(C.y-A.y) && (B.y-A.y)*(C.y-A.y) >= 0)
//                    || (Math.abs(B.y-A.y) >= Math.abs(D.y-A.y) && (B.y-A.y)*(D.y-A.y) >= 0); // y범위 교차여부

            boolean x = (A.x-C.x)*(B.x-C.x) <= 0 || (A.x-D.x)*(B.x-D.x) <= 0
                    || (C.x-A.x)*(D.x-A.x) <= 0 || (C.x-B.x)*(D.x-B.x) <= 0;
            boolean y = (A.y-C.y)*(B.y-C.y) <= 0 || (A.y-D.y)*(B.y-D.y) <= 0
                    || (C.y-A.y)*(D.y-A.y) <= 0 || (C.y-B.y)*(D.y-B.y) <= 0;

            if (A.x == B.x) {
                // x값이 같음 (y축에 평행)
                if (y) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (A.y == B.y) {
                // y값이 같음 (x축에 평행)
                if (x) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                // 어느 축에도 평행하지 않음
                if (x) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            System.exit(0);
        }

        // 그렇지 않은 경우
        if (CCW(A, B, C, D)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }

    public static boolean oneLine(Point A, Point B, Point C, Point D) {
        return Product(A, B, C)*Product(A, B, D) == 0
                && Product(C, D, A)*Product(C, D, B) == 0;
    }

    public static boolean CCW(Point A, Point B, Point C, Point D) {
        return Product(A, B, C)*Product(A, B, D) <= 0
                && Product(C, D, A)*Product(C, D, B) <= 0;
    }

    public static long Product(Point A, Point B, Point C) {
        long OuterProduct = (B.x-A.x)*(C.y-A.y) - (B.y-A.y)*(C.x-A.x);
        if (OuterProduct > 0) {
            return 1;
        } else if (OuterProduct == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}