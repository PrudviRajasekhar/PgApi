package om.pgstudent.heac.service;

import java.util.List;

import om.pgstudent.heac.model.PgMStudent;



public interface StudentRegService {

	Integer  saveStudent(PgMStudent p);
	Integer updateStudent(PgMStudent p);
	void modifyStudent(PgMStudent p);
	
	void deleteStudent(String StudentId);
	PgMStudent getOneStudent(String StudentId);
	
	List<PgMStudent> getAllStudents();
	//Integer updateProductCodeById(String code,Integer id);
	PgMStudent getonecivilnum(String civilNum);
}
