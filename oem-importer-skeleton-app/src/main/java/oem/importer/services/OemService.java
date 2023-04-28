package oem.importer.services;

import oem.importer.domain.File;
import oem.importer.domain.Vehicle;

public interface OemService {
    void insertVehicle(Vehicle vehicle);

    Vehicle findVehicle(int id);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(int id);

    String parse(File file);
}
