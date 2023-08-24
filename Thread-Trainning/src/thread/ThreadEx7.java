package thread;

import javax.swing.JOptionPane;

public class ThreadEx7 {

	public static void main(String[] args) throws Exception {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
	}
}

class ThreadEx7_1 extends Thread {
	public void run() {
		for(int i=10; i >0 ; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {}
		}
	} // run()
}

/* ThreadEx6과 달리 ThreadEx7는 사용자로부터 입력받는 부분과 화면에 숫자를 출력하는 부분을 두 개의 쓰레드로 나눠서 처리했기 때문에
  입력을 마치지 않아도 화면에 숫자가 출력된다.
  또한 입력을 하게 될 경우 숫자의 출력 중간에 입력한 문자가 출력된다. */
