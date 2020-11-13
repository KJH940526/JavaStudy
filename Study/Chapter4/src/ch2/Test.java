package ch2;

public class Test {
	public static void main(String[] args) {
		//반복문
		// 주어진 조건이 만족 할 때까지 수행문을 반복적으로 수행함
		// while, do-while, for문이 있음
		// 조건의 만족과 반복 가능 여부에 대해 정확한 코딩을 해야 함
		
		//while문 => 조건식이 참인 동안 수행문을 반복해서 수행
		int num = 1;
		int sum = 0;
		while(num <= 10) {
			sum += num; 
			num++;		//sum 변수에 기존 num 값을 먼저 대입한 후 num 값 1증가  //Chpt3 ch1
		}
		System.out.println(sum);
		System.out.println(num);   //10에서 증가를 해서 11로 되고 while에서 비교후 빠져 나온거기 떄문에 11이 된다
		System.out.println();
		num = 1;
		sum = 0;
		while(num < 1) {
			sum += num; 
			num++;
			System.out.println("바보"); //실행 안됨
		}
		System.out.println(sum);
		System.out.println();	
		
		//do while문
		num = 1;
		sum = 0;
		do {				//do문은 조건식(while)문이 뒤에 있기떄문에 무조건 한번은 실행된다.
			sum += num; 
			num++;
			System.out.println("바보");
		}while(num < 1);
		System.out.println(sum);
		System.out.println();
		
		// for문
		// 반복문 중 가장 많이 사용하는 반복문
		// 주로 조건이 횟수인 경우에 사용, 초기화식, 조건식,증감식을 한꺼번에 작성
		int num1;
		int sum1;
		// 초기화를 진행                   //num1 <=10(조건식); num1++(증감식)
		for (num1 = 1, sum1 = 0; num1 <= 10; num1++) {
			sum1 += num1;		//수행문
		// 초기화를 1번 수행하고 => 조건식에 만족하면 수행문 수행 => 증감식 수행 =>
		// 조건식이 만족하는지 체크 => 조건식이 만족하면 수행문 수행 => 조건식이 만족하지 않으면 for문 빠져 나옴
		}
		System.out.println(sum1);
		System.out.println(num1);  //10에서 증가를 해서 11로 되고 while에서 비교후 빠져 나온거기 떄문에 11이 된다
		System.out.println();
		
		//각 반복문의 쓰임
		//while 문  =>  하나의 조건식(참, 거짓)에 대해 반복수행이 이루어질떄 사용
		//do-while문 => 하나의 조건식(참, 거짓)에 대해 반복수행이 이루어질떄 사용, 단 조건식이 뒤에 잇기 떄문에 무조건 한번 이상은 수행됨
		//for문 => 수의 특정 범위, 횟수와 관련한 반복수행에서 주로 사용
		
		//중첩된 반복문 구구단 만들기
		int dan;
		int times;
		for(dan =2; dan <= 9; dan++) {
			for(times = 1; times <=9; times++) {
				System.out.println(dan + "X" + times + "=" + dan*times);
			}
			System.out.println();
		}
		
		//while문
		int dan1 = 2;
		int time1 = 1;
		
		while(dan1 <=9) {
			time1 = 1;  //주의 *** 초기화가 필요한 이유는 이미 안의 내부의 while문에서 9가 되버렸기때문에 다시 초기화 해줘야한다.
			while( time1<=9) {
				System.out.println(dan1 + "X" + time1 + "=" + dan1*time1);
				time1++; // 곱셈을 증가시켜줌
			}
			dan1++; //단을 증가 시켜줌
			System.out.println();
		}
		
		//continue문
		//반복문과 함께 쓰이며, 반복문 내부 continue 문을 만나면 이후 반복되는 부분을 수행하지 않고 조건식이나 증감식을 수행함
		
		int total = 0;
		int num3;
		// 1부터 100까지 짝수의 합 
		for (num3 =1; num3<=100; num3++) {
			if( (num3 % 2) == 1) {
				continue; //=> 다시 증감식으로 감 => 뒤에 +=에 가지 않음
			}
			total += num3;
		}
		System.out.println(total);
		System.out.println("--------");
		
		//break문
		//반복문에서 break 문을 만나면 더 이상 반복을 수행하지 않고 반복문을 빠져 나옴
		int sum4 = 0;
		int num4 = 0;
		
		while( sum4 < 100) {
			sum4 += num4;
			num4++;
		}
		System.out.println(sum4);
		System.out.println(num4);    //15
		sum4 = 0;
		num4 = 0;
		
		while (true) {
			sum4 += num4;
			if(sum4 > 100) {
				break;
			}
				num4++;
			
		}
		System.out.println(sum4);
		System.out.println(num4); //14에서 이미 100이 넘었고 break를 만낫기 때문에 반복문을 빠져나옴 => num4++ 이 실행안됨
		
		
		
	}

}
