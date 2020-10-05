//package com.rajim;
//
//public class Mutation {
//    public void mutate() {
//        double a = 0.0;
//        double b = 1.0;
//        double lowerBound;
//        double upperBound;
//        double x;
//        Random random = new Random();
//        for( int i = 0; i<Constants.POPULATION_SIZE; i++) {
//            for( int j = 0; j<Constants.NUMBER_OF_VARIABLES; j++) {
//                x = random.getRandomNumber(a, b);
//                if(x < Constants.PERCENTAGE_MUTATION) {
//                    lowerBound = Constants.population[i].getLower()[j];
//                    upperBound = Constants.population[i].getUpper()[j];
//                    double randomNumber = random.getRandomNumber(lowerBound, upperBound);
//                    Constants.population[i].getGens()[j] = randomNumber;
//                }
//            }
//        }
//    }
//}
