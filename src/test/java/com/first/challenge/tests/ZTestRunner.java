package com.first.challenge.tests;

import org.testng.TestNG;

public class ZTestRunner {

    static TestNG testNg;

    public static void main(String[] args) {
        testNg = new TestNG();
        testNg.setTestClasses(new Class[] {ZResultPageTest.class});
        testNg.run();
    }
}
