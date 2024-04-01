# Resource Allocator for Experiments

## Overview
This project implements a dynamic resource allocator for experiments. It allows you to define experiments with computational speed and memory preferences and then allocates resources based on those preferences and available resources.

## Project Structure
The project is organized into the following packages:
- `bhos.ndrrr`: Contains the main classes and entry point of the application.
- `bhos.ndrrr.model`: Contains the `Experiment` and `Resource` classes representing experiments and resources, respectively.
- `bhos.ndrrr.util`: Contains utility classes used in the project.

## Classes
- `Experiment`: Represents an experiment with a name, computation speed preference, memory preference, and allocated resources.
- `Resource`: Represents the available resources with memory and computation speed.
- `ResourceAllocator`: Allocates resources to experiments based on their preferences.

## Usage
1. Create instances of experiments with their computation speed and memory preferences.
2. Define the available resources using the `Resource` class.
3. Create a `ResourceAllocator` instance with a list of experiments and the available resources.
4. Call the `allocateResources` method to allocate resources to experiments.
5. Access the allocated resources for each experiment through the returned map.
