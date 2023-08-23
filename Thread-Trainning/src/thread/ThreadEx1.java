package thread;

class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1(); //t Thread의 자손 클래스의 인스턴스를 생
		
		Runnable r = new ThreadEx1_2(); // Runnable을 구현한 클래스의 인스턴스를 생
		Thread t2 = new Thread(r); 		// 생성자 Thread(Runnable target)
		
		// Thread t2 = new Thread(new ThreadEx1_2(); // 위의 두 줄을 한 줄로 간단히 한 코
		
		t1.start();	// Thread t1을 실행시킨다.
		t2.start();	// Thread t2를 실행시킨다.
		// start()가 호출되었다고 해서 바로 실행되는 것이 아니라, 일단 실행대기 상태에 있다가 자신의 차례가 되어야 실행된다.
		// 물론 대기중인 Thread가 없으면 즉시 실행된다. 
		
		// * 한번 실행이 종료된 thread는 다시 실행할 수 없다.
		// 즉, 하나의 Thread에 대해 start()가 한 번만 호출 될 수 있다는 것이다.
		// 만일 Thread의 작업을 한번 더 실행해야 된다면 새로운 Thread를 생성 후 start()를 다시 호출해야된다.
		
		// 잘못된 예  
		//		ThreadEx1_1 t1 = new ThreadEx1_1();
		//		t1.start();
		//		t1.start(); 여기서 예외상황이 발생된다. IllegalThreadStateException
		
		// 옳은 예
		//		ThreadEx1_1 t1 = new ThreadEx1_1();
		//		t1.start();
		//		t1 = new ThreadEx1_1(); // 다시 생
		//		t1.start();
	
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호
		}
	}
}

	// Thread를 상속받은 경우 자손 클래스에서 조상인 Thread클래스의 메소드를 직접 호출 할 수 있다.
	// 즉, ThreadEx1_1에서는 Thread를 상속받았기 때문에 간단히 getName()을 호출하면 된다.


class ThreadEx1_2 implements Runnable {
	public void run() {
		for(int i =0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()); // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
  		}
	}
}
	// Runnable을 구현한 ThreadEx1_2의 경우 멤버는 run() 밖에 없기 때문에 Threa 클래스의 getName()을 호출할려면 
	// Thread.currentThread().getName() 과 같이 해야한다.

	// * Thread의 이름은 생성자나 메서드를 통해서 지정 또는 변경할 수 있다.
	//	 Thread의 이름을 지정하지 않으면 'Thread-번호'의 형식으로 정해진다.

	// System.out.println(Thread.currentThread().getName())는 아래의 코드를 한 줄로 줄여 쓴 코드라고 이해하면 된다.
	//	Thread t = Thread.currentThread();
	//	String name = t.getName();
	//	System.out.println(name);


