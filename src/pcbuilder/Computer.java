package pcbuilder;


public class Computer {
    private final String cpu;
    private final String gpu;
    private final int ramInGB;
    private final int storageInGB;
    private final String storageType;
    private final int powerSupplyWattage;
    private final String coolingSystem;
    private final String caseType;

    // Builder
    Computer(String cpu, String gpu, int ramInGB, int storageInGB,
             String storageType, int powerSupplyWattage,
             String coolingSystem, String caseType) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.ramInGB = ramInGB;
        this.storageInGB = storageInGB;
        this.storageType = storageType;
        this.powerSupplyWattage = powerSupplyWattage;
        this.coolingSystem = coolingSystem;
        this.caseType = caseType;
    }

    public String getCpu() { return cpu; }
    public String getGpu() { return gpu; }
    public int getRamInGB() { return ramInGB; }
    public int getStorageInGB() { return storageInGB; }
    public String getStorageType() { return storageType; }
    public int getPowerSupplyWattage() { return powerSupplyWattage; }
    public String getCoolingSystem() { return coolingSystem; }
    public String getCaseType() { return caseType; }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "  - CPU: " + cpu + "\n" +
                "  - GPU: " + (gpu != null ? gpu : "Integrated Graphics") + "\n" +
                "  - RAM: " + ramInGB + " GB\n" +
                "  - Storage: " + storageInGB + " GB " + storageType + "\n" +
                "  - Power Supply: " + powerSupplyWattage + "W\n" +
                "  - Cooling: " + coolingSystem + "\n" +
                "  - Case: " + caseType + "\n";
    }
}