package com.gotruck.interview.test;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class TestApplication {
    @Value("${digit.random.generator.mean}")
    private double mean;

    @Value("${digit.random.generator.standard.deviation}")
    private double standardDeviation;

    @Bean
    NormalDistribution normalDistribution() {
        return new NormalDistribution(mean, standardDeviation);
    }

    /**
     * Create a random number generator, with a random seed value upon creation.
     * @return a random number generator
     */
    @Bean
    Random random() {
        return new Random(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
