import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<String> stack = new ArrayList<>();
	static ArrayList<Integer> stack2 = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb = new StringBuilder();
			
			int L = sc.nextInt();
			String[] cal = sc.next().split(""); // string array에 숫자와 부호가 저장되어 있음.
			
			int point = 0;
			while (point < L) {
			
				if (cal[point].equals("+")) {
					// + 만나면
					if (!isEmpty() && stack.get(stack.size()-1).equals("*")) {
						// * 위에 +가 올라갈 수는 없으니 이제 뽑아야 해
						while (stack.size() != 0) {
							sb.append(stack.get(stack.size()-1));
							pop();
						}
						push("+");
					} else {
						// 밑에 +밖에 없으면 그냥 계속 쌓아
						push("+");
					}
					
				} else if (cal[point].equals("*")) {
					// * 만나면
					// *은 우선순위가 높으니까 그냥 push한다
					push("*");					
				} else {
					// 숫자 만나면
					sb.append(cal[point]);
				}
				point++;
			} //while point<L
			
			while (stack.size() != 0) {
				sb.append(stack.get(stack.size()-1));
				pop();
			}
			
//			// 후위표기식 출력
//			System.out.println(sb);
			
			// 후위표기식 계산
			String str = sb.toString();
			int ans = 0;
			int times = 0;
			int temp;
			
			for (int i = 0; i < str.length(); i++) {
				
				if (str.charAt(i) == '+') {
					// 1. 더하기
					if (times == 0) {
						ans +=stack2.get(stack2.size()-1);
						pop2();
					} else {
						temp = stack2.get(stack2.size()-1);
						pop2();
						while (times != 0) {
							// 곱하기가 남아있는 동안에는 곱셈 먼저 처리
							temp *=stack2.get(stack2.size()-1);
							pop2();
							times--;
						}
						ans +=temp;
					}
					
				} else if (str.charAt(i) == '*') {
					// 2. 곱하기
					times++;
				} else {
					// 3. 숫자
					if (times == 0) {
						push2(str.charAt(i) - 48);
					} else {
						temp = stack2.get(stack2.size()-1);
						pop2();
						while (times != 0) {
							// 곱하기가 남아있는 동안에는 곱셈 먼저 처리
							temp *=stack2.get(stack2.size()-1);
							pop2();
							times--;
						}
						ans +=temp;
						push2(str.charAt(i) - 48);
					}
				}

			} //for i in str.length()


			while (stack2.size() != 0) {
				ans +=stack2.get(stack2.size()-1);
				pop2();
			}
			
			System.out.println("#"+testCase+" "+ans);
			
		} //tc
		
		
		sc.close();
	}
	
	public static boolean isEmpty() {
		if (stack.size() == 0) return true;
		else return false;
	}
	
	public static void push(String n) {
		stack.add(n);
	}
	
	public static void pop() {
		if (!isEmpty()) stack.remove(stack.size()-1);
	}
	
	public static boolean isEmpty2() {
		if (stack2.size() == 0) return true;
		else return false;
	}
	
	public static void push2(int n) {
		stack2.add(n);
	}
	
	public static void pop2() {
		if (!isEmpty2()) stack2.remove(stack2.size()-1);
	}
	
}