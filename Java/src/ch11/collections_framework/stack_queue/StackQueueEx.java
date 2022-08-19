package ch11.collections_framework.stack_queue;

import java.util.*;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		// stack에 추가
		st.push("0");
		st.push("1");
		st.push("2");
		// queue에 추가
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("Stack");
		// 스택이 비어있지 않다면 true
		while(!st.empty()) {
			// 꺼내기 (LIFO)
			System.out.println(st.pop());
		}
		
		System.out.println("Queue");
		// 큐가 비어있지않다면 true
		while(!q.isEmpty()) {
			// 꺼내기(FIFO)
			System.out.println(q.poll());
		}
	}

}
/*
Stack
2
1
0
Queue
0
1
2
*/