package com.gotruck.interview.test.question1;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


/**
 * Question's Hint: The methods in Random and SecureRandom class do not guarantee a uniform frequency distribution for a small sampling size.
 */
@Service
public class DigitRandomGeneratorImpl implements DigitRandomGenerator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Normal Distribution. Bell shape curve graph. Requires mean and standard deviation.
    private final NormalDistribution normalDistribution;

    // Random with fixed seed value upon startup. Produces almost Uniform Frequency Distribution. Requires min and max.
    private final Random random;

    @Autowired
    DigitRandomGeneratorImpl(NormalDistribution normalDistribution, Random random) {
        this.normalDistribution = normalDistribution;
        this.random = random;
    }

    @Override
    public int generateDigit() {
        int randomDigit = random.nextInt((10 - 0) + 1) + 0;
        logger.info("randomDigit: " + randomDigit);
        return randomDigit;
    }
}
