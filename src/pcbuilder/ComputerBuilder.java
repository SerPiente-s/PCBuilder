package pcbuilder;

public class ComputerBuilder {
    public static final int MIN_RAM_GB = 4;
    public static final int MIN_POWER_SUPPLY_WATTAGE = 300;
    public static final int HIGH_PERFORMANCE_POWER_THRESHOLD_WATTAGE = 650;

    private String cpu;
    private String gpu;
    private int ramInGB = 8;
    private int storageInGB = 256;
    private String storageType = "SSD";
    private int powerSupplyWattage = 450;
    private String coolingSystem = "Stock Air Cooler";
    private String caseType = "Mid Tower";

    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this; // Fluent API
    }

    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder setRamInGB(int ramInGB) {
        this.ramInGB = ramInGB;
        return this;
    }

    public ComputerBuilder setStorage(int storageInGB, String storageType) {
        this.storageInGB = storageInGB;
        this.storageType = storageType;
        return this;
    }

    public ComputerBuilder setPowerSupplyWattage(int powerSupplyWattage) {
        this.powerSupplyWattage = powerSupplyWattage;
        return this;
    }

    public ComputerBuilder setCoolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    public ComputerBuilder setCaseType(String caseType) {
        this.caseType = caseType;
        return this;
    }

    public Computer build() {
        validateConfiguration();
        return new Computer(
                cpu,
                gpu,
                ramInGB,
                storageInGB,
                storageType,
                powerSupplyWattage,
                coolingSystem,
                caseType
        );
    }

    private void validateConfiguration() {
        validateCpu();
        validateRam();
        validatePowerSupply();
    }

    private void validateCpu() {
        if (cpu == null || cpu.trim().isEmpty()) {
            throw new IllegalStateException("Invalid Build: A computer requires a CPU to function.");
        }
    }

    private void validateRam() {
        if (ramInGB < MIN_RAM_GB) {
            throw new IllegalArgumentException("Invalid Build: Minimum RAM requirement is " + MIN_RAM_GB + " GB.");
        }
    }

    private void validatePowerSupply() {
        if (powerSupplyWattage < MIN_POWER_SUPPLY_WATTAGE) {
            throw new IllegalArgumentException("Invalid Build: Power supply wattage must be at least " + MIN_POWER_SUPPLY_WATTAGE + "W.");
        }
        if (gpu != null && !gpu.isEmpty() && powerSupplyWattage < HIGH_PERFORMANCE_POWER_THRESHOLD_WATTAGE) {
            throw new IllegalStateException("Invalid Build: Discrete GPU '" + gpu + "' requires a power supply of at least "
                    + HIGH_PERFORMANCE_POWER_THRESHOLD_WATTAGE + "W.");
        }
    }
}