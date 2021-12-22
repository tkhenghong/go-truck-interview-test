package com.gotruck.interview.test.models.controllers.response;

public class DigitRandomGeneratorResponse {
    int number;

    public DigitRandomGeneratorResponse(int number) {
        this.number = number;
    }

    public static DigitRandomGeneratorResponseBuilder builder() {
        return new DigitRandomGeneratorResponseBuilder();
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static class DigitRandomGeneratorResponseBuilder {
        private int number;

        DigitRandomGeneratorResponseBuilder() {
        }

        public DigitRandomGeneratorResponseBuilder number(int number) {
            this.number = number;
            return this;
        }

        public DigitRandomGeneratorResponse build() {
            return new DigitRandomGeneratorResponse(number);
        }

        public String toString() {
            return "DigitRandomGeneratorResponse.DigitRandomGeneratorResponseBuilder(number=" + this.number + ")";
        }
    }
}
