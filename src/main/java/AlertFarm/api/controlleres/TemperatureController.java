package AlertFarm.api.controlleres;

import AlertFarm.api.services.ServicesException;
import AlertFarm.entities.Temperature;
import AlertFarm.api.services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping(path = "/temperature", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<List<Temperature>> getTemperatures(){
        try {
            return ResponseEntity.ok().body(temperatureService.getTemperatureList());
        } catch (ServicesException ex) {
            Logger.getLogger(HumidityController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping( value = "/temperature", method = RequestMethod.POST )
    public Temperature setTemperature(@RequestBody Temperature temperature){
        return temperatureService.addTemperature(temperature);
    }
}
