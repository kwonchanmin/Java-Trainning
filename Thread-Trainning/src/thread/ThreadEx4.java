package thread;

public class ThreadEx4 {

	// 싱글 쓰레드 
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<300; i++) 
			System.out.printf("%s", new String("-"));
		
		
		System.out.print("소요시간1:" + (System.currentTimeMillis()-startTime));
		
		for(int i=0; i<300; i++) 
			System.out.printf("%s", new String("|"));
		
		
		System.out.print("소요시간2:" + (System.currentTimeMillis()-startTime));
		
	}
}

//실행결과
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//소요시간1:43
//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
//소요시간2:71

// 싱글 쓰레드로 수행시간을 측정한 결과 둘의 차이가 큰 것을 볼 수 있다.