import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			
			// push
			if (order.equals("push_front"))
				deque.addFirst(sc.nextInt());
			else if (order.equals("push_back"))
				deque.addLast(sc.nextInt());
			
			// pop
			else if (order.equals("pop_front"))
				if (deque.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(deque.removeFirst()+"\n");
			else if (order.equals("pop_back"))
				if (deque.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(deque.removeLast()+"\n");
			
			// size
			else if (order.equals("size"))
				sb.append(deque.size()+"\n");
			
			// empty
			else if (order.equals("empty")) {
				if (deque.isEmpty())
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
			}
			
			// front
			else if (order.equals("front"))
				if (deque.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(deque.peekFirst()+"\n");
			
			// back
			else if (order.equals("back"))
				if (deque.isEmpty())
					sb.append(-1+"\n");
				else
					sb.append(deque.peekLast()+"\n");
		}
		
		System.out.println(sb);
		sc.close();
	}
}