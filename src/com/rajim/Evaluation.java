//package com.rajim;
//
//public class Evaluation {
//
//    public void evaluate() {
//        double[] x = new double[Constants.NUMBER_OF_VARIABLES + 1];
//        for (int member = 0; member < Constants.POPULATION_SIZE; member++) {
//            for (int i = 0; i < Constants.NUMBER_OF_VARIABLES; i++) {
//                x[i + 1] = Constants.population[member].getGens()[i];
//            }
//            double v = (x[1]) * (x[1]) - (x[1]) * (x[2]) + (x[3]);
//            Constants.population[member].setFitness(v);
//        }
//    }
//
//    public void keepTheBest() {
//        int current_best = 0;
//        for (int mem = 0; mem < Constants.POPULATION_SIZE; mem++) {
////            System.out.println(Constants.population[Constants.POPULATION_SIZE-1].getFitness()+"  "+Constants.population[mem].getFitness());
//            if (Constants.population[Constants.POPULATION_SIZE-1].getFitness() < Constants.population[mem].getFitness()) {
//                current_best = mem;
//                Constants.population[Constants.POPULATION_SIZE-1].setFitness(Constants.population[mem].getFitness());
//            }
//        }
//        // AS best member in the population is found, copy genes
//        for (int i = 0; i < Constants.NUMBER_OF_VARIABLES; i++) {
//            Constants.population[Constants.POPULATION_SIZE-1].getGens()[i] = (Constants.population[current_best].getGens()[i]) ;
//        }
//    }
//}
