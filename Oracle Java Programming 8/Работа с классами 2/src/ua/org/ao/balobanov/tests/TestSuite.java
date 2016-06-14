package ua.org.ao.balobanov.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AddGradeTest.class, AverageGradeInSemesterTest.class, 
    ExamesCountWithGradeTest.class, RemoveGradeTest.class })
public class TestSuite {
}
