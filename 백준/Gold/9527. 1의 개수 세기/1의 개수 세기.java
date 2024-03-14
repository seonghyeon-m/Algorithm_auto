import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Long> DP = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        long A = sc.nextLong();
        long B = sc.nextLong();

        setDP(B);

        // 정답 출력
        long answer = countOnes(B) - countOnes(A-1);
        System.out.println(answer);

        sc.close();
    }

    public static long countOnes(long N) {
        long cnt = N & 1;
        int size = log2(N);
        for (int i = size; i > 0; i--) {
            if ((N & (1L << i)) != 0L) {
                cnt +=DP.get(i) + (N - (1L << i) + 1);
                N -= (1L << i);
            }
        }
        return cnt;
    }

    public static void setDP(long B) {
        DP.add((long) 0); // 0까지
        DP.add((long) 1); // 2^1-1까지 (1)
        DP.add((long) 4); // 2^2-1까지 (3)
        while ((long)Math.pow(2, DP.size()) <= B) {
            long cnt = (long)Math.pow(2, DP.size()-1) + 2*DP.get(DP.size()-1);
            DP.add(cnt);
        }
    }

    public static int log2(long a) {
        return (int) (Math.log(a) / Math.log(2));
    }
}