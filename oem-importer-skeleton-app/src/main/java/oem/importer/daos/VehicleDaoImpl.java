package oem.importer.daos;

import oem.importer.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleDaoImpl implements VehicleDao {
    @Override
    public void insertVehicle(Vehicle vehicle) {
        System.out.println("Inserting vehicle - START");
        System.out.println("Inserting vehicle source to postgres - " + vehicle.getSource());
        System.out.println("Inserting vehicle id to postgres - " + vehicle.getId());
        System.out.println("Inserting vehicle manufacturer to postgres - " + vehicle.getManufacturer());
        System.out.println("Inserting vehicle make to postgres - " + vehicle.getMake());
        System.out.println("Inserting vehicle - END");
    }

    @Override
    public Vehicle findVehicle(int id) {
        System.out.println("Finding vehicle - START");
        System.out.println("Finding vehicle from postgres - id = " + id);
        System.out.println("Finding vehicle - END");
        return new Vehicle.VehicleBuilder()
                .setId(id)
                .build();
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        System.out.println("Updating vehicle - START");
        System.out.println("Updating vehicle source to postgres - " + vehicle.getSource());
        System.out.println("Updating vehicle id to postgres - " + vehicle.getId());
        System.out.println("Updating vehicle manufacturer to postgres - " + vehicle.getManufacturer());
        System.out.println("Updating vehicle make to postgres - " + vehicle.getMake());
        System.out.println("Updating vehicle - END");
    }

    @Override
    public void deleteVehicle(int id) {
        System.out.println("Deleting vehicle - START");
        System.out.println("Deleting vehicle from postgres - id = " + id);
        System.out.println("Deleting vehicle - END");
    }
}
