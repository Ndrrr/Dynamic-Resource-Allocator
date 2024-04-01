package bhos.ndrrr;

import bhos.ndrrr.model.Experiment;
import bhos.ndrrr.model.Resource;
import bhos.ndrrr.util.ResourceAllocator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Experiment experiment1 = new Experiment("Experiment 1", 10, 20);
        Experiment experiment2 = new Experiment("Experiment 2", 20, 10);
        Experiment experiment3 = new Experiment("Experiment 3", 15, 15);

        Resource availableResource = new Resource(35, 35);

        ResourceAllocator resourceAllocator = new ResourceAllocator(
                List.of(experiment1, experiment2, experiment3), availableResource);
        var allocatedResources = resourceAllocator.allocateResources();

        Integer totalUtility = 0;
        for (var entry : allocatedResources.entrySet()) {
            System.out.println("Experiment: " + entry.getKey().name + " allocated resources: " + entry.getValue().memory + " " + entry.getValue().computationSpeed);
            totalUtility += entry.getKey().utility(entry.getValue());
        }

        System.out.println("Total utility: " + totalUtility);
    }
}