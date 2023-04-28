package oem.importer.daos;

import oem.importer.domain.Vehicle;

public interface VehicleDao {
    void insertVehicle(Vehicle vehicle);

    Vehicle findVehicle(int id);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(int id);
}
