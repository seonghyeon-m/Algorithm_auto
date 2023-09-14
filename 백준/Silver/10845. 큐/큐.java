import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			if (order.equals("push"))
				queue.add(sc.nextInt());
			else if (order.equals("pop"))
				if (queue.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(queue.poll()+"\n");
			else if (order.equals("size"))
				sb.append(queue.size()+"\n");
			else if (order.equals("empty")) {
				if (queue.isEmpty())
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			else if (order.equals("front"))
				if (queue.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(queue.peekFirst()+"\n");
			else if (order.equals("back"))
				if (queue.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(queue.peekLast()+"\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}