package edu.jsu.mcis.gamegogy;


import org.junit.*;
import static org.junit.Assert.*;


public class GamegogyTest {
    private boolean value;
    

    @Before
	public void beforeAllTests() {
        value = true;
    }

    @After
	public void afterAllTests() {
        value = false;
    }

    @Test
	public void test() {
		assertTrue(value);
	}
}
