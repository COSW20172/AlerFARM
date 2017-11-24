package AlertFarm.api.controlleres;

import AlertFarm.api.services.HumidityService;
import AlertFarm.api.services.ServicesException;
import AlertFarm.entities.Humidity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api")
public class HumidityController {

    @Autowired
    private HumidityService humidityService;

    @RequestMapping(path = "/humidity", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<List<Humidity>> getHumiditys(){

        try {

            return ResponseEntity.ok().body(humidityService.getHumidityList());
        } catch (ServicesException ex) {
            Logger.getLogger(HumidityController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/humiditys/{correo}", method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<List<Humidity>> getHumiditysId(@PathVariable("correo") String id){

        try {
            return ResponseEntity.ok().body(humidityService.getHumiditysId(id));
        } catch (ServicesException ex) {
            Logger.getLogger(HumidityController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping( value = "/humidity", method = RequestMethod.POST )
    public Humidity setHumidity(@RequestBody Humidity humidity){

        return humidityService.addHumidity(humidity);
    }
}
