
public class RecursionTest {

	public static void main(String[] args) {
		int count = 0;
		recursive();
	}
	
	public static void recursive( ) {
		System.out.println( "recursive() called " );
		recursive();
	}

}
