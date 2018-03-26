package lt.train.spotting.vagons;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VagonPassenger extends Vagon {

	@Column (name="PASSENGER_CATEGORY")
	private int category; //1/2/3

	public VagonPassenger() {
		super();
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
	
	
	
	
}
