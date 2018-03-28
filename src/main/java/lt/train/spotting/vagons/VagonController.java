package lt.train.spotting.vagons;

import java.util.List;

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

@RestController
public class VagonController {

	@Autowired
	VagonService vagonServ;
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@RequestMapping(method=RequestMethod.GET, value="/vagons")
	@ApiOperation(value="Get all vagons")
	public @ResponseBody List<Vagon> getVagons(){
		return vagonServ.getAllVagons();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path= "/vagons/{vagonId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete vagon")
	public @ResponseBody void deleteVagon(@PathVariable Long vagonId) {
		vagonServ.deleteVagon(vagonId);
	}
	
	//Zemiau einantys vagonai yra sukuriami nepriskiriant ju kokiam nors traukiniui.
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST,value="/vagons/cargo")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create cargo vagon")
	public @ResponseBody void addCargoVagon(@RequestBody VagonCargo vagon) {
		vagonServ.createCargoVagon(vagon);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST,value="/vagons/pass")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create passenger vagon")
	public @ResponseBody void addPassengerVagon(@RequestBody VagonPassenger vagon) {
		vagonServ.createPassVagon(vagon);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST,value="/vagons/loko")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create locomotive vagon")
	public @ResponseBody void addLocomotiveVagon(@RequestBody VagonLocomotive vagon) {
		vagonServ.createLokoVagon(vagon);
	}
	
}
