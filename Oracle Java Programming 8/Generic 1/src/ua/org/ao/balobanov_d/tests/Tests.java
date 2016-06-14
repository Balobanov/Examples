package ua.org.ao.balobanov_d.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({AddTest.class, DeleteTest.class, DeleteNullPointers.class,
	GetAllTest.class, GetElementTest.class, ResizeArray.class, UpdateTest.class})
public class Tests {
}
