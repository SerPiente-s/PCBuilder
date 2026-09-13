package pcbuilder;

public class PCDirector {

    public void constructGamingPC(ComputerBuilder builder) {
        builder.setCpu("Intel Core i9-14900K")
                .setGpu("NVIDIA GeForce RTX 4090")
                .setRamInGB(64)
                .setStorage(2000, "NVMe M.2 SSD")
                .setPowerSupplyWattage(1000)
                .setCoolingSystem("360mm Liquid Cooler")
                .setCaseType("Full Tower RGB Case");
    }

    public void constructOfficePC(ComputerBuilder builder) {
        builder.setCpu("Intel Core i3-13100")
                .setGpu(null)
                .setRamInGB(16)
                .setStorage(512, "SATA SSD")
                .setPowerSupplyWattage(400)
                .setCoolingSystem("Stock Air Cooler")
                .setCaseType("Compact Mini Tower");
    }

    public void constructWorkstationPC(ComputerBuilder builder) {
        builder.setCpu("AMD Ryzen Threadripper 7980X")
                .setGpu("NVIDIA RTX A6000")
                .setRamInGB(128)
                .setStorage(4000, "NVMe M.2 SSD")
                .setPowerSupplyWattage(1200)
                .setCoolingSystem("Custom Loop Liquid Cooler")
                .setCaseType("Server Workstation Chassis");
    }
}