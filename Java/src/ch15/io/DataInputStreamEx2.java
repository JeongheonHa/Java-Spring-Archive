package ch15.io;

import java.io.*;

public class DataInputStreamEx2 {

	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		// 기반 스트림 선언
		FileInputStream fis = null;
		// 보조 스트림 선언
		DataInputStream dis = null;
		// readInt()은 예외를 발생할 수 있으므로 예외처리
		try {
			// score.dat파일로의 입력스트림 생성
			fis = new FileInputStream("score.dat");
			// 기반 스트림의 보조스트림 생성
			dis = new DataInputStream(fis);
			
			while(true) {
				// 무한루프를 이용해 score.dat의 내용을 읽어온다.
				score = dis.readInt();
				// 읽어온 내용을 출력
				System.out.println(score);
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum + "입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {	// 작업도중에 예외가 발생해서 스트림을 닫지 못하고 try블럭을 빠져나갈 수 있기 때문에 finally블럭에서 스트림을 닫도록 처리
			try {
				// dis가 null일 때 close()호출할 경우 NullPointerException 발생
				if(dis != null)
					dis.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
	}
}
