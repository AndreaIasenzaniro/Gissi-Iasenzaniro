package com.gisias.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gisias.OpenWeather.service.Methods;

class TestMethod {
	private Methods m1;
	Vector<String> citta = new Vector<String>();
	@BeforeEach
	void setUp() throws Exception {
		citta.add("Termoli");
		citta.add("Ancona");
		citta.add("Rimini");
		citta.add("Genova");
		citta.add("Riccione");
		citta.add("Cagliari");
		citta.add("Amalfi");
		citta.add("Portofino");
		citta.add("Tropea");
		citta.add("Positano");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals(citta,m1.getCities());
	}

}
