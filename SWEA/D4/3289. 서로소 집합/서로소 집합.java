import java.util.Scanner;

public class Solution {
	static int parents[];
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			N = sc.nextInt(); // 숫자의 개수
			M = sc.nextInt(); // 연산의 개수
			
			parents = new int[N+1]; // 각 집합의 부모를 담을 배열
			makeSet();
			
			System.out.print("#"+testCase+" ");
			
			// M개의 연산
			for (int m = 0; m < M; m++) {
				
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (cal == 0) {
					unionSet(a, b);
				} else {
					int pa = findSet(a);
					int pb = findSet(b);
					
					if (pa == pb) System.out.print(1);
					else System.out.print(0);
				}
				
			} // for m
			
			System.out.println();
		} //testCase
		
		sc.close();
	}
	
	// make set (처음에 만들어줌)
	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// find set (부모 찾아줌)
	public static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// union set (합쳐줌)
	public static void unionSet(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		parents[pb] = pa;
	}
}