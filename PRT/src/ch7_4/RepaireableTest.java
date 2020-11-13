package ch7_4;

interface Repairbale{}

class Unit{
	int hitpoint;
	final int MAX_HP;
	Unit(int hp){
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit{
	GroundUnit(int hp){
		super(hp);
	}
}

class AirUnit extends Unit{
	AirUnit(int hp){
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairbale{
	Tank(){
		super(150);
		hitpoint = MAX_HP;
	}
	
	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairbale{
	Dropship(){
		super(125);
		hitpoint = MAX_HP;
	}
	
	public String toString() {
		return "Dropship";
	}
}

class Marine extends GroundUnit{
	Marine(){
		super(40);
		hitpoint = MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairbale {
	SCV(){
		super(60);
		hitpoint = MAX_HP;
	}
	
	void repair(Repairbale r) {
		if (r instanceof Unit) {
			Unit u = (Unit)r;
			while(u.hitpoint != u.MAX_HP) {
				u.hitpoint++;
			}
			System.out.println(u.toString()+"의 수리가 끝났습니다.");
		}
	}
}



public class RepaireableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
	}

}
