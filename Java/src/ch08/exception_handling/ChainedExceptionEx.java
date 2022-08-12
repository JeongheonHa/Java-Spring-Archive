package ch08.exception_handling;

class ChainedExceptionEx {

	public static void main(String[] args) {
		try {
			install();
		} catch(InstallException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}	// main
	
	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException se) {
			InstallException ie = new InstallException("설치 중 예외발생");
			ie.initCause(se);
			throw ie;	
		} catch (MemoryException me) {
			InstallException ie = new InstallException("설치 중 예외발생");
			ie.initCause(me);
			throw ie;
		}	finally {
		
			deleteTempFiles();
		} // try
	}


static void startInstall() throws SpaceException, MemoryException {
	if(!enoughSpace()) {
		throw new SpaceException("설치할 공간이 부족합니다.");
	}
	
	if (!enoughMemory()) {
		throw new MemoryException("메모리가 부족합니다.");
		// throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
	}
} // startInstall

	static void copyFiles() {}
	static void deleteTempFiles() {}

	static boolean enoughSpace() {
		return false;
	}

	static boolean enoughMemory() {
		return true;
	}
} // ExceptionTest

@SuppressWarnings("serial")
class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}
