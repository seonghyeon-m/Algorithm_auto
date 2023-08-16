import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Character> stack = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		iter: for (int testCase = 1; testCase <= 10; testCase++) {
			
			int N = sc.nextInt();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				if (str.charAt(i) == 40 || str.charAt(i) == 60 || str.charAt(i) == 91 || str.charAt(i) == 123) {
					push(str.charAt(i));
				} else if (str.charAt(i) + stack.get(stack.size()-1) == 81) { // ( )
					pop();
				} else if (str.charAt(i) + stack.get(stack.size()-1) == 122) { // < >
					pop();
				} else if (str.charAt(i) + stack.get(stack.size()-1) == 184) { // [ ]
					pop();
				} else if (str.charAt(i) + stack.get(stack.size()-1) == 248) { // { }
					pop();
				} else {
					System.out.println("#"+testCase+" "+0);
					continue iter;
				}
			} // i
			
			System.out.println("#"+testCase+" "+1);
			stack.clear();
			
		} // testCase
		
		sc.close();
		
	}
	
	static boolean isEmpty() {
		if (stack.size() == 0) return true;
		return false;
	}
	
	static void push(char data) {
		stack.add(data);
	}
	
	static char pop() {
		if (isEmpty()) return 0;
		return stack.remove(stack.size()-1); 
	}
	
}