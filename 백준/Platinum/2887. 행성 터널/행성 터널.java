import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Planet {
        int i, x, y, z;

        public Planet(int i, int x, int y, int z) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int i, j, cost;

        public Edge(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Planet> planets = new ArrayList<>();
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            planets.add(new Planet(i, sc.nextInt(), sc.nextInt(), sc.nextInt()));
            parents[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        // x, y, z좌표에 대해 정렬한 뒤
        // 각각 인접한 행성끼리의 간선만 queue에 등록한다.

        // 1. x좌표 순으로 정렬
        Collections.sort(planets, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < N-1; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i+1);

            int cost = Math.abs(planet2.x-planet1.x);

            edges.offer(new Edge(planet1.i, planet2.i, cost));
        }

        // 2. y좌표 순으로 정렬
        Collections.sort(planets, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < N-1; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i+1);

            int cost = Math.abs(planet2.y-planet1.y);

            edges.offer(new Edge(planet1.i, planet2.i, cost));
        }

        // 3. z좌표 순으로 정렬
        Collections.sort(planets, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < N-1; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i+1);

            int cost = Math.abs(planet2.z-planet1.z);

            edges.offer(new Edge(planet1.i, planet2.i, cost));
        }

        int answer = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();

            if (find(edge.i) != find(edge.j)) {
                answer +=edge.cost;
                union(edge.i, edge.j);
            }
        }

        System.out.println(answer);
        sc.close();
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parents[pb] = pa;
    }
}