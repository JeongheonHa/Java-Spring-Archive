package ch07.inheritance;

class Tv {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

class VCR {
	boolean power;
	int counter = 0;
	void power() { power = !power; }
	void play()	{ }
	void stop() { }
	void rew() { }
	void ff() { }
}

// Tv클래스 상속받고 VCR클래스 포함관계를 이용해 다중상속처럼 사용 (java는 단일 상속만 허용)	
public class TVCRTest extends Tv{
	VCR vcr = new VCR();
	
	void play() {
		vcr.play();	// VCR class의 method 호출
	}
	
	void stop() {
		vcr.stop();
	}
	
	void rew() {
		vcr.rew();
	}
	
	void ff() {
		vcr.ff();
	}
}
