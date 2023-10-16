package lk.nexttravel.vehicleService.controller;

import lk.nexttravel.vehicleService.dto.VehicleDto;
import lk.nexttravel.vehicleService.service.VehicleService;
import lk.nexttravel.vehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicle/service")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping(consumes =MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestPart String vehicleId,@RequestPart String vehicleBrand,
                                    @RequestPart String category, @RequestPart String fuelType,
                                    @RequestPart String fuelUsage,@RequestPart byte[] frontImage,
                                    @RequestPart byte[] backImage,@RequestPart byte[] sideImage,
                                    @RequestPart String seats ,@RequestPart String transmissionType ,
                                    @RequestPart String driverName,@RequestPart String contactNo,
                                    @RequestPart byte[] license){
        //convert timage base64
        /*String vehicleImageFront = Base64.getEncoder().encodeToString(frontImage);
        String vehicleImageBack = Base64.getEncoder().encodeToString(backImage);
        String vehicleImageSide = Base64.getEncoder().encodeToString(sideImage);
        String licenseImage = Base64.getEncoder().encodeToString(license);*/

        Integer seatCapacity = Integer.parseInt(seats);

        VehicleDto vehicleDto = new VehicleDto(vehicleId,vehicleBrand, category, fuelType,
                fuelUsage, frontImage, backImage, sideImage, seatCapacity,
                transmissionType, driverName, contactNo, license);

        vehicleService.saveVehicle(vehicleDto);
        return new ResponseUtil(200,"Save Successfully",null);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestPart String vehicleId,@RequestPart String vehicleBrand,
                                      @RequestPart String category, @RequestPart String fuelType,
                                      @RequestPart String fuelUsage,@RequestPart byte[] frontImage,
                                      @RequestPart byte[] backImage,@RequestPart byte[] sideImage,
                                      @RequestPart String seats ,@RequestPart String transmissionType ,
                                      @RequestPart String driverName,@RequestPart String contactNo,
                                      @RequestPart byte[] license){

        Integer seatCapacity = Integer.parseInt(seats);

        VehicleDto vehicleDto = new VehicleDto(vehicleId,vehicleBrand, category, fuelType,
                fuelUsage, frontImage, backImage, sideImage, seatCapacity,
                transmissionType, driverName, contactNo, license);

        vehicleService.updateVehicle(vehicleDto);
        return new ResponseUtil(200,"Update Success",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle(){

//        List<VehicleDto> allVehicle = vehicleService.getAllVehicle();
        return new ResponseUtil(200,"Get All",vehicleService.getAllVehicle());
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String id){
        vehicleService.deleteVehicle(id);
        return new ResponseUtil(200,"Delete Success",null);
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String id){
        VehicleDto vehicleDto = vehicleService.searchVehicle(id);
        return new ResponseUtil(200,"Search Success",vehicleDto);
    }
}
