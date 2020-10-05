//package com.rajim;
//
//public class Crossover {
//
//    public void crossOver() {
//        Random random = new Random();
//        double a = 0.0;
//        double b = 1.0;
//        int one = 0;
//        int first = 0;
//        double x;
//        for(int mem = 0; mem< Constants.POPULATION_SIZE; mem++) {
//            x = random.getRandomNumber(a, b);
//            if(x < Constants.PERCENTAGE_X_OVER) {
//                first = first+1;
//                if(first %2 == 0) {
//                    Xover(one, mem);
//                } else {
//                    one = mem;
//                }
//            }
//        }
//    }
//
//    private void Xover(int one, int two) {
//        Random random = new Random();
//        int point;
//        double t;
//        // selecting crossover point
//        // here point should be always positive
//        point =  random.positiveRandom(0, Constants.NUMBER_OF_VARIABLES -1 );
//        // swap gens in position through point -1
//        for( int i =0; i<point; i++) {
//            t = Constants.population[one].getGens()[i];
//            Constants.population[one].getGens()[i] = Constants.population[two].getGens()[i];
//            Constants.population[two].getGens()[i] = t;
//        }
//    }
//
////    private double copy(double data) {
////        return data;
////    }
//}
