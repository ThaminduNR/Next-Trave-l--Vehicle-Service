package lk.nexttravel.vehicleService.service;

import lk.nexttravel.vehicleService.dto.VehicleDto;
import lk.nexttravel.vehicleService.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    void saveVehicle(VehicleDto dto);
    void updateVehicle(VehicleDto dto);
    void deleteVehicle(String id);
    List<VehicleDto> getAllVehicle();
    VehicleDto searchVehicle(String id);

//    VehicleDto findAllByCategory(String category);

    List<VehicleDto> findByCategory(String category);



}
