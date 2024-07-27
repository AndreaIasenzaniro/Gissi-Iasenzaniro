package com.gisias.OpenWeather;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.gisias.OpenWeather.Exception.DateException;
import com.gisias.OpenWeather.Filter.IndexTemporalFilter;
import com.gisias.OpenWeather.Filter.TemporalFilter;
import com.gisias.OpenWeather.service.StatsFilterImpl;

class TestDateException {
	private StatsFilterImpl t1;
	private TemporalFilter filter1;
	private IndexTemporalFilter index1;
	@BeforeEach
	void setUp() throws Exception {
		t1 = new StatsFilterImpl();
		filter1 = new TemporalFilter("Ancona","10/01/2021 00:00:00","09/01/2021 00:00:00");
		index1 = new IndexTemporalFilter("Ancona","10/01/2021 00:00:00","09/01/2021 00:00:00",5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		DateException exception = assertThrows(DateException.class, () ->{
			t1.getTempFilter(filter1);
		});
		assertEquals("Intervallo non valido, la prima data deve precedere la seconda",exception.getMessage());
	}
	
	@Test
	void test2() {
		DateException exception = assertThrows(DateException.class, () ->{
			t1.getTempStats(filter1);
		});
		assertEquals("Intervallo non valido, la prima data deve precedere la seconda",exception.getMessage());
	}
	@Test
	void test3() {
		DateException exception = assertThrows(DateException.class, () ->{
			t1.getIndexFilter(index1);
		});
		assertEquals("Intervallo non valido, la prima data deve precedere la seconda",exception.getMessage());
	}
}
