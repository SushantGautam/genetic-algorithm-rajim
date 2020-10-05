package com.rajim;


public class GenoType {

    private double[] gens;
    private double fitness;
    private double[] upper;
    private double[] lower;
    private double relativeFitness;
    private double cumulativeFitness;

    public GenoType(){}

    public GenoType(double[] gens,
                    double fitness,
                    double[] upper,
                    double[] lower,
                    double relativeFitness,
                    double cumulativeFitness) {
        this.gens = gens;
        this.fitness = fitness;
        this.upper = upper;
        this.lower = lower;
        this.relativeFitness = relativeFitness;
        this.cumulativeFitness = cumulativeFitness;
    }


    public double[] getGens() {
        return gens;
    }

    public void setGens(double[] gens) {
        this.gens = gens;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double[] getUpper() {
        return upper;
    }

    public void setUpper(double[] upper) {
        this.upper = upper;
    }

    public double[] getLower() {
        return lower;
    }

    public void setLower(double[] lower) {
        this.lower = lower;
    }

    public double getRelativeFitness() {
        return relativeFitness;
    }

    public void setRelativeFitness(double relativeFitness) {
        this.relativeFitness = relativeFitness;
    }

    public double getCumulativeFitness() {
        return cumulativeFitness;
    }

    public void setCumulativeFitness(double cumulativeFitness) {
        this.cumulativeFitness = cumulativeFitness;
    }

}
