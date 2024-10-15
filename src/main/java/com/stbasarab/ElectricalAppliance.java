package com.stbasarab;

/**
 * Represents an electrical appliance.
 * Implements the Comparable interface to allow comparison of appliances based on power.
 */
public class ElectricalAppliance implements Comparable<ElectricalAppliance> {

    private final String name; // Name of the electrical appliance
    private final double power; // Power of the appliance in watts
    private final double electromagneticRadiation; // Electromagnetic radiation in measurement units
    private boolean isTurnedOn; // State indicating if the appliance is turned on

    /**
     * Constructor to initialize the electrical appliance.
     *
     * @param name Name of the electrical appliance.
     * @param power Power of the electrical appliance.
     * @param electromagneticRadiation Electromagnetic radiation of the electrical appliance.
     */
    public ElectricalAppliance(String name, double power, double electromagneticRadiation) {
        this.name = name;
        this.power = power;
        this.electromagneticRadiation = electromagneticRadiation;
        this.isTurnedOn = false; // The appliance is off by default
    }

    /**
     * Turn on the electrical appliance.
     */
    public void turnOn() {
        isTurnedOn = true;
    }

    /**
     * Turn off the electrical appliance.
     */
    public void turnOff() {
        isTurnedOn = false;
    }

    /**
     * Check if the electrical appliance is turned on.
     *
     * @return true if the appliance is turned on; false otherwise.
     */
    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    /**
     * Get the name of the electrical appliance.
     *
     * @return Name of the electrical appliance.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the power of the electrical appliance.
     *
     * @return Power of the appliance in watts.
     */
    public double getPower() {
        return power;
    }

    /**
     * Compare this electrical appliance with another based on power.
     *
     * @param other Another electrical appliance for comparison.
     * @return A negative integer, zero, or a positive integer as this appliance
     *         is less than, equal to, or greater than the specified appliance.
     */
    @Override
    public int compareTo(ElectricalAppliance other) {
        return Double.compare(this.power, other.power);
    }

    /**
     * Get information about the electrical appliance.
     *
     * @return A string containing information about the electrical appliance.
     */
    protected String getInfo() {
        return "name='" + name + '\'' +
                ", power=" + power +
                ", electromagneticRadiation=" + electromagneticRadiation +
                ", isTurnedOn=" + isTurnedOn;
    }

    /**
     * Get the value of electromagnetic radiation.
     *
     * @return Electromagnetic radiation in measurement units.
     */
    public double getElectromagneticRadiation() {
        return electromagneticRadiation;
    }
}
