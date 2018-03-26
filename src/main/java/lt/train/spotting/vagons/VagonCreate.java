package lt.train.spotting.vagons;


import lt.train.spotting.trains.Train;

public class VagonCreate {
	
	private String org;
	
	private int units;
	
	private double price;
	
	private double volume;
	
	private Train train;
	
	private double powerForCargo;
	
	private int typeForLoko;
	
	private int categoryForPass; //1/2/3
	
	private int type; //1-loko, 2-cargo, 3-pass

	public VagonCreate() {}


	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public double getPowerForCargo() {
		return powerForCargo;
	}

	public void setPowerForCargo(double powerForCargo) {
		this.powerForCargo = powerForCargo;
	}

	public int getTypeForLoko() {
		return typeForLoko;
	}

	public void setTypeForLoko(int typeForLoko) {
		this.typeForLoko = typeForLoko;
	}

	public int getCategoryForPass() {
		return categoryForPass;
	}

	public void setCategoryForPass(int categoryForPass) {
		this.categoryForPass = categoryForPass;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
}
