import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList<Integer>[] linked = new ArrayList[N];
		for (int i = 0; i < N; i++)
			linked[i] = new ArrayList<>();

		for (int m = 0; m < M; m++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			linked[a].add(b);
			linked[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		queue.add(0);
		visited[0] = true;
		int answer = 0;
		
		while (!queue.isEmpty()) {
			
			int now = queue.poll();
			for (int i = 0; i < linked[now].size(); i++) {
				if (!visited[linked[now].get(i)]) {
					visited[linked[now].get(i)] = true;
					queue.add(linked[now].get(i));
					answer++;
				}
			}
			
		}

		System.out.println(answer);
		
		sc.close();
	}
}