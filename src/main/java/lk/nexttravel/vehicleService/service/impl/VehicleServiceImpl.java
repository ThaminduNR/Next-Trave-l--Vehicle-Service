package lk.nexttravel.vehicleService.service.impl;

import lk.nexttravel.vehicleService.dto.VehicleDto;
import lk.nexttravel.vehicleService.entity.Vehicle;
import lk.nexttravel.vehicleService.exception.InvalidException;
import lk.nexttravel.vehicleService.exception.NotFoundException;
import lk.nexttravel.vehicleService.repo.VehicleRepository;
import lk.nexttravel.vehicleService.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public void saveVehicle(VehicleDto dto) {
        if (vehicleRepository.existsById(dto.getVehicleID())) throw new InvalidException("Already Exist Vehicle");
        Vehicle vehicle = mapper.map(dto, Vehicle.class);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void updateVehicle(VehicleDto dto) {
        if (vehicleRepository.existsById(dto.getVehicleID())){
            vehicleRepository.save(mapper.map(dto,Vehicle.class));
        }else {
            throw new NotFoundException("Please check the Vehicle ID..");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }else {
            throw  new NotFoundException("Id Does not Exist");
        }
    }

    @Override
    public List<VehicleDto> getAllVehicle() {
        return mapper.map(vehicleRepository.findAll(), new TypeToken<List<VehicleDto>>() {
        }.getType());
    }


    @Override
    public VehicleDto searchVehicle(String id) {
       if (!vehicleRepository.existsById(id)) throw new NotFoundException("Vehicle Does not exist");
        Vehicle vehicle = vehicleRepository.findById(id).get();
        return mapper.map(vehicle,VehicleDto.class);

    }

    @Override
    public List<VehicleDto> findByCategory(String category) {
        return mapper.map(vehicleRepository.findByCategory(category), new TypeToken<List<VehicleDto>>() {
        }.getType());

    }


}
