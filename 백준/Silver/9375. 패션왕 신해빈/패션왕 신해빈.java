import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			
			HashMap<String, Integer> clothes = new HashMap<>();
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				sc.next();
				String sort = sc.next();
				if (clothes.containsKey(sort))
					clothes.put(sort, clothes.get(sort)+1);
				else
					clothes.put(sort, 1);
			}
			
			int answer = 1;
			Set set = clothes.keySet();
			Iterator iter = set.iterator();
			
			while (iter.hasNext()) {
				String key = (String) iter.next();
				answer *=(clothes.get(key)+1);
			}
			
			System.out.println(answer-1);
			
		}
		
		
		sc.close();
	}
}