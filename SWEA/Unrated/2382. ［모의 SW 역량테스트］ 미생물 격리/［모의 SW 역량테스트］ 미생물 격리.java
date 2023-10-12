import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Micro implements Comparable<Micro> {
	int r, c, q, d;
	
	public Micro(int r, int c, int q, int d) {
		this.r = r; // 행
		this.c = c; // 열
		this.q = q; // 수
		this.d = d; // 방향
	}
	
	@Override
	public int compareTo(Micro o) {
		return q - o.q;
	}
}

public class Solution {

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static boolean[][] visited; // 미생물 존재 여부를 저장
	static List<Micro> list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testCase 수
		for (int tc = 1; tc <= T; tc++) {

			System.out.print("#" + tc + " ");

			// input 받기
			int N = sc.nextInt(); // 한 변의 셀의 개수
			int M = sc.nextInt(); // 격리 시간
			int K = sc.nextInt(); // 미생물 군집의 수
			list = new ArrayList<>(); // list 초기화
			for (int i = 0; i < K; i++)
				list.add(new Micro(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));

			// 계산
			// M시간 반복
			for (int t = 0; t < M; t++) {
				visited = new boolean[N][N];
				ArrayList<Micro>[][] meet = new ArrayList[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						meet[i][j] = new ArrayList<>();
					}
				}
				List<Micro> newList = new ArrayList<>();
				// 모든 미생물 한 칸 씩 이동
				for (Micro micro : list) {
					int nr = micro.r + dr[micro.d];
					int nc = micro.c + dc[micro.d];
					// 이 자리에 이미 미생물이 있으면?
					if (visited[nr][nc]) {
						// 중복 확인하는 배열이 비어있으면 처음 중복인가봐
						if (meet[nr][nc].isEmpty()) {
							// newList에서 찾아서 빼주고 중복 확인 배열에 갖다넣고
							for (int i = 0; i < newList.size(); i++) {
								if (newList.get(i).r == nr && newList.get(i).c == nc) {
									meet[nr][nc].add(newList.get(i));
									newList.remove(i);
									break;
								}
							}
						}
						// 넣던거는 만나는 배열에 넣어준다
						meet[nr][nc].add(new Micro(nr, nc, micro.q, micro.d));
					} else if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
						if (micro.q != 1) {
							newList.add(new Micro(nr, nc, micro.q / 2, turn180(micro.d)));
							visited[nr][nc] = true;
						}
					} else {
						newList.add(new Micro(nr, nc, micro.q, micro.d));
						visited[nr][nc] = true;
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!meet[i][j].isEmpty()) {
							Collections.sort(meet[i][j]);
							int last = meet[i][j].size() -1;
							int add = 0;
							for (int k = 0; k < meet[i][j].size(); k++)
								add +=meet[i][j].get(k).q;
							newList.add(new Micro(meet[i][j].get(last).r, meet[i][j].get(last).c, add, meet[i][j].get(last).d));
						}
					}
				}
				list = newList;
			}
			int total = 0;
			for (Micro micro : list) {
				total += micro.q;
			}
			System.out.println(total + " ");
		}

		sc.close();
	}

	public static int turn180(int d) {
		if (d == 1)
			return 2;
		else if (d == 2)
			return 1;
		else if (d == 3)
			return 4;
		else if (d == 4)
			return 3;
		return 0;
	}
}