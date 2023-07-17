package com.laboratorio.jpa.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class StaticUtilsTest {

	@Test
	void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
		//mockeando la clase statica
	    try (MockedStatic<StaticUtils> mockSt = Mockito.mockStatic(StaticUtils.class)) {
	        mockSt.when(StaticUtils::name).thenReturn("Eugen");
	        assertThat(StaticUtils.name()).isEqualTo("Eugen");
	    }

		//NO mockeando la clase statica
	    assertThat(StaticUtils.name()).isEqualTo("Baeldung");
	}

	@Test
	void givenStaticMethodWithArgs_whenMocked_thenReturnsMockSuccessfully() {
	    assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);

	    try (MockedStatic<StaticUtils> mockSt = Mockito.mockStatic(StaticUtils.class)) {
	        mockSt.when(() -> StaticUtils.range(2, 6))
	          .thenReturn(Arrays.asList(10, 11, 12));

	        assertThat(StaticUtils.range(2, 6)).containsExactly(10, 11, 12);
	    }

	    assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);
	}

}
