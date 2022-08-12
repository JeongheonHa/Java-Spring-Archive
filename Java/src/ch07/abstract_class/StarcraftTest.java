package ch07.abstract_class;

abstract class Unit {
	int x, y;
	abstract void move(int x, int y);
	void stop() {}
}

class Marine extends Unit {
	void move(int x, int y) {}
	void stimpack() {}
}

class Tank extends Unit {
	void move(int x, int y) {}
	void changeMode( ) {}
}

class Dropship extends Unit {
	void move(int x, int y) {}
	void load() {}
	void unload() {}
}

