//package com.rajim;
//
//public class Elitisim {
//
//    public void elitist() {
//        double best;
//        int best_mem = 0;
//        double worst;
//        int worst_mem = 0;
//        best = Constants.population[0].getFitness();
//        worst = Constants.population[0].getFitness();
//
//        for(int i = 0; i< Constants.POPULATION_SIZE-1 ; i++) {
//            System.out.println(Constants.population[i+1].getFitness()+" "+Constants.population[i].getFitness());
//            if(Constants.population[i+1].getFitness() < Constants.population[i].getFitness()) {
//                if(best <= Constants.population[i].getFitness()) {
//                    best = Constants.population[i].getFitness();
//                    best_mem = i;
//                }
//                if(Constants.population[i+1].getFitness() <= worst) {
//                    worst = Constants.population[i+1].getFitness();
//                    worst_mem = i+1;
//                }
//            } else {
//                if ( Constants.population[i].getFitness() <= worst ) {
//                    worst = Constants.population[i].getFitness();
//                    worst_mem = i;
//                }
//                if ( best <= Constants.population[i+1].getFitness() ) {
//                    best = Constants.population[i+1].getFitness();
//                    best_mem = i + 1;
//                }
//            }
//        }
//
//
//        if(Constants.population[Constants.POPULATION_SIZE-1].getFitness() <=best) {
////            for(int i = 0; i< Constants.NUMBER_OF_VARIABLES; i++) {
//                Constants.population[Constants.POPULATION_SIZE-1] = Constants.population[best_mem];
////            }
////            double fitness = Constants.population[best_mem].getFitness();
////            Constants.population[Constants.POPULATION_SIZE-1].setFitness(fitness);
//        } else {
////            for(int i = 0; i<Constants.NUMBER_OF_VARIABLES; i++) {
//                Constants.population[worst_mem] = Constants.population[Constants.POPULATION_SIZE-1];
////            }
////            Constants.population[worst_mem].setFitness(Constants.population[Constants.POPULATION_SIZE-1].getFitness());
//        }
//    }
//
//}
