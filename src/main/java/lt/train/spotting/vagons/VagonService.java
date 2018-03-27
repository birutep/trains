package lt.train.spotting.vagons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VagonService {

	@Autowired
	VagonRepository vagonRep;
	
	public VagonService() {}
	
//	public VagonService(VagonRepository vagonRep) {
//		this.vagonRep = vagonRep;
//	}

	@Transactional(readOnly=true)
	public List<Vagon> getAllVagons(){
		return vagonRep.findAll();
	}
	
	@Transactional
	public void createVagon(VagonCreate vagon) {	
		if (vagon.getType()==1) {
			VagonLocomotive vagonLoko = new VagonLocomotive();
			vagonLoko.setOrg(vagon.getOrg());
			vagonLoko.setPrice(vagon.getPrice());
			vagonLoko.setTrain(vagon.getTrain());
			vagonLoko.setVolume(vagon.getVolume());
			vagonLoko.setType(vagon.getTypeForLoko());
			vagonLoko.setUnits(vagon.getUnits());
			vagonRep.save(vagonLoko);
			System.out.println("Loko");
		}
		else if (vagon.getType()==2) {
			VagonCargo vagonCargo = new VagonCargo();
			vagonCargo.setOrg(vagon.getOrg());
			vagonCargo.setPrice(vagon.getPrice());
			vagonCargo.setTrain(vagon.getTrain());
			vagonCargo.setVolume(vagon.getVolume());
			vagonCargo.setUnits(vagon.getUnits());
			vagonCargo.setPower(vagon.getPowerForCargo());
			vagonRep.save(vagonCargo);
		}
		else if (vagon.getType()==3) {
			VagonPassenger vagonPass = new VagonPassenger();
			vagonPass.setOrg(vagon.getOrg());
			vagonPass.setPrice(vagon.getPrice());
			vagonPass.setTrain(vagon.getTrain());
			vagonPass.setVolume(vagon.getVolume());
			vagonPass.setUnits(vagon.getUnits());
			vagonPass.setCategory(vagon.getCategoryForPass());
			vagonRep.save(vagonPass);
		}
	}
	
	
	@Transactional
	public void createCargoVagon(VagonCargo vagon) {
		vagonRep.save(vagon);
	}
	
	
	@Transactional
	public void createPassVagon(VagonPassenger vagon) {
		vagonRep.save(vagon);
	}
	
	@Transactional
	public void createLokoVagon(VagonLocomotive vagon) {
		vagonRep.save(vagon);
	}
	
	@Transactional
	public void deleteVagon(Long id) {
		vagonRep.deleteById(id);;
	}
	
}
