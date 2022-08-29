package ch15.io;

import java.io.*;
import java.util.Arrays;

public class IoEx1 {

	public static void main(String[] args) {
		// byte 배열 생성
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		// 바이트기반 스트림 선언
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		// byte 배열 소스의 바이트기반 스트림 생성
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		// 입력 스트림에서 읽어온 데이터가 -1이 아니라면 (데이터를 읽어왔다면)
		while((data = input.read()) != -1) {
			// 출력스트림을 통해 데이터를 쓴다.
			output.write(data);
		}
		// 스트림 내용을 byte배열로 반환
		outSrc = output.toByteArray();
		
		System.out.println("Input Source :" + Arrays.toString(inSrc));
		System.out.println("output Source :" + Arrays.toString(outSrc));

	}

}
