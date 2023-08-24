package thread;


// 쓰레드의 우선순위

/* 쓰레드의 우선순위 지정하기
 * void setPriority(int newPriority) 쓰레드의 우선순위를 지정한 값으로 변경한다.
 * int getPriority 쓰레드의 우선순위를 반환한다.
 * 
 * public static final int MAX_PRIORITY = 10  	최대우선순위
 * public static final int MIN_PRIORITY = 1  	최소우선순위
 * public static final int NORM_PRIORITY = 10  	보통우선순위
 * 
 * 쓰레드의 우선순위의 범위는 1~10 이며 숫자가 높을수록 우선순위가 높다.
 * 쓰레드 우선순위는 쓰레드를 생성한 쓰레드로부터 상속을 받는다.
 * main 쓰레드의 경우 우선순위가 5이기 때문에 main 메소드에서 생성하는 쓰레드의 우선순위는 자동적으로 5가 된다.
 * */

public class ThreadEx8 {
	
	public static void main(String[] args) {
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		th1.start();
		th2.start();
	}
}

class ThreadEx8_1 extends Thread {
	public void run() {
		for(int i=0; i <300; i++) {
			System.out.print("-");
			for(int x =0; x < 10000000; x++); 
		}
	}
}


class ThreadEx8_2 extends Thread {
	public void run() {
		for(int i=0; i <300; i++) {
			System.out.print("|");
			for(int x =0; x < 10000000; x++); // 우선순위가 높아지면 한 번에 작업이 끝나버릴 수 있기 때문에 아무 일도 하지 않는 반복문을 추가하여 작업을 지연시킴.
		}
	}
}

// th1과 th2 모두 main메소드에서 생성하였기 때문에 main 메서드를 실행하는 쓰레드의 우선순위인 5를 상속받았다.
// 그 다음에 th2.setPriority(7)로 th2의 우선순위를 7로 변경한 다음에 start()를 호출해서 쓰레드를 실행시켰다.
// 이처럼 쓰레드를 실행하기 전에만 우선순위를 변경할 수 있다는 것을 기억!!

// 쓰레드에 높은 순위를 준다고 해서 더 많은 실행시간과 실행기회를 갖게 되는 것은 아니다.









