import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			if (order.equals("push"))
				stack.push(sc.nextInt());
			else if (order.equals("pop"))
				if (stack.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(stack.pop()+"\n");
			else if (order.equals("size"))
				sb.append(stack.size()+"\n");
			else if (order.equals("empty")) {
				if (stack.isEmpty())
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			else if (order.equals("top"))
				if (stack.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(stack.peek()+"\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}