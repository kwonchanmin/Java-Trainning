package thread;

public class ThreadEx2 {

	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
	}
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 실행결과
//java.lang.Exception
//at thread.ThreadEx2_1.throwException(ThreadEx2.java:17)
//at thread.ThreadEx2_1.run(ThreadEx2.java:13)

//이 예제는 새로 생성한 쓰레드에서 고의로 예외를 발생시키고 printStactTrace()를 이용해서 예외가 발생한 당시의 호출스택을 출력하는 예제
//호출스택의 첫 번째 메소드가 main메소드가 아니라 run메소드인 것을 확인하자!
// 지금처럼 쓰레드가 예외가 발생해서 종료가 되어도 다른 쓰레드에 영향을 주지 않는다
// 이유는 main쓰레드가 이미 종료되었기 때문이다.