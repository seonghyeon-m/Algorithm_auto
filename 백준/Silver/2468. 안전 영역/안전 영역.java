import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] safe;
	static int N, max, water;
	static Queue<Node> queue = new LinkedList<>();
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		safe = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				safe[i][j] = sc.nextInt();
		
		water = -1;
		max = 1;
		BFS();
		
		System.out.println(max);
		
		sc.close();
	}
	
	public static void BFS() {
		
		int zone = 0;
		water++;
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (safe[i][j] > water && !visited[i][j]) {
					queue.add(new Node(i,j));
					visited[i][j] = true;
					zone++;
					
					while (!queue.isEmpty()) {
						Node now = queue.poll();
						
						for (int k = 0; k < 4; k++) {
							int nx = now.x + dr[k];
							int ny = now.y + dc[k];
									
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (!visited[nx][ny] && safe[nx][ny] > water) {
									queue.add(new Node(nx, ny));
									visited[nx][ny] = true;
								}
							}
						}
					} //while
					
				}
			}
		}
		
		if (zone > max) {
			max = zone;
		}
		
		if (water == 100) {
			return;
		} else {
			BFS();
		}
		
	} //BFS
}