package org.ssglobal.training.codes;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestBoa {

	private Boa boa;
		
	@BeforeEach
	public void setup() {
		Boa jen = new Boa("Jennifer", 2, "grapes");
        Boa ken = new Boa("Kenneth", 3, "granola bars");
        Boa dolly = new Boa("Mandy", 4, "rice grains");
        Boa eric = new Boa("Dandy", 5, "mice");
        Boa lu = new Boa("Minie", 6, "parrot");
	}
	
	@ParameterizedTest
	@MethodSource("boaProvider")
	public void testIsHealthyJen() {
				
	}
	
	@ParameterizedTest
	@MethodSource("boaProvider")
	public void testFitsInCageXXX() {
		
	}
	
	@AfterEach
	public void teardown() {
		boa = null;
	}
	
	private static Stream<Boa> boaProvider() {
		return Stream.of(new Boa("Jennifer", 2, "grapes"),
				         new Boa("Kenneth", 3, "granola bars"),
				         new Boa("Mandy", 4, "rice grains"),
				         new Boa("Dandy", 5, "mice"),
				         new Boa("Minie", 6, "parrot"));			        
	}
}
