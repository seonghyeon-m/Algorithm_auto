import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 0; testCase < 10; testCase++) {
			// 1개의 test case에 대한 코드 작성
			
			// input 받기
			int Dump = sc.nextInt();
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			
			// 풀자
			
			// 초기 정렬
			int[] counts = new int[101];
			for (int i = 0; i < box.length; i++) {
				counts[box[i]]++;
			}
			int sort = 0; // box의 sort번째 원소
			int point = 0; // counts의 point번째 원소
			while (point < counts.length) {
				if (counts[point] != 0) {
					counts[point]--;
					box[sort] = point;
					sort++;
				} else {
					point++;
				}
			}
			
			Main: for (int d = Dump; d > 0; d--) {
				if (box[0] == box[box.length-1]) {
					break Main;
				} // 제한 횟수 내에 평탄화가 완료됐으면 break
//				if (box[box.length-1] - box[0] == 1) {
//					// 끝난걸 어떻게 확인하지?
//				} // 차이가 1이어도 평탄화가 끝난 걸수도 있으니 check해주자
				
				// 정렬
				for (int i = 0; i < box.length; i++) {
					counts[box[i]]++;
				}
				
				sort = 0; // box(0~99)의 sort번째 원소
				point = 0; // counts(0~100)의 point번째 원소
				while (point < counts.length) {
					if (counts[point] != 0) {
						counts[point]--;
						box[sort] = point;
						sort++;
					} else {
						point++;
					}
				}
				// dump 과정
				box[box.length-1]--;
				box[0]++;
				
			}
			
			// 마지막으로 한 번 더 정렬
			for (int i = 0; i < box.length; i++) {
				counts[box[i]]++;
			}
			sort = 0; // box의 sort번째 원소
			point = 0; // counts의 point번째 원소
			while (point < counts.length) {
				if (counts[point] != 0) {
					counts[point]--;
					box[sort] = point;
					sort++;
				} else {
					point++;
				}
			}
			
			System.out.println("#"+(testCase+1)+" "+(box[box.length-1]-box[0]));
			// 테케끝
		}
		
		sc.close();
	}
}