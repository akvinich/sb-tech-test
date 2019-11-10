package runner;

import org.testng.TestNG;

import java.util.Arrays;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Arrays.asList(new String[]{"./src/main/resources/testng.xml"}));
        testNG.run();
    }
}
