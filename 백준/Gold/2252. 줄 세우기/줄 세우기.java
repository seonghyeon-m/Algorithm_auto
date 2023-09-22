import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 인접행렬
		// 문제에서 1번 정점부터 시작 V번까지
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<>());
		}
		int[] degree = new int[V + 1]; // 진입차수를 저장할 배열을 하나 생성한다.

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			// 유향이므로 A->B로만 저장하면 된다.
			list.get(A).add(B); // 가중치가 따로 주어지지 않았기 때문에

			// 진입차수 증가
			degree[B]++;
		} // input받기 끝

		// 작업이 들어갈 큐 준비 (degree가 0인 정점만 들어갈 수 있음)
		Queue<Integer> queue = new LinkedList<>();

		// 초기에 진입차수가 0인(선작업이 없는) 정점 모두 queue에 삽입
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int student = queue.poll(); // 정점을 하나 꺼낸다
			System.out.print(student + " ");

			for (int i : list.get(student)) {
				degree[i]--;

				// 진입차수가 0이 되었다 라는 말은 선행작업이 완료되었음을 의미한다
				// 고로 queue에 들어갈 준비가 되었다
				if (degree[i] == 0)
					queue.offer(i);

			}
		}

		sc.close();
	}
}