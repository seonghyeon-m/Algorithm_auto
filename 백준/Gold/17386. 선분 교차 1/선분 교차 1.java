import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 선분 L1
		double x1 = sc.nextInt();
		double y1 = sc.nextInt();
		double x2 = sc.nextInt();
		double y2 = sc.nextInt();
		
		// 선분 L2
		double x3 = sc.nextInt();
		double y3 = sc.nextInt();
		double x4 = sc.nextInt();
		double y4 = sc.nextInt();
		
		if ((((y2-y1)*(x3-x1)/(x2-x1))-(y3-y1))*(((y2-y1)*(x4-x1)/(x2-x1))-(y4-y1)) < 0 &&
				(((y4-y3)*(x1-x3)/(x4-x3))-(y1-y3))*(((y4-y3)*(x2-x3)/(x4-x3))-(y2-y3)) < 0) {
			System.out.println(1);
		} else System.out.println(0);
		
		sc.close();
	}
}