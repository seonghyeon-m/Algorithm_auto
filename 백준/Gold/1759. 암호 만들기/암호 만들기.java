import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static String[] password;
	static int con = 0;
	static int vow = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		int L = sc.nextInt();
		int C = sc.nextInt();
		String[] words = new String[C];
		for (int i = 0; i < C; i++) words[i] = sc.next();
		
		// 풀이
		visited = new boolean[C];
		password = new String[L];
		
		Arrays.sort(words);
		
		make(words, L, 0);
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void make(String[] words, int L, int depth) {
		if (depth == L) {
			for (int i = 0; i < L; i++) {
				if (password[i].equals("a") || 
						password[i].equals("e") || 
						password[i].equals("i") || 
						password[i].equals("o") || 
						password[i].equals("u")) {
					vow++;
				} else con++;
			}
			if (vow >= 1 && con >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
			}
			con = 0;
			vow = 0;
			return;
		} else {
			for (int i = 0; i < words.length; i++) {
				if (visited[i] == false) {
					if (depth == 0 || password[depth-1].charAt(0) < words[i].charAt(0)) { // 사전순 조건
						visited[i] = true;
						password[depth] = words[i];
						make(words, L, depth+1);
						visited[i] = false;
					}
				}
			}
		}

	}
}