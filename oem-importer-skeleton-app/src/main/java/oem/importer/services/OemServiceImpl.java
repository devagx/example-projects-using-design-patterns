package oem.importer.services;

import oem.importer.daos.VehicleDao;
import oem.importer.domain.File;
import oem.importer.domain.Vehicle;
import oem.importer.parsers.Parser;
import org.springframework.stereotype.Service;

@Service
public class OemServiceImpl implements OemService {
    private final VehicleDao vehicleDao;

    public OemServiceImpl(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Override
    public String parse(File file) {
        String fileType = file.getFileType();
        Parser parser = ParsingFactory.getParser(fileType);

        if (parser == null) {
            return "INVALID PARSER";
        }
        String data = parser.parse();

        System.out.println("DATA STRING = " + data);

        String[] dataElements = data.split("\\|");

        Vehicle vehicle = new Vehicle.VehicleBuilder()
                .setSource(dataElements[0])
                .setManufacturer(dataElements[1])
                .setMake(dataElements[2])
                .build();

        insertVehicle(vehicle);
        findVehicle(100);
        updateVehicle(vehicle);
        deleteVehicle(101);

        return "IMPORT SUCCESS";
    }

    @Override
    public void insertVehicle(Vehicle vehicle) {
        vehicleDao.insertVehicle(vehicle);
    }

    @Override
    public Vehicle findVehicle(int id) {
        return vehicleDao.findVehicle(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleDao.updateVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        vehicleDao.deleteVehicle(id);
    }
}
