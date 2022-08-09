package om.pgstudent.heac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import om.pgstudent.heac.model.PgMStudent;

public interface StudentregRepository extends JpaRepository<PgMStudent, Integer> {

//	List<PgMStudent> findByCivilNum(String CivilNum);
	
	
	PgMStudent findByCivilNum(String civilNum);
	
	
	
}
