package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Docente;
import com.empresa.entity.FiltroDocente;
import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {
			
	@Query("select m from Modalidad m where "
					+ "( :#{#filtro.nombre} is ' ' or  m.nombre like :#{#filtro.nombre}) and "
					+ "( :#{#filtro.numHombres} is 0 or m.numHombres = :#{#filtro.numHombres}) and "
					+ "( :#{#filtro.numMujeres} is 0 or m.numMujeres = :#{#filtro.numMujeres}) and "
					+ "( :#{#filtro.edadMaxima} is 0 or m.edadMaxima = :#{#filtro.edadMaxima}) and "
					+ "( :#{#filtro.edadMinima} is 0 or m.edadMinima = :#{#filtro.edadMaxima}) and  "
					+ "( :#{#filtro.sede} is ' ' or m.sede = :#{#filtro.sede} ) and "
					+ "( :#{#filtro.idDeporte} is 0 or m.deporte.idDeporte = :#{#filtro.idDeporte}) ")
	public abstract List<Modalidad> filtraxFiltro(@Param("filtro") FiltroModalidad obj ); 
	
	
	

	
	
}
