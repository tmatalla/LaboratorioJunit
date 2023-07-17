package com.laboratorio.jpa.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.laboratorio.jpa.beans.Employee;
import com.laboratorio.jpa.repository.EmployeeRepositoryImpl;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplMockTest {
	
	//1. clase falseada = clase q no sabe como comportarse
	@Mock
	private EmployeeRepositoryImpl repository;
	
	//2. Inyeccion de los mocks en la CLASE Q QUEREMOS TESTEAR
	//todo lo que pasemos por parámetro en el constructor lo falseamos
	@InjectMocks
	private EmployeeServiceImpl service;
	
	//3. todos los test devuelven void
	@Test
	void insert_checkOK() {
		//3.1 Given: todo lo que usa la clase real
		Employee empleadoEnviado = new Employee(0L,"Jill0",0);
		Employee empleadoObtenido = new Employee(1L,"Jill",8);
		Long expected=1L;
		
		//falseamos las llamadas
		Mockito.when(
				repository.save(any(Employee.class)))
		.thenReturn(empleadoObtenido);
		
		//When
		Employee actual = service.save(empleadoEnviado);
		
		//Asserts
		System.out.println("expected("+expected+"), actual("+actual+")");
		Assertions.assertEquals(expected, actual.getId());
	}


	@Test
	void getUser_findUserInDB_checkUserData() {
		//Given
		Long idEnviado=1L;
		Employee empleadoObtenido = new Employee(2L,"Jill",8);
		Long expected=2L;
		
		Mockito.when(
				repository.findOne(idEnviado))
		.thenReturn(empleadoObtenido);
		
		//When
		Optional<Employee> actual = service.findOneOptional(1L);
		Employee employee = actual.get();
		
		//Then - Asserts
		Assertions.assertEquals(expected, employee.getId());
	}
	
	@Test
	void getUser_findUserInDB_checkEmpty() {
		//Given
		Long idEnviado=1L;
		Employee empleadoObtenido = new Employee(2L,"Jill",8);
		Optional<Employee> expected=Optional.empty();
		
		Mockito.when(
				repository.findOne(idEnviado))
		.thenReturn(null);
		
		//When
		Optional<Employee> actual = service.findOneOptional(1L);
		
		//Then - Asserts
		Assertions.assertEquals(expected, actual);
	}
}
