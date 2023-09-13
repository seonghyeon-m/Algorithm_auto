import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int A;
	public static int C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		
		System.out.println(multi(B));
	}
	
	public static long multi(int n) {
		if(n == 1) {
			return A%C;
		}
		
		if(n%2 == 1) {
			long temp = multi((n-1)/2)%C;
			return (temp * temp)%C * (A%C) % C;
		} else {
			long temp = multi(n/2)%C;
			return (temp * temp) % C;
		}
	}
	
	
}
