package lt.train.spotting.vagons;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.train.spotting.trains.Train;

@Entity
@Table(name="VAGONS")
public class Vagon {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="ID")
	private Long vId;
	
	@Column (name="PRODUCER")
	private String org;
	
	@Column (name="UNITS")
	private int units;
	
	@Column (name="PRICE")
	private double price;
	
	@Column (name="VOLUME")
	private double volume;
	
	@ManyToOne
	@JoinColumn(name="TRAIN_ID")
	@JsonIgnore
	private Train train;

	public Vagon() {
	}

	public Long getvId() {
		return vId;
	}

	public void setvId(Long vId) {
		this.vId = vId;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
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
	
	@JsonIgnore
	public double getTotalVagonsPrice() {
		return this.price*this.units;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	
}
