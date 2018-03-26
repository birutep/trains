package lt.train.spotting.vagons;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VagonLocomotive extends Vagon{

	@Column (name="LOKO_TYPE")
	private int type; //1 and 2

	public VagonLocomotive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
}
