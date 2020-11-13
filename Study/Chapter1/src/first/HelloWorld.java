package first;

public class HelloWorld {
//JDK를 설치하고 JRE를 설치하는데 JRE는 8을 설치하자!
//이클립스도 2019년꺼 사용하자!
	
//프로그래밍: 컴퓨터에게 일을 하도록 명령어를 만드는 것
//컴파일 : 프로그램 언어를 컴퓨터가 알 수 있는 언어로 바꿔 주는 일
//컴파일러 : 기계어로 번역해주는 프로그램! 자바를 설치하면 자바 컴파일러도 설치 됨 	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub    
		//한줄 지우기는 컨트롤 D
		System.out.println("Hello, World");
	}
//저장하는 순간 컴파일이 된다.
//실행은 Run하자!
}

// 워크스페이스 안에 First안에 src안에 first라는 폴더 패키지 안에 HelloWorld.java가 있음
// 컴파일이 되면 First안에 bin안에 first에 HelloWorld.class로 컴파일되서
// HelloWorld.class가 자바 컴파일러에 도움을 받아서 실행된다.

// 자바는 플랫폼에 영향을 받지 않으므로 다양한 환경에서 사용 가능 -> JVM 덕분
// 한번 더 해석을 하기 때문에 조금 느림
// 자바 소스 코드 -> 컴파일러 -> 자바 클래스 -> 자바 가상 머신 -> 실행 

// 자바의 장점
// 1. 객체 지향 언어이기 떄문ㅁ에 유지보수가 쉽고 확장성이 좋다
// 2. 프로그램이 안정적이다.
// 3. 풍부한 기능을 제공하는 오픈 소스이다.
