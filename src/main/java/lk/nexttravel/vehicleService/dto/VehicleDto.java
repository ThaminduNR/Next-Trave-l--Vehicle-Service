package lk.nexttravel.vehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    private String vehicleID;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private int dayValue;
    private byte[] vehicleImageFront;
    private byte[] vehicleImageBack;
    private byte[] vehicleImageSide;
    private Integer seatCapacity;
    private String transmissionType;
    private String driverName;
    private String contactNo;
    private byte[] licenseImage;


}
