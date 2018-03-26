package lt.train.spotting.trains;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lt.train.spotting.vagons.Vagon;

@Entity
@Table(name="TRAINS")
public class Train {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="ID", nullable=false)
	private Long tId;
	
	@Column (name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column (name="ORGANIZATION")
	private String org;
	
	@Column (name="CIRY")
	private String city;

	@OneToMany(mappedBy="train", cascade = CascadeType.ALL)
	private Set<Vagon> vagons;

	public Train() {}


	public Long gettId() {
		return tId;
	}

	public void settId(Long tId) {
		this.tId = tId;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Vagon> getVagons() {
		return vagons;
	}

	public void setVagons(Set<Vagon> vagons) {
		this.vagons = vagons;
	}

	public void addVagon(Vagon vagon) {
		vagon.setTrain(this);
		this.vagons.add(vagon);
	}
	
	public double getTotalTrainPrice() {
		double priceTotal = 0;
		for (Vagon vagon:vagons) {
			priceTotal = priceTotal + vagon.getTotalVagonsPrice();
		}
		return priceTotal;
	}
}
