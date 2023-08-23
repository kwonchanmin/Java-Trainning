package thread;

public class ThreadEx3 {

	public static void main(String[] args) {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
	}
}

class ThreadEx3_1 extends Thread{
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

//실행결과
//java.lang.Exception
//at thread.ThreadEx3_1.throwException(ThreadEx3.java:18)
//at thread.ThreadEx3_1.run(ThreadEx3.java:13)
//at thread.ThreadEx3.main(ThreadEx3.java:7)

// ThreadEx2와 다르게 쓰레드가 새로 생성되지 않았다. 그저 ThreadEx3_1 클래스의 run()이 호출되었을 뿐이다.
// ThreadEx2는 thread를 start 시켰을 경우 main 쓰레드 호출스택에 main메소드가 이미 종료되어 없었지만 
// ThreadEx3의 경우 thread를 run 시켰기 때문에  main 쓰레드 호출스택에 main메소드가 포함되어있다.