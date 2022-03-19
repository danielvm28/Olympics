package model;

public class Country implements Comparable<Country>{
	//Attributes
	
	private String name;
	private int maleGold;
	private int maleSilver;
	private int maleBronce;
	private int femGold;
	private int femSilver;
	private int femBronce;
	private int totalGold;
	private int totalSilver;
	private int totalBronce;
	
	public Country(String name, int maleGold, int maleSilver, int maleBronce, int femGold, int femSilver,
			int femBronce) {
		super();
		this.name = name;
		this.maleGold = maleGold;
		this.maleSilver = maleSilver;
		this.maleBronce = maleBronce;
		this.femGold = femGold;
		this.femSilver = femSilver;
		this.femBronce = femBronce;
		totalGold = femGold + maleGold;
		totalSilver = femSilver + maleSilver;
		totalBronce = femBronce + maleBronce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaleGold() {
		return maleGold;
	}

	public void setMaleGold(int maleGold) {
		this.maleGold = maleGold;
	}

	public int getMaleSilver() {
		return maleSilver;
	}

	public void setMaleSilver(int maleSilver) {
		this.maleSilver = maleSilver;
	}

	public int getMaleBronce() {
		return maleBronce;
	}

	public void setMaleBronce(int maleBronce) {
		this.maleBronce = maleBronce;
	}

	public int getFemGold() {
		return femGold;
	}

	public void setFemGold(int femGold) {
		this.femGold = femGold;
	}

	public int getFemSilver() {
		return femSilver;
	}

	public void setFemSilver(int femSilver) {
		this.femSilver = femSilver;
	}

	public int getFemBronce() {
		return femBronce;
	}

	public void setFemBronce(int femBronce) {
		this.femBronce = femBronce;
	}

	public int getTotalGold() {
		return totalGold;
	}

	public void setTotalGold(int totalGold) {
		this.totalGold = totalGold;
	}

	public int getTotalSilver() {
		return totalSilver;
	}

	public void setTotalSilver(int totalSilver) {
		this.totalSilver = totalSilver;
	}

	public int getTotalBronce() {
		return totalBronce;
	}

	public void setTotalBronce(int totalBronce) {
		this.totalBronce = totalBronce;
	}
	
	// Natural sort implementation (just for females)
	@Override
	public int compareTo(Country o) {
		Country A = this;
		Country B = o;
		
		int femGoldOutput = 0;
		int femSilverOutput = 0;
		int femBronceOutput = 0;
		
		femGoldOutput = A.femGold - B.femGold;
		
		if(femGoldOutput == 0) {
			femSilverOutput = A.femSilver - B.femSilver;
			
			if(femSilverOutput == 0) {
				femBronceOutput = A.femBronce - B.femBronce;
				
				if(femBronceOutput == 0) {
					return B.name.compareTo(A.name);
				} else {
					return femBronceOutput;
				}
			} else {
				return femSilverOutput;
			}
		} else {
			return femGoldOutput;
		}
	}
}
