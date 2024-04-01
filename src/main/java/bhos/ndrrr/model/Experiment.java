package bhos.ndrrr.model;

public class Experiment {

    public String name;
    public Integer computationSpeedPreference;
    public Integer memoryPreference;
    public Resource resource;

    public Experiment(String name, Integer computationSpeedPreference, Integer memoryPreference) {
        this.name = name;
        this.computationSpeedPreference = computationSpeedPreference;
        this.memoryPreference = memoryPreference;
    }

    public Integer utility(Resource resource) {
        if (this.resource == null) {
            this.resource = new Resource(
                    Math.min(this.memoryPreference, resource.memory),
                    Math.min(this.computationSpeedPreference, resource.computationSpeed)
            );
        }

        return this.resource.computationSpeed + this.resource.memory;
    }

    public boolean isPreferred(Experiment experiment) {
        if (experiment.resource == null) {
            return true;
        }

        if (this.resource == null) {
            return false;
        }

        return this.utility(null) >= experiment.utility(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Experiment that = (Experiment) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
