package lt.train.spotting.vagons;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VagonCargo extends Vagon{

	@Column (name="CARGO_POWER")
	private double power;

	public VagonCargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	} 

	
}
