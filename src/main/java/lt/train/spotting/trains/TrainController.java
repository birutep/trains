package lt.train.spotting.trains;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lt.train.spotting.vagons.Vagon;
import lt.train.spotting.vagons.VagonCargo;
import lt.train.spotting.vagons.VagonCreate;
import lt.train.spotting.vagons.VagonLocomotive;
import lt.train.spotting.vagons.VagonPassenger;
import lt.train.spotting.vagons.VagonService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainServ;

	@Autowired
	VagonService vagonServ;
	
	public TrainController() {}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@RequestMapping(method=RequestMethod.GET, value="/trains")
	@ApiOperation(value="Get all trains")
	public @ResponseBody List<Train> getTrains(){
		return trainServ.getAllTrains();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@RequestMapping(method=RequestMethod.GET, path= "/trains/{trainId}")
	@ApiOperation(value="Get train by ID")
	public @ResponseBody Train findTrainById(@PathVariable Long trainId) {
		return trainServ.getTrainById(trainId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST,value="/trains")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create train")
	public @ResponseBody void addTrain(@RequestBody Train train) {
		trainServ.createTrain(train);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.PUT, value="/trains/{trainId}")
	public @ResponseBody void updateTrainInfo(@PathVariable Long trainId, @RequestBody Train train) {
		trainServ.updateTrain(trainId, train);
	} 	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path= "/trains/{trainId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete train")
	public @ResponseBody void deleteTrain(@PathVariable Long trainId) {
		trainServ.deleteTrain(trainId);
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@RequestMapping(method=RequestMethod.GET, value="/trains/{trainId}/vagons")
	@ApiOperation(value="Get all vagons for one particular train")
	public @ResponseBody List<Vagon> getVagonsForOneTrain(@PathVariable Long trainId){
		return trainServ.getVagonsFromTrains(trainId);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST, value="/trains/{trainId}/vagons")
	@ApiOperation(value="Add new vagon for the train")
	public @ResponseBody void addVagonToTrain(@PathVariable Long trainId, @RequestBody VagonCreate vagon) {
		vagon.setTrain(trainServ.getTrainById(trainId));
		vagonServ.createVagon(vagon);
	}
	
	
//	@RequestMapping(method=RequestMethod.POST, value="/trains/{trainId}/cargo")
//	@ApiOperation(value="Add new vagon for the train")
//	public @ResponseBody void addVagonCARGOtoTrain(@PathVariable Long trainId, @RequestBody VagonCargo vagon) {
//		vagon.setTrain(trainServ.getTrainById(trainId));
//		vagonServ.createCargoVagon(vagon);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/trains/{trainId}/passenger")
//	@ApiOperation(value="Add new vagon for the train")
//	public @ResponseBody void addVagonPASSENtoTrain(@PathVariable Long trainId, @RequestBody VagonPassenger vagon) {
//		vagon.setTrain(trainServ.getTrainById(trainId));
//		vagonServ.createPassVagon(vagon);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/trains/{trainId}/locomotive")
//	@ApiOperation(value="Add new vagon for the train")
//	public @ResponseBody void addVagonLOKOtoTrain(@PathVariable Long trainId, @RequestBody VagonLocomotive vagon) {
//		vagon.setTrain(trainServ.getTrainById(trainId));
//		vagonServ.createLokoVagon(vagon);
//	}
	
	
	
	
	
	
	
	
	
	
}
