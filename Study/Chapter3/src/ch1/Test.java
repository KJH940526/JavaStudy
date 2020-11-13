package ch1;

public class Test {
	public static void main(String[] args) {
		//대입 연산자
		//변수에 값을 대입하는 연산자
		//우선 순위가 가장 낮은 연산자
		//왼쪽 변수에 오른쪽 변수(값)를 대입
		int age = 24;
		System.out.println(age);
		System.out.println();
		
		//부호 연산자
		int num = 10;
		int num2 = -num;
		System.out.println(num);
		System.out.println(num2);
		num = -num;
		System.out.println(num);
		System.out.println();
		// 산술 연산자
		// %는 나머지를 구하는 연산자 => 숫자 n의 나머지는 0~n-1 범위의 수 => 특정 범위 안의 수를 구할 때 종종 사용
		
		// 증가 감소 연산자
		// 단항 연산자
		// 1만큼 더하거나 만큼 뺄 때 사용하는 연산자
		// 항의 앞/뒤 위치에 따라 연산의 결과가 달라짐에 유의
		num = 10;
		int val = ++num; //먼저 num값이 1 증가한 후 val 변수에 대입  
		System.out.println(val);
		
		num = 10;
		System.out.println(num++);
		
		num = 10;
		int val2 = num++; //val 변수에 기존 num 값을 먼저 대입한 후 num 값 1증가  
		System.out.println(val2);
		System.out.println(num);
		System.out.println();
		
		// 관계연산자
		// 연산의 결과가 true,false로 반환 됨
		System.out.println(3<5);
		System.out.println();
		
		//논리 연산자
		// 관계 연산자와 혼합하여 많이 사용 됨
		// 연산의 결과가 true, false으로 반한됨
		// &&(논리곱) 두 항이 모두 참인 경우에만 참, 아니면 거짓
		// ||(논리합) 두 항 중 하나의 항만 참이면 참, 두 항이 모두 거짓이면 결과 값은 거짓
		// ! (부정) 단항 연산자입니다. 참인 경우는 거짓으로 바꾸고, 거짓인 경우는 참으로 바꿈 ex) boolean = !(5>3)
		System.out.println((5>3)&&(5>2)); //t
		System.out.println((5>3)&&(5<2)); //f
		
		System.out.println((5>3)||(5>2)); //t
		System.out.println((5>3)||(5<2)); //t
		System.out.println((5<3)||(5<2)); //f

		System.out.println((5>3)); //t
		System.out.println(!(5>3)); //f
		System.out.println();
		
		// 추가! ****단락 회로 평가****
		// 논리 곱은 두 항이 모두 true 일 떄만 결과가 true => 앞의 항이 false 이면 뒤 항의 결과는 평가하지 않아도 false임
		// 논리 합은 두 항이 모두 false 일 때만 결과가 false => 앞의 항이 true 이면 뒤 항의 결과를 평가하지 않아도 true임
		
		int num1 = 10;
		int i = 2;
		// 논리 곱은 두 항이 모두 true 일 떄만 결과가 true => 앞의 항이 false 이면 뒤 항의 결과는 평가하지 않아도 false임
						//앞의 항의 false => && 뒤의 항이 계산X
		boolean value = ((num1 = num1 + 10 ) < 10 && ( (i = i+2)> 10));
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i); 
		
		num1 = 10;
		i = 2;
							//앞의 항이 true => && 뒤의 항이 계산
		boolean value1 = ((num1 = num1 + 10 ) > 10 && ( (i = i+2)> 10));
		System.out.println(value1);
		System.out.println(num1);
		System.out.println(i); 
		
		// 논리 합은 두 항이 모두 false 일 때만 결과가 false => 앞의 항이 true 이면 뒤 항의 결과를 평가하지 않아도 true임
		num1 = 10;
		i = 2;
							//앞의 true => || 뒤의 항 계산 X
		boolean value3 = ((num1 = num1 + 10 ) > 10 || ( (i = i+2)> 10));
		System.out.println(value3);
		System.out.println(num1);
		System.out.println(i); 
		
		num1 = 10;
		i = 2;
							//앞의 false => || 뒤의 항 계산
		boolean value4 = ((num1 = num1 + 10 ) < 10 || ( (i = i+2)> 10));
		System.out.println(value4);
		System.out.println(num1);
		System.out.println(i); 
		
	}
}
