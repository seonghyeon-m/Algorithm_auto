import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] degree;
	static Queue<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static List<List<Integer>> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 문제의 수
		M = sc.nextInt(); // 정보의 개수
		
		degree = new int[N+1]; // 진입 차수
		
		// 인접리스트로 구현
		list = new ArrayList<>();
		for (int i = 0; i < N+1; i++)
			list.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list.get(a).add(b);
			degree[b]++;
		}
		
		for (int i = 1; i <= N; i++)
			if (degree[i] == 0)
				queue.offer(i);
		
		solve();
		
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void solve() {
		
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				sb.append(i+" ");
				degree[i]--;
				for (int j = 0; j < list.get(i).size(); j++) {
					int now = list.get(i).get(j);
					
					degree[now]--;
				}
				
				solve();
			}
		}
		
	}
}