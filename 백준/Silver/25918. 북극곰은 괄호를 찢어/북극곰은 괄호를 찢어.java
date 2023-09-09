import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N, days, left, right;
	static String S;
	static Stack<Character> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.next();
		
		stack = new Stack<>();
		
		rip();
		
		System.out.println(days);
		sc.close();
	}
	
	public static void rip() {
		for (int i = 0; i < S.length(); i++) {
			// 괄호 등장 횟수 기록
			if (S.charAt(i) == '(') left++;
			else right++;
			
			// stack push/pop
			if (stack.isEmpty() || stack.peek() == S.charAt(i)) {
				stack.push(S.charAt(i));
			}
			else stack.pop();
			
			// stack 최대 크기 기록
			if (stack.size() > days) days = stack.size();
		}
		
		if (left != right) {
			System.out.println(-1);
			System.exit(0);
		}
	}

}