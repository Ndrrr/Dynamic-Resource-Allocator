package bhos.ndrrr.util;

import bhos.ndrrr.model.Experiment;
import bhos.ndrrr.model.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceAllocator {

    public List<Experiment> experiments;
    public Resource availableResource;

    public ResourceAllocator(List<Experiment> experiments, Resource availableResource) {
        this.experiments = experiments;
        this.availableResource = availableResource;
    }

    public Map<Experiment, Resource> allocateResources() {
        Map<Experiment, Resource> allocatedResources = new HashMap<>();

        for (Experiment experiment : experiments) {
            System.out.println("Resources before allocation: " + availableResource.memory
                    + " " + availableResource.computationSpeed);
            var allocatedResource = allocateExperimentResource(experiment);
            availableResource = availableResource.minus(allocatedResource);
            allocatedResources.put(experiment, allocatedResource);
            System.out.println("Resources allocated to " + experiment.name + ": " +
                    allocatedResource.memory + " " + allocatedResource.computationSpeed);
        }

        return allocatedResources;
    }

    private Resource allocateExperimentResource(Experiment experiment) {
        return new Resource(
                Math.min(experiment.memoryPreference, availableResource.memory),
                Math.min(experiment.computationSpeedPreference, availableResource.computationSpeed)
        );
    }
}
