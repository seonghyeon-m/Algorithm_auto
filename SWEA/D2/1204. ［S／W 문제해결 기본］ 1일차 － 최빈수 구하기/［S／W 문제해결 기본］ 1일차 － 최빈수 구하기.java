import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 0; testCase < T; testCase++) {
			
			int N = sc.nextInt();
			
			int[] score = new int[1000];
			for (int i = 0; i < 1000; i++) {
				score[i] = sc.nextInt();
			}
			int[] counts = new int[101];
			for (int i = 0; i < 1000; i++) {
				counts[score[i]]++;
			}
			
			int max = 0;
			int maxidx = 0;
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] >= max) {
					max = counts[i];
					maxidx = i;
				}
			}
			
			System.out.println("#"+N+" "+maxidx);
			
		}

	}
}