//package com.rajim;
//
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Population {
//
//    public void initialize() {
//        Random random = new Random();
//        double[][] ranges = {{0, 4}, {0, 5}, {-3, 3}}; // ranges
//        double lower;
//        double upper;
//        double[] upperArray = new double[Constants.NUMBER_OF_VARIABLES];
//        double[] lowerArray = new double[Constants.NUMBER_OF_VARIABLES];
//
//        for (int j = 0; j < Constants.POPULATION_SIZE; j++) {
//            double[] gens  = new double[Constants.NUMBER_OF_VARIABLES];
//            for (int i = 0; i < Constants.NUMBER_OF_VARIABLES; i++) {
//                lower = ranges[i][0];
//                upper = ranges[i][1];
//                upperArray[i] = upper;
//                lowerArray[i] = lower;
//                gens[i] = random.getRandomNumber(lower, upper);
//            }
//            GenoType genoType = new GenoType(gens, 0, upperArray, lowerArray,
//                    0, 0);
//            Constants.population[j] = genoType;
//        }
//    }
//}
//
//
