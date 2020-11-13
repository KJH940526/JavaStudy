package ch7_1;

//class Deck{
//	final int CARD_NUM = 52;
//	Card cardArr[] = new Card[CARD_NUM]; // Card객체 배열을 포함 
//	
//	Deck() {		//Deck의 카드를 초기화한다.
//		int i=0;
//		
//		for(int k=Card.KIND_NUM; k> 0; k--) {
//			for(int n=0; n < Card.NUM_MAX; n++) {
//				cardArr[i++] = new Card(k, n+1);
//			}
//		}
//	}
//
//
//	
//	Card pick(int index) {  //지정된 위치(index)에 있는 카드 하나를 꺼내서 반환
//		return cardArr[index];
//	}
//	
//	Card pick() {				//Deck에서카드 하나를 선택한다.
//		int index = (int)(Math.random()* CARD_NUM);
//		return pick(index);
//	}
//	
//	void Shuffle() {
//		for(int i=0; i< cardArr.length; i++) {
//			int r = (int)(Math.random() * CARD_NUM);
//			
//			Card temp = cardArr[i];
//			cardArr[i] = cardArr[r];
//			cardArr[r] = temp;
//		}
//	}
//}
//
//class Card {
//	static final int KIND_NUM = 4;
//	static final int NUM_MAX = 13;
//	
//	static final int SPADE = 4;
//	static final int DIAMOND = 3;
//	static final int HEART = 2;
//	static final int CLOVER = 1;
//	
//	int kind;
//	int number;
//	
//	Card(){
//		this(SPADE,1);
//	}
//	
//	Card(int kind, int number){
//		this.kind = kind;
//		this.number = number;
//	}
//	
//	public String toString() {
//	      String[] kinds = {"", "CLOVER", "HEART", "DIAMOND","SPADE"};
//	      String numbers = "0123456789XJQK";
//	      
//	      return "kind: " + kinds[this.kind]
//	    		  + ",number : " + numbers.charAt(this.number);
//	  }
//
//public class DeckTest {
//	public static void main(String[] args) {
//		Deck d = new Deck();
//		Card c = d.pick(0);
//		System.out.println(c);
//		
//		d.Shuffle();
//		c = d.pick(0);
//		System.out.println(c);
//	}
//
//}


class Deck {
   final int CARD_NUM = 52;
   Card cardArr[] = new Card[CARD_NUM];
   
   Deck() {
      int i = 0;
      
      for(int k = Card.KIND_NUM; k > 0 ; k--) { // KIND_MAX = 4(카드 종류)
         for(int n = 0 ; n < Card.NUM_MAX ; n++) {
            cardArr[i++] = new Card(k, n+1);
         }
      }
   }
   
   Card pick(int index) {
      return cardArr[index];
   }
   
   Card pick() { // 카드 한장 고르기
      int index = (int)(Math.random()* CARD_NUM);
      return pick(index);
   }
   
   void Shuffle() { // 카드 순서 섞기
      for(int i = 0 ; i < cardArr.length ; i++) {
         int r = (int)(Math.random() * CARD_NUM);
         
         Card temp = cardArr[i];
         cardArr[i] = cardArr[r];
         cardArr[r] = temp;
      }
   }
}

class Card {
   static final int KIND_NUM = 4;
   static final int NUM_MAX = 13;
   
   static final int SPADE = 4;
   static final int DIAMOND = 3;
   static final int HEART = 2;
   static final int CLOVER = 1;
   
   int kind;
   int number;
   
   Card(){
      this(SPADE, 1);
   }
   
   Card(int kind, int number){
      this.kind = kind;
      this.number = number;
   }
   
   public String toString() {
      String[] kinds = {"", "CLOVER", "HEART", "DIAMOND","SPADE"};
      String numbers = "0123456789XJQK";
      
      return "kind: " + kinds[this.kind]
	  + ",number : " + numbers.charAt(this.number);
   }
}

public class DeckTest {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Deck d = new Deck();
      Card c = d.pick(0);
      System.out.println(c);
      
      d.Shuffle();
      c = d.pick(0);
      System.out.println(c);
   }

}