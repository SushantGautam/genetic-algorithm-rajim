//package com.rajim;
//
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.DoubleStream;
//
//public class Selector {
//
//    public void selector() {
//        double a = 0.0;
//        double b = 1.0;
//        double p;
//        double sum = Arrays.asList(Constants.population).stream()
//                .map(e-> e.getFitness())
//                .reduce(0.0, Double:: sum);
//        List<GenoType> genoTypes = Arrays.asList(Constants.population);
//        // Setting relative fitness
//        genoTypes = genoTypes.stream().map(e-> setRelativeFitness(e, sum)).collect(Collectors.toList());
//
//        // Finding total fitness
////        for (int mem = 0; mem < Constants.POPULATION_SIZE; mem++) {
////            sum = sum + Constants.population[mem].getFitness();
////        }
//        // calculating the relative fitness of each member
////        for (int mem = 0; mem < Constants.POPULATION_SIZE; mem++) {
////            Constants.population[mem].setRelativeFitness((Constants.population[mem].getFitness() / sum));
////        }
//
//        double[] cummulativeFitness = new double[Constants.POPULATION_SIZE];
//        cummulativeFitness[0] = Constants.population[0].getRelativeFitness();
//        double total = 0;
//        for (int i = 1; i < Constants.POPULATION_SIZE; i++) {
//            total = total + Constants.population[i - 1].getCumulativeFitness()
//                    + Constants.population[i].getRelativeFitness();
//            cummulativeFitness[i] = total;
//        }
//        // calculating cumulative fitness
////        Constants.population[0].setCumulativeFitness(Constants.population[0].getFitness());
////        int index = 0;
////        for(GenoType genoType: genoTypes) {
////            System.out.println("value:"+cummulativeFitness[index]);
////            genoType.setCumulativeFitness(cummulativeFitness[index]);
////            index++;
////        }
////        System.out.println(genoTypes.toArray().toString());
//        Constants.population  =  genoTypes.toArray(Constants.population);
//
//        for (int mem = 0; mem < Constants.POPULATION_SIZE; mem++) {
//            double value = cummulativeFitness[mem];
//            Constants.population[mem].setCumulativeFitness(value);
//        }
//        // Select survivors using cumulative fitness.
//        Random random = new Random();
//        for (int x = 0; x < Constants.POPULATION_SIZE; x++) {
//            p = random.getRandomNumber(a, b);
//            if (p < Constants.population[0].getCumulativeFitness()) {
//                Constants.newpopulation[x] = Constants.population[0];
//            } else {
//                for (int j = 0; j < Constants.POPULATION_SIZE; j++) {
//                    if (Constants.population[j].getCumulativeFitness() <= p
//                            && p < Constants.population[j + 1].getCumulativeFitness()) {
//                        Constants.newpopulation[x] = Constants.population[j + 1];
//                    }
//                }
//            }
//        }
//
//        // overwrite the old population with the new one
//
//        for (int z = 0; z < Constants.POPULATION_SIZE; z++) {
//            Constants.population[z] = Constants.newpopulation[z];
//        }
//    }
//
//    private GenoType setRelativeFitness(GenoType genoType, double sum) {
//        genoType.setRelativeFitness(genoType.getFitness()/sum);
//        return genoType;
//    }
//}
