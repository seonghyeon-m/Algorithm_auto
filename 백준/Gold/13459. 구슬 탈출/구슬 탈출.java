import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static class Marble implements Cloneable {
		int r, c;

		public Marble(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public Object clone() {
			Object obj = null;
			try {
				obj = super.clone();
			} catch(CloneNotSupportedException e) {}
			return obj;
		}
	}

	static class State {
		Marble color1, color2;
		int time;

		public State(Marble color1, Marble color2, int time) {
			this.color1 = color1;
			this.color2 = color2;
			this.time = time;
		}
	}

	static String[][] plate;
	static Queue<State> queue = new LinkedList<>();
	static Marble RedL, RedR, RedU, RedD, BlueL, BlueR, BlueU, BlueD;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열

		Marble red = null;
		Marble blue = null;

		plate = new String[N][M];
		for (int i = 0; i < N; i++) {
			plate[i] = sc.next().split("");
			for (int j = 0; j < M; j++) {
				if (plate[i][j].equals("R")) {
					red = new Marble(i, j);
					plate[i][j] = ".";
				} else if (plate[i][j].equals("B")) {
					blue = new Marble(i, j);
					plate[i][j] = ".";
				}
			}
		}

		State init = new State(red, blue, 0);
		queue.offer(init);

		BFS();
		
		// 시스템이 종료되지 못하고 여기까지 왔다면
		System.out.println(0);
		sc.close();
	}

	public static void BFS() {
		while (!queue.isEmpty()) {

			State now = queue.poll();
			if (now.time >= 10) continue;
			
			// 1. 왼쪽으로 기울이기
			Marble redL = (Marble) now.color1.clone();
			Marble blueL = (Marble) now.color2.clone();
			if (redL.c > blueL.c) {
				while (!plate[blueL.r][blueL.c-1].equals("#")) {
					blueL.c--;
					if (plate[blueL.r][blueL.c].equals("O")) {
						blueL.r = -1;
						blueL.c = -1;
						break;
					}
				}
				while (!plate[redL.r][redL.c-1].equals("#")) {
					if (redL.r == blueL.r && redL.c -1 == blueL.c) break;
					redL.c--;
					if (plate[redL.r][redL.c].equals("O")) {
						redL.r = -1;
						redL.c = -1;
						break;
					}
				}
			} else {
				while (!plate[redL.r][redL.c-1].equals("#")) {
					redL.c--;
					if (plate[redL.r][redL.c].equals("O")) {
						redL.r = -1;
						redL.c = -1;
						break;
					}
				}
				while (!plate[blueL.r][blueL.c-1].equals("#")) {
					if (redL.r == blueL.r && redL.c == blueL.c-1) break;
					blueL.c--;
					if (plate[blueL.r][blueL.c].equals("O")) {
						blueL.r = -1;
						blueL.c = -1;
						break;
					}
				}
			}
			if (now.color1.c != redL.c || now.color2.c != blueL.c) {				
				if (blueL.r != -1 && redL.r != -1) {
					if (redL.r != blueL.r || redL.c != blueL.c) { 
						queue.offer(new State(redL, blueL, now.time+1));
					}
				} else if (blueL.r != -1 && redL.r == -1) {
					System.out.println(1);
					System.exit(0);
				}
			}
			
			// 2. 오른쪽으로 기울이기
			Marble redR = (Marble) now.color1.clone();
			Marble blueR = (Marble) now.color2.clone();
			if (redR.c < blueR.c) {
				while (!plate[blueR.r][blueR.c+1].equals("#")) {
					blueR.c++;
					if (plate[blueR.r][blueR.c].equals("O")) {
						blueR.r = -1;
						blueR.c = -1;
						break;
					}
				}
				while (!plate[redR.r][redR.c+1].equals("#")) {
					if (redR.r == blueR.r && redR.c +1 == blueR.c) break;
					redR.c++;
					if (plate[redR.r][redR.c].equals("O")) {
						redR.r = -1;
						redR.c = -1;
						break;
					}
				}
			} else {
				while (!plate[redR.r][redR.c+1].equals("#")) {
					redR.c++;
					if (plate[redR.r][redR.c].equals("O")) {
						redR.r = -1;
						redR.c = -1;
						break;
					}
				}
				while (!plate[blueR.r][blueR.c+1].equals("#")) {
					if (redR.r == blueR.r && redR.c == blueR.c+1) break;
					blueR.c++;
					if (plate[blueR.r][blueR.c].equals("O")) {
						blueR.r = -1;
						blueR.c = -1;
						break;
					}
				}
			}
			if (now.color1.c != redR.c || now.color2.c != blueR.c) {
				if (blueR.r != -1 && redR.r != -1) {
					if (redR.r != blueR.r || redR.c != blueR.c) {
						queue.offer(new State(redR, blueR, now.time+1));
					}
				} else if (blueR.r != -1 && redR.r == -1) {
					System.out.println(1);
					System.exit(0);
				}
			}
			
			// 3. 위로 기울이기
			Marble redU = (Marble) now.color1.clone();
			Marble blueU = (Marble) now.color2.clone();
			if (redU.r > blueU.r) {
				while (!plate[blueU.r-1][blueU.c].equals("#")) {
					blueU.r--;
					if (plate[blueU.r][blueU.c].equals("O")) {
						blueU.r = -1;
						blueU.c = -1;
						break;
					}
				}
				while (!plate[redU.r-1][redU.c].equals("#")) {
					if (redU.r-1 == blueU.r && redU.c == blueU.c) break;
					redU.r--;
					if (plate[redU.r][redU.c].equals("O")) {
						redU.r = -1;
						redU.c = -1;
						break;
					}
				}
			} else {
				while (!plate[redU.r-1][redU.c].equals("#")) {
					redU.r--;
					if (plate[redU.r][redU.c].equals("O")) {
						redU.r = -1;
						redU.c = -1;
						break;
					}
				}
				while (!plate[blueU.r-1][blueU.c].equals("#")) {
					if (redU.r == blueU.r-1 && redU.c == blueU.c) break;
					blueU.r--;
					if (plate[blueU.r][blueU.c].equals("O")) {
						blueU.r = -1;
						blueU.c = -1;
						break;
					}
				}
			}
			if (now.color1.r != redU.r || now.color2.r != blueU.r) {				
				if (blueU.r != -1 && redU.r != -1) {
					if (redU.r != blueU.r || redU.c != blueU.c) { 
						queue.offer(new State(redU, blueU, now.time+1));
					}
				} else if (blueU.r != -1 && redU.r == -1) {
					System.out.println(1);
					System.exit(0);
				}
			}
			
			// 4. 아래로 기울이기
			Marble redD = (Marble) now.color1.clone();
			Marble blueD = (Marble) now.color2.clone();
			if (redD.r < blueD.r) {
				while (!plate[blueD.r+1][blueD.c].equals("#")) {
					blueD.r++;
					if (plate[blueD.r][blueD.c].equals("O")) {
						blueD.r = -1;
						blueD.c = -1;
						break;
					}
				}
				while (!plate[redD.r+1][redD.c].equals("#")) {
					if (redD.r+1 == blueD.r && redD.c == blueD.c) break;
					redD.r++;
					if (plate[redD.r][redD.c].equals("O")) {
						redD.r = -1;
						redD.c = -1;
						break;
					}
				}
			} else {
				while (!plate[redD.r+1][redD.c].equals("#")) {
					redD.r++;
					if (plate[redD.r][redD.c].equals("O")) {
						redD.r = -1;
						redD.c = -1;
						break;
					}
				}
				while (!plate[blueD.r+1][blueD.c].equals("#")) {
					if (redD.r == blueD.r+1 && redD.c == blueD.c) break;
					blueD.r++;
					if (plate[blueD.r][blueD.c].equals("O")) {
						blueD.r = -1;
						blueD.c = -1;
						break;
					}
				}
			}
			if (now.color1.r != redD.r || now.color2.r != blueD.r) {				
				if (blueD.r != -1 && redD.r != -1) {
					if (redD.r != blueD.r || redD.c != blueD.c) {
						queue.offer(new State(redD, blueD, now.time+1));
					}
				} else if (blueD.r != -1 && redD.r == -1) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
	}
}