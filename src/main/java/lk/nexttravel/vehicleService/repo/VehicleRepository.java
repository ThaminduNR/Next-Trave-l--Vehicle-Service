package lk.nexttravel.vehicleService.repo;

import lk.nexttravel.vehicleService.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {


    List<Vehicle> findByCategory(String category);


}
