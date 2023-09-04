import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int l = 0;
		int r = 0;
		while(A != 1 || B != 1) {
			//부모노드 추적
			if(A > B) {//왼쪽 자식이었으면
				l++;
				int c = A;
				int d = B;
				A = c-d;
				B = d;
			} else if(A < B) {//오른쪽 자식이었음
				r++;
				int c = A;
				int d = B;
				A = c;
				B = d-c;
			}
		}
		System.out.println(l + " " + r);
		
	}
	
}
