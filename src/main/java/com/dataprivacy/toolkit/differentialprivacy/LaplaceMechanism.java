package com.dataprivacy.toolkit.differentialprivacy;

import java.util.Random;

public class LaplaceMechanism {
    private double epsilon; // Privacy budget
    private Random random;

    public LaplaceMechanism(double epsilon) {
        this.epsilon = epsilon;
        this.random = new Random();
    }

    // Add Laplace noise to a sensitive value
    public double addNoise(double sensitiveValue) {
        // Sensitivity is assumed to be 1 for a single numerical value
        double scale = 1.0 / epsilon;
        double noise = random.nextGaussian() * scale; // Simplified: should be Laplace distribution
        System.out.println("Adding Laplace noise with epsilon=" + epsilon + ", scale=" + scale + ", noise=" + noise);
        return sensitiveValue + noise;
    }
}
