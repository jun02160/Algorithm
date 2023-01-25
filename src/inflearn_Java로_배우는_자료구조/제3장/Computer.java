package inflearn_Java로_배우는_자료구조.제3장;

public class Computer {
    
    public String manufacturer;
    public String processor;
    public int ramSize;
    public int diskSize;
    public double processorSpeed;

    public Computer(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.processorSpeed = processorSpeed;
    }
    
    public double computerPower() {
        return ramSize * processorSpeed;
    }
    
    public double getRamSize() {
        return ramSize;
    }
    
    public double getProcessorSpeed() {
        return processorSpeed;
    }
    
    public int getDiskSize() {
        return diskSize;
    }

    public String toString() {
        return "manufacturer: " + manufacturer
                + "\nprocessor: " + processor
                + "\nramSize: " + ramSize
                + "\nprocessorSpeed: " + processorSpeed
                + "\ndiskSize: " + diskSize;
    }
}
