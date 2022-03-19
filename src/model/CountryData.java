package model;

import java.util.ArrayList;
import java.util.Collections;

public class CountryData {
	private ArrayList<Country> data;

	public CountryData() {
		data = new ArrayList<Country>();
	}

	public void addCountry(Country c) {
		data.add(c);
	}

	// Natural sort
	public void sortFemales() {
		Collections.sort(data);
	}

	// External sort
	public void sortMales() {
		Collections.sort(data, (A, B) -> {
			int maleGoldOutput = 0;
			int maleSilverOutput = 0;
			int maleBronceOutput = 0;

			maleGoldOutput = B.getMaleGold() - A.getMaleGold();

			if (maleGoldOutput == 0) {
				maleSilverOutput = B.getMaleSilver() - A.getMaleSilver();

				if (maleSilverOutput == 0) {
					maleBronceOutput = B.getMaleBronce() - A.getMaleBronce();

					if (maleBronceOutput == 0) {
						return A.getName().compareTo(B.getName());
					} else {
						return maleBronceOutput;
					}
				} else {
					return maleSilverOutput;
				}
			} else {
				return maleGoldOutput;
			}
		});
	}

	// Selection sort implementation
	public void sortAll() {
		// Stores the position of the first unsorted element
	    for (int i = 0; i < data.size(); i++) {

	      int max = i;

	      for (int j = i + 1; j < data.size(); j++) {
	        int goldDifference = 0;
			int silverDifference = 0;
			int bronceDifference = 0;
			
			goldDifference = data.get(j).getTotalGold() - data.get(max).getTotalGold();
			
			if(goldDifference == 0) {
				silverDifference = data.get(j).getTotalSilver() - data.get(max).getTotalSilver();
				
				if(silverDifference == 0) {
					bronceDifference = data.get(j).getTotalBronce() - data.get(max).getTotalBronce();
					
					if(bronceDifference == 0 && data.get(j).getName().compareTo(data.get(max).getName()) < 0) {
						max = j;
					} else if(bronceDifference > 0){
						max = j;
					}
				} else if(silverDifference > 0){
					max = j;
				}
			} else if(goldDifference > 0){
				max = j;
			}

	      }
	      
	      // Swap the minimum with the first unsorted element
	      Country aux = data.get(max);
	      data.set(max, data.get(i));
	      data.set(i, aux);
	    }
	}

	public String printMales() {
		String msg = "----------\nMasculino";
		for (Country country : data) {
			msg += "\n" + country.getName() + " " + country.getMaleGold() + " " + country.getMaleSilver() + " "
					+ country.getMaleBronce();
		}
		return msg;
	}

	public String printFemales() {
		String msg = "----------\nFemenino";
		for (Country country : data) {
			msg += "\n" + country.getName() + " " + country.getFemGold() + " " + country.getFemSilver() + " "
					+ country.getFemBronce();
		}
		return msg;
	}

	public String printAll() {
		String msg = "----------\nCombinado";
		for (Country country : data) {
			msg += "\n" + country.getName() + " " + country.getTotalGold() + " " + country.getTotalSilver() + " "
					+ country.getTotalBronce();
		}
		return msg;
	}
}
