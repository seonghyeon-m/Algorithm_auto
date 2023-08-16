import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Character> stack = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			String str = sc.next();
			int ans = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 40) {
					push(str.charAt(i));
				} else {
					if (str.charAt(i-1) == 40) {
						// () 모양으로 만나는 곳: 레이저로 자르는 부분이라 (stack의 크기-1)만큼 더함
						ans +=(stack.size()-1);
						pop();
					} else {
						// )) 모양으로 만나는 곳: 막대기가 끝나는 부분이라 1만큼 더함
						ans++;
						pop();
					}
				}
			}

			System.out.println("#"+testCase+" "+ans);
			
		} //testCase
		
		sc.close();
		
	} //main method
	
	static void push(char c) {
		stack.add(c);
	}
	
	static char pop() {
		return stack.remove(stack.size()-1);
	}
	
	static boolean isEmpty() {
		if (stack.size() == 0) return true;
		return false;
	}
	
}