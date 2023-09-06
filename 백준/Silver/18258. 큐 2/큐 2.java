import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] queue = new int[10000000];
	public static int front = -1;
	public static int rear = -1;
	
	public static void enqueue(int value) {
		queue[++rear] = value;
	}
	
	public static int isEmpty() {
		if(front == rear) return 1;
		else return 0;
	}
	
	public static int dequeue() {
		if(isEmpty() == 1) {
			return -1;
		} else {
			return queue[++front];
		}
	}
	
	public static int size() {
		return rear - front;
	}
	
	public static int front() {
		if(isEmpty() == 1) {
			return -1;
		} else {
			return queue[front+1];
		}
	}
	
	public static int back() {
		if(isEmpty() == 1) {
			return -1;
		} else {
			return queue[rear];
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder st = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.split(" ").length > 1) {
				enqueue(Integer.parseInt(str.split(" ")[1]));
			} else {
				if(str.equals("pop")) {
					st.append(dequeue() + "\n");
				} else if(str.equals("size")) {
					st.append(size() + "\n");
				} else if(str.equals("empty")) {
					st.append(isEmpty() + "\n");
				} else if(str.equals("front")) {
					st.append(front() + "\n");
				} else if(str.equals("back")) {
					st.append(back() + "\n");
				}
			}
		}
		
		bw.write(st.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}
	
}
