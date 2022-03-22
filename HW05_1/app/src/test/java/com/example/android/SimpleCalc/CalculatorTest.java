/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.hamcrest.number.IsCloseTo;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo((2d))));
    }

    @Test
    public void addTwoNumbersNegative(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(new IsCloseTo(2.222,0.01)));
    }

    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }
    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public  void powTwoNumbersPositive(){
        double resultPow = mCalculator.pow(2,2);
        assertThat(resultPow, is(equalTo(4d)));
    }
    @Test
    public  void powTwoNumbersNegativeFirst(){
        double resultPow = mCalculator.pow(-2,2);
        assertThat(resultPow, is(equalTo(4d)));
    }
    @Test
    public  void powTwoNumbersNegativeSecond(){
        double resultPow = mCalculator.pow(2,-1);
        assertThat(resultPow, is(equalTo(0.5d)));
    }
    @Test
    public  void powTwoNumbersZeroFirst(){
        double resultPow = mCalculator.pow(0,5);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public  void powTwoNumbersZeroSecond(){
        double resultPow = mCalculator.pow(10,0);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powTwoNumberZeroFirstNegtiveSecond(){
        double resultPow = mCalculator.pow(0,-1);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powTwoNumberNegativeZeroFirstNegtiveSecond(){
        double resultPow = mCalculator.pow(-0,-1);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}