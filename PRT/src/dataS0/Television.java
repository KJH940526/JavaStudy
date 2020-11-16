package dataS0;

public class Television implements RemoteControl{
	private int volumn;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV¸¦ ÄÕ´Ï´Ù.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV¸¦ ²ü´Ï´Ù.");
	}

	@Override
	public void setVolumn(int volumn) {
		// TODO Auto-generated method stub
		if(volumn > RemoteControl.MAX_VOLUMN) {
			this.volumn = RemoteControl.MAX_VOLUMN;
		} else if(volumn < RemoteControl.MIN_VOLUMN) {
			this.volumn = RemoteControl.MIN_VOLUMN;
		} else {
			this.volumn = volumn;
		}
		System.out.println("ÇöÀç TV º¼·ý: " + this.volumn);
	}
	
	
}