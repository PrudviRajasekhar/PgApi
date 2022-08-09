package om.pgstudent.heac.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import om.pgstudent.heac.exception.StudentNotFoundException;
import om.pgstudent.heac.model.PgMStudent;
import om.pgstudent.heac.repo.StudentregRepository;
import om.pgstudent.heac.service.StudentRegService;

@Service
public class StudentServiceImpl implements StudentRegService {

	@Autowired
	StudentregRepository repo;
	@Override
	public void modifyStudent(PgMStudent p) {
		Integer id = p.getStudentId();
		if(id!=null && repo.existsById(id)) {
			//id exist in DB then
			repo.save(p);
		} else {
			throw new StudentNotFoundException("Student '"+id+"' Not exist");
		}
	}
	@Override
	public Integer saveStudent(PgMStudent p) {
		
		return repo.save(p).getStudentId();
		
		}

	@Override
	public Integer updateStudent(PgMStudent p) {
		return repo.save(p).getStudentId();
		
	}

	@Override
	public void deleteStudent(String StudentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public PgMStudent getOneStudent(String StudentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
//
//	@Override
//	public List<PgMStudent> getAllProduct() {
//		List<PgMStudent> list = repo.findAll();
//		list.sort(
//				(p1,p2) -> 
//				p1.getStudentId().compareTo(p2.getStudentId())
//				);
//		return list;
//	}

	

	@Override
	public PgMStudent getonecivilnum(String civilNum) {
		
		PgMStudent student = repo.findByCivilNum(civilNum);
//		list.sort(
//				(p1,p2) -> 
//				p1.getStudentId().compareTo(p2.getStudentId())
//				);
			return student;

	}

	@Override
	public List<PgMStudent> getAllStudents() {
		// TODO Auto-generated method stub
		List<PgMStudent> list = repo.findAll();
		list.sort(
				(p1,p2) -> 
				p1.getStudentId().compareTo(p2.getStudentId())
				);
		return list;
		
	}

}

/*try {
			List<PgMStudent> list  = repo.findByCivilNum(civilNum);
			list.sort(
					(p1,p2) -> 
					p1.getStudentId().compareTo(p2.getStudentId())
					);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//return list;
		
	*/
