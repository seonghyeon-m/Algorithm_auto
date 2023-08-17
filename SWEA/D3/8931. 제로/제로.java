import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Integer> stack;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			stack = new ArrayList<>();
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num == 0) {
					pop();
				} else {
					push(num);
				}				
			} //i
			
			int ans = 0;
			for (int i : stack) {
				ans +=i;
			}
			
			System.out.println("#"+testCase+" "+ans);
			
		} //testCase
		
		sc.close();
	}
	
	static void push(int n) {
		stack.add(n);
	}
	
	static int pop() {
		return stack.remove(stack.size()-1);
	}
	
	static boolean isEmpty() {
		if (stack.size() == 0) return true;
		return false;
	}
	
}