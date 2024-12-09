package com.csv.Herois.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csv.Herois.model.Heroi;



public interface IHeroiRepository  extends JpaRepository<Heroi, Integer>{
	@Query(value = "SELECT h FROM Heroi h WHERE h.name = ?1")
	public Heroi findHeroiNome(String name);
	
	@Query(value = "SELECT h FROM Heroi h WHERE h.weight >?1 ORDER BY h.name ASC")
	public List<Heroi> findWeightGTOrderByNomeASC(double weight);
	@Query(value = "SELECT h FROM Heroi h WHERE h.weight =?1 ORDER BY h.name ASC")
	public List<Heroi> findWeightEQOrderByNomeASC(double weight);
	@Query(value = "SELECT h FROM Heroi h WHERE h.weight <?1 ORDER BY h.name ASC")
	public List<Heroi> findWeightLTOrderByNomeASC(double weight);

	@Query(value = "SELECT h FROM Heroi h WHERE h.publish =?1 ORDER BY h.name ASC")
	public List<Heroi> findPublishOrderByNomeASC(String publish);
}

