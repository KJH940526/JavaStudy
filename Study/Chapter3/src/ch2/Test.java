package ch2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 복합 대입 연산자
		// 대입 연산자와 다른 연산자를 함께 사용함
		// 프로그램에서 자주 사용하는 연산자
		// num1 += 2; 
		// num1 = num1 +2 ; 와 같음
		int num1 = 10;
		System.out.println(num1 += 1);
		System.out.println(num1);
		int num2 = 10;
		num2 = num2 + 1;
		System.out.println(num2);
		System.out.println();
		
		// 조건 연산자
		// 삼항 연산자
		// 조건 식의 결과가 참인 경우와 거짓인 경우에 따라 다른 식이나 결과가 수행됨
		// 제어문 중 조건문을 간단히 표현할 때 사용할 수 있음
		//         조건식 ? 결과1 : 결과2      
		int num3 = (5>3) ? 10 : 20;
		System.out.println(num3);
		System.out.println();
		
		//비트 연산자 + 쉬프트 연산자
		//비트 연산자는 정수에서만 사용가능
		int num4 = 5;    			  //0000 0101
		int num5 = 10;				  //0000 1010
		//비트 연산자 & 두 비트가 모두 1인 경우에만 1 아니면 0   (비트곱)
		int result = num4 & num5;    
		System.out.println(result);  //두비트가 0이기 떄문에 0이 나옴

		num5 = 15;                   //0000 1111
		int result2 = num4 & num5;   
		System.out.println(result2); //0000 0101 이 되기때문에 5가 나옴
		
		//비트 연산자 | 두 비트가 모두 0인 경우만 0 아니면 1   (비트 차)
		int num6 = 5;				//0000 0101
		int num7 = 10;				//0000 1010
		int result3 = num6 | num7;  
		System.out.println(result3); //0000 1111 이므로 15가 나옴
		
		//비트 연산자 ^ 두개의 비트가 서로 다른 경우에 1반환   (비트 합)
		int num8 = 5;				//0000 0101
		int num9 = 11;				//0000 1011
		int result4 = num8 ^ num9;
		System.out.println(result4); //000 1110 이 되므로 14가 나옴
		
		//비트 반전연산자 ~ 비트 값을 0은 1로 1은 0으로 바꾸는 연산자 			// 잘모르겠음
		int num10 = 10;				//0000 1010
		int result5 = ~num10;       
		System.out.println(result5);
		System.out.println();
		
		//비트연산자(쉬프트)
		// << (왼쪽 shift) : 비트를  왼쪽에서 오른쪽으로 이동하는 연산자
		// >> (오른쪽 shift) : 비트를 오른쪽에서 왼쪽으로 이동하는 연산자
		// <<<, >>> : shift로 비트이동은 동일한데, 남은 공간을 무조건 부호비트가 아닌 0으로 채움
										// int는 4바이트 => 1바이트는 8비트
		int num11 = 15;					//00000000 00000000 00000000 00001111
		int num12 = num11 << 2;			//00000000 00000000 00000000 00111100
		System.out.println(num12);      // 60
		System.out.println(num12 <<= 1); //비트를 사용한 복합 대입연산자
		System.out.println(num12);
		
		int num13 = num11 >> 2;       //00000000 00000000 00000000 00000011
		System.out.println(num13);
		
		//연산자 우선 순위   //  https://raccoonjy.tistory.com/9 (참고)
		// 일차식 => 단항(++,--,!) => 산술(곱하기,나누기,나머지) => 산술(더하기,빼기)
		// => 비트이동 => 관계(<,>,<=,>=) => 관계(==, !=) => 비트곱(&) => 비트 차(^) => 비트 합(|)
		// => 논리 곱 && => 논리 합 || => 조건 ? : : => 대입 (=, +=, -=, *=, %=, /=)
	}

}
