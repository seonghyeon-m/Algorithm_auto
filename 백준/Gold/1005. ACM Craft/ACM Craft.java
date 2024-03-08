import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {

            // basic input
            int N = sc.nextInt(); // 건물의 개수 (건물 번호는 1~N)
            int K = sc.nextInt(); // 건물간의 건설 순서 규칙의 총 개수
            int[] time = new int[N+1]; // 각 건물 당 건설에 걸리는 시간
            for (int i = 1; i <= N; i++) {
                time[i] = sc.nextInt();
            }

            // edge, degree input
            ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edge.add(new ArrayList<Integer>());
            }
            int[] degree = new int[N+1];
            for (int i = 0; i < K; i++) {
                // 건물 a를 지은 다음에 건물 b를 짓는 것이 가능하다는 의미
                int a = sc.nextInt();
                int b = sc.nextInt();

                edge.get(a).add(b);
                degree[b]++;
            }

            // 위상정렬을 위해 진입차수가 0인 건물을 queue에 삽입한다.
            Queue<Integer> q = new LinkedList<>();
            int[] totalTime = new int[N+1];
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    totalTime[i] = time[i];
                    q.offer(i);
                }
            }

            // 위상정렬 시작
            while (!q.isEmpty()) {
                int thisBuilding = q.poll();
                ArrayList<Integer> nextBuildingList = edge.get(thisBuilding);

                // 건물을 지어보자
                for (int nextBuilding : nextBuildingList) {
                    totalTime[nextBuilding] = Math.max(totalTime[thisBuilding] + time[nextBuilding], totalTime[nextBuilding]);
                    degree[nextBuilding]--;
                    if (degree[nextBuilding] == 0) {
                        q.offer(nextBuilding);
                    }
                }
            }

            int W = sc.nextInt();
            System.out.println(totalTime[W]);
        } //tc
        sc.close();
    }
}