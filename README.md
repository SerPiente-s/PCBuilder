# Software Design Patterns: Assignment #1 — Builder Pattern

## Product Domain
**PC Configuration System (PC Builder)**  
This project simulates a custom computer configuration system where a client can assemble a custom PC step-by-step or use preset configurations provided by a Director (e.g., Gaming PC, Office PC, Workstation).

---

## Clean Code Principles Applied

### 1. Meaningful and Intention-Revealing Names
* **Justification:** Class and method names clearly express their domain purpose without ambiguous abbreviations.
* **Before:**
  ```java
  public class Bld {
      private int r;
      public Bld setR(int r) { this.r = r; return this; }
  }
* **After:**
  ```java
  public class ComputerBuilder {
    private int ramInGB;
    public ComputerBuilder setRamInGB(int ramInGB) { 
        this.ramInGB = ramInGB; 
        return this; 
    }
  }
### 2. Validated Construction & Explicit Error Handling
* **Justification:** Construction logic enforces invariants in build(), preventing invalid domain objects (e.g., missing CPU or an underpowered power supply for a dedicated GPU).
* **Before:**
  ```java
  public Computer build() {
    return new Computer(cpu, gpu, ramInGB, storageInGB, storageType, powerSupplyWattage, coolingSystem, caseType);
  }
* **After:**  
  ```java
  public Computer build() {
    validateConfiguration();
    return new Computer(cpu, gpu, ramInGB, storageInGB, storageType, powerSupplyWattage, coolingSystem, caseType);
  }

  private void validatePowerSupply() {
    if (gpu != null && !gpu.isEmpty() && powerSupplyWattage < HIGH_PERFORMANCE_POWER_THRESHOLD_WATTAGE) {
    throw new IllegalStateException("Invalid Build: Discrete GPU '" + gpu + "' requires at least " + HIGH_PERFORMANCE_POWER_THRESHOLD_WATTAGE + "W.");
    }
  }
### 3. Avoid Magic Numbers
* **Justification:** Numeric limits are extracted into public static final constants, making business rules readable and configurable.
* **Before:**
  ```java
  if (ramInGB < 4) {
    throw new IllegalArgumentException("RAM too low");
  }
* **After:**
  ```java
  public static final int MIN_RAM_GB = 4;

  private void validateRam() {
    if (ramInGB < MIN_RAM_GB) {
    throw new IllegalArgumentException("Invalid Build: Minimum RAM requirement is " + MIN_RAM_GB + " GB.");
    }
  }
### 4. Small Methods with Single Responsibility (SRP)
* **Justification:** Validation logic is split into small, focused private helper methods (validateCpu(), validateRam(), validatePowerSupply()), improving readability and maintainability.
* **Before:** 
  ```java
  public Computer build() {
    if (cpu == null) throw new IllegalStateException(...);
    if (ramInGB < 4) throw new IllegalArgumentException(...);
    if (powerSupplyWattage < 300) throw new IllegalArgumentException(...);
    return new Computer(...);
  }
* **After:**
  ```java
  private void validateConfiguration() {
    validateCpu();
    validateRam();
    validatePowerSupply();
  }
### 5. Immutability and Strict Encapsulation
* **Justification:** The Computer product class has final fields and no setters after construction. The constructor has package-private access to ensure creation strictly through ComputerBuilder.
* **Before:**
  ```java
  public class Computer {
    public String cpu;
    public void setCpu(String cpu) { this.cpu = cpu; }
  }
* **After:**
  ```java
  public class Computer {
    private final String cpu;

    Computer(String cpu, ...) {
        this.cpu = cpu;
    }

    public String getCpu() { return cpu; }
  }