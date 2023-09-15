import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Deque<Integer> deque = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		TC: for (int testCase = 1; testCase <= T; testCase++) {
			
			// input 받기
			String function = sc.next();
			sc.nextInt();
			String makeArr = sc.next();
			
			// input 받은 배열을 deque로 정리하기
			StringBuilder sb = new StringBuilder();
			deque = new LinkedList<>();
			for (int i = 0; i < makeArr.length(); i++) {
				if (makeArr.charAt(i) == '[')
					continue;
				else if (makeArr.charAt(i) == ']') {
					if (sb.length() != 0) {
						deque.add(Integer.parseInt(sb.toString()));
						sb = new StringBuilder();
					}
				}
				else if (makeArr.charAt(i) == ',') {
					deque.add(Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
					continue;
				}
				else
					sb.append(makeArr.charAt(i)-'0');
			}
			
			// 함수 실행하기 (R: 뒤집기, D: 삭제하기)
			int cnt = 0;
			for (int i = 0; i < function.length(); i++) {
				if (function.charAt(i) == 'R') {
					if (cnt == 0) cnt = 1;
					else cnt = 0;
				}
				else {
					if (deque.isEmpty()) {
						System.out.println("error");
						continue TC;
					} else D(cnt);
				}
			}
			
			// 출력
			if (cnt == 0) {
				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(deque.peekFirst());
					deque.removeFirst();
					if (!deque.isEmpty())
						sb.append(",");
				}
				sb.append("]");
				System.out.println(sb);
				sb = new StringBuilder();
			} else {
				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(deque.peekLast());
					deque.removeLast();
					if (!deque.isEmpty())
						sb.append(",");
				}
				sb.append("]");
				System.out.println(sb);
				sb = new StringBuilder();
			}

				
			
		} //testCase
		
		sc.close();
	}
	
	public static void D(int n) {
		if (n == 0)
			deque.removeFirst();
		else
			deque.removeLast();
	}
}