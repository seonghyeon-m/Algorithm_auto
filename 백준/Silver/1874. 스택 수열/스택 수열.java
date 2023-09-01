import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Stack<Integer> wait = new Stack<>();
		Stack<Integer> make = new Stack<>();
		Stack<String> answer = new Stack<>();
		for (int i = 0; i < N; i++) wait.add(sc.nextInt());
		
		int num = N;
		while (num != 0) {
			// 뽑기
			if (make.size() > 0 && make.get(make.size()-1) == num) {
				make.pop();
				answer.add("+");
				num--;
				continue;
			}
			// 더 이상 넣을 숫자가 없음
			if (wait.size() == 0) {
				System.out.println("NO");
				System.exit(0);
			}
			// 넣기
			make.add(wait.pop());
			answer.add("-");
		}
		
		for (int i = answer.size()-1; i >= 0; i--) {
			sb.append(answer.get(i)+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}