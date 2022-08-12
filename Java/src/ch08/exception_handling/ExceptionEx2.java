package ch08.exception_handling;

import java.io.*;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// command line에서 입력받는 값을 이름으로 갖는 파일 생성
		File f = createFile(args[0]);
		System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다");
	}
	
	@SuppressWarnings("finally")
	static File createFile(String fileName) {
		try {
			if (fileName == null || fileName.equals(""))
				throw new Exception("파일 이름이 유효하지 않습니다.");
		} catch (Exception e) {
			// fileName이 부적절한 경우, 파일 이름을 '제목없음.txt로 한다
			fileName = "제목없음.txt";
		} finally {
			final File f = new File(fileName);	// File클래스 객체를 만든다.
			createNewFile(f);	// 생성된 객체를 이용해 파일 생성
			return f;
		}
	}
	
	static void createNewFile(File f) {
		try {
			f.createNewFile();	// 파일을 생
		} catch(Exception e) { }
	}
}
