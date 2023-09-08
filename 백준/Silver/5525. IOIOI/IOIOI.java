import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException {
		//input, 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		String P = "";
		for(int i = 0; i < N; i++) {
			P += "IO";
		}
		P+="I";

		int cnt = 0;
		for(int i = 0; i <= (M-2*N-1); i++) {
			if(str.charAt(i) == 'I') {
				if(P.equals(str.substring(i,i+(2*N+1)))) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
	}//end of main method

}//end of class
