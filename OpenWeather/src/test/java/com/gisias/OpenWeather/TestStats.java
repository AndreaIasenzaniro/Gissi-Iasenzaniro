package com.gisias.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gisias.OpenWeather.Stats.Stats;

class TestStats {

	private Stats s1, s2;
	Vector<Double> v1 = new Vector<Double>();
	Vector<Double> v2 = new Vector<Double>();
	
	@BeforeEach
	void setUp() throws Exception {
		v1.add(5.0); v2.add(0.0);
		v1.add(3.0); v2.add(0.0);
		v1.add(6.0); v2.add(0.0);
		v1.add(2.0); v2.add(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		assertEquals(6.0,s1.getMaxVal(v1));
		assertEquals(2.0,s2.getMinVal(v1));
		
	}
	
	@Test
	void test2() {
		assertEquals(0.0,s1.getMaxVal(v2));
		assertEquals(0.0,s2.getMinVal(v2));
	}

}
