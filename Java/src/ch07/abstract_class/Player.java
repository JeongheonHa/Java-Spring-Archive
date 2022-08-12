package ch07.abstract_class;

abstract class Player {
	int currentPos;
	
	Player() {			// 추상메서드 또한 생성자가 있어야한다.
		currentPos = 0;
	}
	
	abstract void play(int pos);	// 추상메서드
	abstract void stop();			// 추상메서드
	
	void play() {
		play(currentPos);
	}
}
