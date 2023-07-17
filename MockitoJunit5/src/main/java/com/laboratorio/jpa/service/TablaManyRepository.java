package com.laboratorio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laboratorio.jpa.entity.TablaManyId;
import com.laboratorio.jpa.entity.Tablamany;

public interface TablaManyRepository extends JpaRepository<Tablamany, TablaManyId>{

	
}
