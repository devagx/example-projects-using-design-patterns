package oem.importer.domain;

public class Vehicle {
    private final int id;
    private final String source;
    private final String make;
    private final String manufacturer;
    private final String engineSize;
    private final String trim;
    private final int wheelSize;
    private final int numOfDoors;
    private final String paintColour;
    private final int lpg;
    private final String alloyType;
    private final int co2Emission;

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getMake() {
        return make;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public String getTrim() {
        return trim;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public String getPaintColour() {
        return paintColour;
    }

    public int getLpg() {
        return lpg;
    }

    public String getAlloyType() {
        return alloyType;
    }

    public int getCo2Emission() {
        return co2Emission;
    }

    public Vehicle(VehicleBuilder builder) {
        this.id = builder.id;
        this.source = builder.source;
        this.make = builder.make;
        this.manufacturer = builder.manufacturer;
        this.engineSize = builder.engineSize;
        this.trim = builder.trim;
        this.wheelSize = builder.wheelSize;
        this.numOfDoors = builder.numOfDoors;
        this.paintColour = builder.paintColour;
        this.lpg = builder.lpg;
        this.alloyType = builder.alloyType;
        this.co2Emission = builder.co2Emission;
    }

    public static class VehicleBuilder {
        private int id;
        private String source;
        private String make;
        private String manufacturer;
        private String engineSize;
        private String trim;
        private int wheelSize;
        private int numOfDoors;
        private String paintColour;
        private int lpg;
        private String alloyType;
        private int co2Emission;

        public VehicleBuilder() {
        }

        public VehicleBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public VehicleBuilder setSource(String source) {
            this.source = source;
            return this;
        }

        public VehicleBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public VehicleBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public VehicleBuilder setEngineSize(String engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        public VehicleBuilder setTrim(String trim) {
            this.trim = trim;
            return this;
        }

        public VehicleBuilder setWheelSize(int wheelSize) {
            this.wheelSize = wheelSize;
            return this;
        }

        public VehicleBuilder setNumOfDoors(int numOfDoors) {
            this.numOfDoors = numOfDoors;
            return this;
        }

        public VehicleBuilder setPaintColour(String paintColour) {
            this.paintColour = paintColour;
            return this;
        }

        public VehicleBuilder setLpg(int lpg) {
            this.lpg = lpg;
            return this;
        }

        public VehicleBuilder setAlloyType(String alloyType) {
            this.alloyType = alloyType;
            return this;
        }

        public VehicleBuilder setCo2Emission(int co2Emission) {
            this.co2Emission = co2Emission;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
