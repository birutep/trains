package lt.train.spotting.trains;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.train.spotting.vagons.Vagon;

@Service
public class TrainService {

	@Autowired
	TrainRepository trainRep;
		
	public TrainService() {}

//	public TrainService(TrainRepository trainRep) {
//		this.trainRep = trainRep;
//	}

	@Transactional(readOnly=true)
	public List<Train> getAllTrains(){
		return trainRep.findAll();
	}
	
	@Transactional
	public Train getTrainById(Long id) {
		Train train = trainRep.findById(id).get();
		return train;
	}
	
	public List<Vagon> getVagonsFromTrains(Long id){
		List<Vagon> vagonsList = new ArrayList<Vagon>();
		Set<Vagon> vagonsSet = trainRep.getOne(id).getVagons();
		for (Vagon vagon : vagonsSet) {
			vagonsList.add(vagon);
		}
		return vagonsList;
	}
	
	@Transactional
	public void createTrain(Train train) {
		trainRep.save(train);
	}
	
	@Transactional
	public void updateTrain(Long trainId, Train train) {
		Train currentTrain = trainRep.getOne(trainId);
	
			currentTrain.setCity(train.getCity());
			currentTrain.setDate(train.getDate());
			currentTrain.setOrg(train.getOrg());
			currentTrain.setVagons(train.getVagons());
			trainRep.saveAndFlush(currentTrain);
		
	}
	
	@Transactional
	public void deleteTrain(Long id) {
		trainRep.deleteById(id);
	}
	
}
