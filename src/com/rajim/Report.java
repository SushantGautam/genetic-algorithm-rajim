//package com.rajim;
//
//public class Report {
//
//    public void report(int generation) {
//        double avg;
//        double best_val;
//        double squareSum;
//        double stdDev;
//        double sum = 0.0;
//        double sumSquare = 0.0;
//
//        if(generation == 0) {
//            System.out.println("");
//            System.out.println(" Generation       Best            Average       Standard ");
//            System.out.println(" number           value           fitness       deviation ");
//        }
//
//        for( int i = 0; i< Constants.POPULATION_SIZE; i++) {
//            sum = sum + Constants.population[i].getFitness();
//            sumSquare = sumSquare + Constants.population[i].getFitness()*Constants.population[i].getFitness();
//        }
//
//        avg = (double) sum / (double) Constants.POPULATION_SIZE;
//        squareSum = avg * avg * Constants.POPULATION_SIZE;
//        stdDev = Math.sqrt ( ( sumSquare - squareSum ) / ( Constants.POPULATION_SIZE - 1 ) );
//        best_val = Constants.population[Constants.POPULATION_SIZE-1].getFitness();
//        System.out.println("  "+generation+"        "+best_val+"             "+avg+"            "+stdDev);
//    }
//
//}
