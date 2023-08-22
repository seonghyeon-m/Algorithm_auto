import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * N 과목 수
	 * M 마일리지
	 * people 각 과목 신청한 수강생 수
	 * limit 수강인원 제한
	 * bet 그 신청한 수강생들이 마일리지를 몇점 썼는지
	 * cut 그래서 몇점 써야 그 수업 들을 수 있는지
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cut = new int[N];
        
        for (int subject = 0; subject < N; subject++) {
            int people = sc.nextInt();
            int limit = sc.nextInt();
            
            int[] bet = new int[people];
            for (int i = 0; i < people; i++) {
                bet[i] = sc.nextInt();
            }
            Arrays.sort(bet);
            
            if (limit <= people) {
                cut[subject] = bet[people-limit];
            } else {
            	cut[subject] = 1;
            }
            
        } //subject
        
        Arrays.sort(cut);
        
        int sub = 0;
        while (M >= cut[sub]) {
        	M -=cut[sub];
        	sub++;
        	if (sub == cut.length) break;
        }
        
        System.out.println(sub);
        
        sc.close();
    }
}