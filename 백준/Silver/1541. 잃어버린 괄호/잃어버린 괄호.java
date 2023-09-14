import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); // 그냥 한 줄 통 채로 받아둔 string
		String[] numbers = str.split("\\+|\\-"); // 숫자만 따로 배열에 담아 둠
		
		int idx = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+')
				idx++;
			else if (str.charAt(i) == '-') {
				break;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i < idx)
				ans +=Integer.parseInt(numbers[i]);
			else
				ans -=Integer.parseInt(numbers[i]);
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}