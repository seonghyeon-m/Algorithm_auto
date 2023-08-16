import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> stack = new ArrayList<>();
	
	static boolean isEmpty() {
		if (stack.size() == 0) return true;
		return false;
	}
	
	static void push(String data) {
		stack.add(data);
	}
	
	static String pop() {
		if (isEmpty()) return null;
		return stack.remove(stack.size()-1); 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[][] words = new String[5][];
			int[] arrayLength = new int[5];
			int maxLength = 0;
			
			for (int i = 0; i < 5; i++) {
				words[i] = sc.next().split("");
				arrayLength[i] = words[i].length;
				if (arrayLength[i] > maxLength) {
					maxLength = arrayLength[i];
				}
			}
			
			// maxLength를 하나씩 줄이면서 0이 될 때 까지 (다 stack에 집어넣을 때까지)
			while (maxLength != 0) {
				for (int i = 4; i >= 0; i--) {
					if (arrayLength[i] == maxLength) {
						push(words[i][maxLength-1]);
						arrayLength[i]--;
					}
				}
				maxLength--;
			}
			
			System.out.print("#"+testCase+" ");
			while (!isEmpty()) {
				System.out.print(stack.get(stack.size()-1));
				pop();
			}
			
			System.out.println();
		}
		
		sc.close();
	}
}