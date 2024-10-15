package com.stbasarab;

import com.stbasarab.collections.ElectricalApplianceList;

/**
 * Main class to demonstrate the usage of the ElectricalApplianceList collection
 * with ElectricalAppliance instances.
 */
public class Main {

    /**
     * Main method to demonstrate the usage of the ElectricalApplianceList collection
     * with ElectricalAppliance instances.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ElectricalApplianceList applianceList = new ElectricalApplianceList();

        applianceList.add(new ElectricalAppliance("Refrigerator", 150, 0.5));
        applianceList.add(new ElectricalAppliance("Microwave", 800, 1.2));
        applianceList.add(new ElectricalAppliance("Vacuum Cleaner", 1200, 0.3));


        // Displaying the list of appliances
        System.out.println("Appliances:");
        printApplianceList(applianceList);

        // Getting a specific appliance
        ElectricalAppliance appliance = applianceList.get(1);
        System.out.println("\nSecond appliance: " + appliance.toString());

        // Replacing an appliance
        ElectricalAppliance oven = new ElectricalAppliance("Oven", 1500, 1.5);
        applianceList.set(1, oven);
        System.out.println("\nAfter replacement: ");
        printApplianceList(applianceList);

        // Removing an appliance
        applianceList.remove(oven);
        System.out.println("\nAfter removal: ");
        printApplianceList(applianceList);

        // Clearing the list
        applianceList.clear();
        System.out.println("\nAfter clearing, number of appliances: " + applianceList.size());
    }

    private static void printApplianceList(ElectricalApplianceList applianceList) {
        for (ElectricalAppliance appliance : applianceList) {
            System.out.println(appliance.toString());
        }
    }
}
