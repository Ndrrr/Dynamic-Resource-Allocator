package bhos.ndrrr.model;

public class Resource {

    public Integer memory;
    public Integer computationSpeed;

    public Resource(Integer memory, Integer computationSpeed) {
        this.memory = memory;
        this.computationSpeed = computationSpeed;
    }

    public Resource minus(Resource resource) {
        return new Resource(this.memory - resource.memory,
                this.computationSpeed - resource.computationSpeed);
    }

}
