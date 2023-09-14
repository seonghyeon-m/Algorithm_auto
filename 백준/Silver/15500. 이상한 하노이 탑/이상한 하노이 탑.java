import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		Stack<Integer>[] stack = new Stack[3];
		for (int i = 0; i < 3; i++)
			stack[i] = new Stack<>();
		for (int i = 0; i < N; i++)
			stack[0].push(sc.nextInt());
		
		StringBuilder sb = new StringBuilder();
		int n = N;
		int cnt = 0;
		while (n != 0) {
			if (!stack[0].isEmpty() && stack[0].peek() == n) {
				stack[2].push(stack[0].pop());
				n--;
				cnt++;
				sb.append("1 3"+"\n");
				continue;
			} else if (!stack[1].isEmpty() && stack[1].peek() == n) {
				stack[2].push(stack[1].pop());
				n--;
				cnt++;
				sb.append("2 3"+"\n");
				continue;
			} else if (!stack[0].isEmpty() && stack[0].contains(n)) {
				stack[1].push(stack[0].pop());
				cnt++;
				sb.append("1 2"+"\n");
				continue;
			} else {
				stack[0].push(stack[1].pop());
				cnt++;
				sb.append("2 1"+"\n");
				continue;
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		sc.close();
	}
}