import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> building = new Stack<>();
		long ans = 0;
		
		for (int i = 0; i < N; i++) {
			int high = sc.nextInt();
			if (!building.isEmpty()) {
				if (building.get(building.size()-1) > high) {
				building.add(high);
				} else {
					while (!building.isEmpty() && building.get(building.size()-1) <= high) {
						building.pop();
					}
					building.add(high);
				}
			} else building.add(high);
			ans +=building.size()-1;
		}
		
		System.out.println(ans);
		sc.close();
	}
}