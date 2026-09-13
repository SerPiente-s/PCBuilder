package pcbuilder;


public class Main {
    public static void main(String[] args) {
        PCDirector director = new PCDirector();

        System.out.println("=== 1. CREATING PRESET CONFIGURATIONS VIA DIRECTOR ===\n");

        //Gaming
        ComputerBuilder gamingBuilder = new ComputerBuilder();
        director.constructGamingPC(gamingBuilder);
        Computer gamingPC = gamingBuilder.build();
        System.out.println("[Director] High-End Gaming PC:");
        System.out.println(gamingPC);

        //Office
        ComputerBuilder officeBuilder = new ComputerBuilder();
        director.constructOfficePC(officeBuilder);
        Computer officePC = officeBuilder.build();
        System.out.println("[Director] Office PC:");
        System.out.println(officePC);

        System.out.println("=== 2. CREATING CUSTOM CONFIGURATION VIA FLUENT BUILDER ===\n");

        // Custom
        Computer customPC = new ComputerBuilder()
                .setCpu("AMD Ryzen 7 7800X3D")
                .setGpu("NVIDIA GeForce RTX 4070 Ti")
                .setRamInGB(32)
                .setStorage(1000, "NVMe SSD")
                .setPowerSupplyWattage(750)
                .setCoolingSystem("Dual Tower Air Cooler")
                .setCaseType("Mid Tower Mesh")
                .build();

        System.out.println("[Custom Build] Custom PC:");
        System.out.println(customPC);

        System.out.println("=== 3. TESTING VALIDATION RULES & ERROR HANDLING ===\n");

        try {
            System.out.println("Attempting build without CPU...");
            new ComputerBuilder()
                    .setRamInGB(16)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Error: " + e.getMessage() + "\n");
        }

        try {
            System.out.println("Attempting build with RTX 4090 on a 400W PSU...");
            new ComputerBuilder()
                    .setCpu("Intel Core i7-13700K")
                    .setGpu("NVIDIA GeForce RTX 4090")
                    .setPowerSupplyWattage(400)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Error: " + e.getMessage() + "\n");
        }
    }
}