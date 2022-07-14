package Park_Package;

public class Park {
	private String pNumber;
	private int pTime;
	
	Park(){
		pNumber = null;
		pTime =  0;
	}
	Park(String pNumbe ,int pTime){
		this.pNumber = pNumbe;
		this.pTime = pTime;
	}
	
	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public int getpTime() {
		return pTime;
	}
	
	public void setpTime(int pTime) {
		this.pTime = pTime;
	}

}
