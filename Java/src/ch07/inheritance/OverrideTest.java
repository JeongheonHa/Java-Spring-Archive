package ch07.inheritance;

class MyPoint {
	int x;
	int y;
	String getLocation() {
		return "x:"+x+", y:"+y;
	}
}

class MyPoint3D extends MyPoint {
	int z;
	
	// 조상의 getLocation()을 오버라이딩 (오버라이딩한 메서드를 호출)	
	String getLocation() {
		return "x:"+x+", y:"+y+", z:"+z;
	}
}

public class OverrideTest {

	public static void main(String[] args) {
		MyPoint3D p = new MyPoint3D();
		p.x = 3;
		p.y = 5;
		p.z = 7;
		System.out.println(p.getLocation());
	}

}
