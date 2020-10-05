package com.rajim;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static final int POPULATION_SIZE = 50;
    public static final int MAX_GENERATION = 10;
    public static final int NUMBER_OF_VARIABLES = 3;
    public static final double PERCENTAGE_X_OVER = 0.8;
    public static final double PERCENTAGE_MUTATION = 0.15;

    public static List<GenoType> population = new ArrayList<>(POPULATION_SIZE+1);
    public static List<GenoType> newPopulation = new ArrayList<>();


    public static void main(String[] args) {
        execute();
//        System.out.println(getRandom(0, 5));
    }



    public static double getRandom(double lower, double high) {
        java.util.Random random = new java.util.Random();
        double result = random.nextDouble() * (high - lower) + lower;
        return result;
    }


    public static void initialize() {
        double[][] ranges = {{0, 5}, {0, 5}, {-2, 2}}; // ranges
        double lower;
        double upper;
        double[] upperArray = new double[NUMBER_OF_VARIABLES];
        double[] lowerArray = new double[NUMBER_OF_VARIABLES];

        for (int j = 0; j < POPULATION_SIZE; j++) {
            double[] gens = new double[NUMBER_OF_VARIABLES];
            for (int i = 0; i < NUMBER_OF_VARIABLES; i++) {
                lower = ranges[i][0];
                upper = ranges[i][1];
                upperArray[i] = upper;
                lowerArray[i] = lower;
                gens[i] = getRandom(lower, upper);
            }
            GenoType genoType = new GenoType(gens, 0, upperArray, lowerArray,
                    0, 0);
            population.add(genoType);
//            newPopulation.add(genoType);
        }
    }

    public static void evaluate() {
        for (int member = 0; member < POPULATION_SIZE; member++) {
           double x1 = population.get(member).getGens()[0];
           double x2 = population.get(member).getGens()[1];
           double x3 = population.get(member).getGens()[2];
           double value = x1*x1 - x1*x2 + x3;
           population.get(member).setFitness(value);
        }
    }

    public static void keepTheBest() {
        int current_best;
        GenoType best = population.stream().max(Comparator.comparingDouble(GenoType::getFitness))
                .get();
        current_best = population.indexOf(best);
        population.set(POPULATION_SIZE - 1, population.get(current_best));
    }

    
    public static void crossOver() {
        double a = 0.0;
        double b = 1.0;
        int one = 0;
        int first = 0;
        double x;
        for (int mem = 0; mem < POPULATION_SIZE; mem++) {
            x = getRandom(a, b);
            if (x < PERCENTAGE_X_OVER) {
                first = first + 1;
                if (first % 2 == 0) {
                    Xover(one, mem);
                } else {
                    one = mem;
                }
            }
        }
    }

    public static void Xover(int one, int two) {
        int point;
        double t;
        // selecting crossover point
        // here point should be always positive
        point = (int) Math.round(getRandom(0, NUMBER_OF_VARIABLES - 1));
        // swap gens in position through point -1
        for (int i = 0; i < point; i++) {
            printChromosome(population.get(one), population.get(two));
            t = population.get(one).getGens()[i];
            population.get(one).getGens()[i] = population.get(two).getGens()[i];
            population.get(two).getGens()[i] = t;
            printChromosome(population.get(one), population.get(two));
        }
    }

    private static void printChromosome(GenoType genoType, GenoType genoType1) {
//        System.out.println("Original::"+Arrays.toString(genoType.getGens())+" and "+Arrays.toString(genoType1.getGens()));
    }


    public static void mutate() {
        double a = 0.0;
        double b = 1.0;
        double lowerBound;
        double upperBound;
        double x;
        for (int i = 0; i < POPULATION_SIZE; i++) {
            x = getRandom(a, b);
            if (x < PERCENTAGE_MUTATION) {
            for (int j = 0; j < NUMBER_OF_VARIABLES; j++) {
                    lowerBound = population.get(i).getLower()[j];
                    upperBound = population.get(i).getUpper()[j];
                    double randomNumber = getRandom(lowerBound, upperBound);
//                    System.out.println("Previous::"+population.get(i).getGens()[j]);
                    population.get(i).getGens()[j] = randomNumber;
//                    System.out.println("New::"+population.get(i).getGens()[j]);
                }
            }
        }
    }


    public static void report(int generation) {
        double avg;
        double best_val;
        double squareSum;
        double stdDev;
        double sum = population.stream().mapToDouble(e-> e.getFitness()).sum();
        double sumSquare = population.stream().mapToDouble(e-> e.getFitness()*e.getFitness()).sum();

        if (generation == 0) {
            System.out.println("");
            System.out.println(" Generation       Best            Average       Standard ");
            System.out.println(" number           value           fitness       deviation ");
        }
        avg = population.stream().mapToDouble(e->e.getFitness()).average().getAsDouble();

        squareSum = avg * avg * POPULATION_SIZE;
        stdDev = Math.sqrt((sumSquare - squareSum) / (POPULATION_SIZE - 1));
        best_val = population.get(POPULATION_SIZE - 1).getFitness();
        System.out.println("  " + generation + "        " + best_val + "             " + avg + "            " + stdDev);
    }

    public static void elitist() {
        int best_mem;
        int worst_mem;
        GenoType best = population.stream().max(Comparator.comparingDouble(GenoType::getFitness))
                .get();
        GenoType worst = population.stream().min(Comparator.comparingDouble(GenoType::getFitness))
                .get();
        best_mem = population.indexOf(best);
        worst_mem = population.indexOf(worst);
        if (population.get(best_mem).getFitness() >= population.get(POPULATION_SIZE-1).getFitness()) {
            population.set(POPULATION_SIZE-1, population.get(best_mem));
        } else {
            population.set(worst_mem, population.get(POPULATION_SIZE-1));
        }
    }

    public static void selector() {
        double a = 0.0;
        double b = 1.0;
        double p;
        double sum = population.stream().mapToDouble(e-> e.getFitness()).sum();
        population = population.stream().map(e-> setRelativeFitNess(e, sum)).collect(Collectors.toList());
        population.get(0).setCumulativeFitness(population.get(0).getRelativeFitness());
        for(int i = 1; i< POPULATION_SIZE; i++) {
            population.get(i).setCumulativeFitness(population.get(i-1).getCumulativeFitness()
                    + population.get(i).getRelativeFitness());
        }

        newPopulation = population;

        for( int i=0; i< POPULATION_SIZE; i++) {
            p = getRandom(a, b);
            if( p< population.get(0).getCumulativeFitness()) {
                if(population.size() != POPULATION_SIZE) {
                    newPopulation.add(population.get(0));
                } else {
                    newPopulation.set(i, population.get(i));
                }
            } else {
                for( int j =0; j < POPULATION_SIZE; j++) {
                    if ( population.get(j).getCumulativeFitness() <= p
                            && p < population.get(j+1).getCumulativeFitness() ) {
                        if(newPopulation.size() !=POPULATION_SIZE) {
                            newPopulation.add(population.get(j+1));
                        } else {
                            newPopulation.set(i, population.get(j+1));
                        }
                    }
                }
            }
        }
        population = newPopulation;
    }


    private static GenoType setRelativeFitNess(GenoType genoType, double sum) {
        genoType.setRelativeFitness(genoType.getFitness()/sum);
        return genoType;
    }


    public static void execute() {
        int generation;
        Long startTime = System.currentTimeMillis();
        timeStamp();
        System.out.println("Sample GA Implementation...");
        initialize();
        evaluate();
        // keeping best
        keepTheBest();

        for (generation = 0; generation < MAX_GENERATION; generation++) {
            selector();
            crossOver();
            mutate();
            report(generation);
            evaluate();
            elitist();
        }

        System.out.println();
        System.out.println(" Best Member After " + MAX_GENERATION + " generations");

        for (int i = 0; i < NUMBER_OF_VARIABLES; i++) {
            System.out.println(" var ( " + i + " ) = " + population.get(POPULATION_SIZE - 1).getGens()[i]);
        }

        System.out.println();
        System.out.println(" Best fitness = " + population.get(POPULATION_SIZE - 1).getFitness());
        timeStamp();
        System.out.println("Total Time::" + (System.currentTimeMillis() - startTime));
        System.out.println("Here our algorithms execution normally ended.");
    }

    private static void timeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        System.out.println("Time :: " + simpleDateFormat.format(new Date()));
    }
}
