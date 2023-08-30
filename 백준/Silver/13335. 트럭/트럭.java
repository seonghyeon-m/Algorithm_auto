import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 트럭 수 N
		int W = sc.nextInt(); // 다리 길이 W
		int L = sc.nextInt(); // 다리의 최대 하중 L
		
		Queue<Integer> trucks = new LinkedList<>();
		for (int i = 0; i < N; i++) trucks.add(sc.nextInt());
		int[] bridge = new int[W];
		Queue<Integer> arrived = new LinkedList<>();
		int bridgeWeight = 0;
		int time = 0;
		
		while (arrived.size() != N) {
			time++;
			if (bridge[0] != 0) {
				arrived.add(bridge[0]);
				bridgeWeight -=bridge[0];
				bridge[0] = 0;
			}
			for (int i = 1; i < W; i++) bridge[i-1] = bridge[i];
			bridge[W-1] = 0;
			if (trucks.size() != 0 && bridgeWeight + trucks.peek() <= L) {
				bridge[W-1] = trucks.poll();
				bridgeWeight +=bridge[W-1];
			}
		}
		
		System.out.println(time);
		
		sc.close();
	}
}