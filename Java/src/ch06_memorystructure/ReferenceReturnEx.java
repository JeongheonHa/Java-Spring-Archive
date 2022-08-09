package ch06_memorystructure;

public class ReferenceReturnEx {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		
		Data d2 = copy(d);
		System.out.println("d.x = " + d.x);
		System.out.println("d2.x = " + d2.x);
	}
	
	static Data copy(Data d) {
		Data temp = new Data();
		temp.x = d.x;
		
		return temp;
	}
}

class Data { int x; }

/*
d.x = 10
d2.x = 10
*/