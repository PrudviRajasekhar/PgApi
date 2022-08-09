package om.pgstudent.heac.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import om.pgstudent.heac.exception.StudentNotFoundException;
//import om.pgstudent.heac.exception.StudentNotFoundException;
import om.pgstudent.heac.model.PgMStudent;
import om.pgstudent.heac.repo.StudentregRepository;
import om.pgstudent.heac.service.StudentRegService;



@RequestMapping("/rest/studentreg")
@RestController
@CrossOrigin("*")
@Slf4j
public class StudentRestController {
	@Autowired
	private StudentRegService service; 
	
	@Autowired
	private StudentregRepository repo;
	
	/**
	 * Fetching all records from Student Master
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
		ResponseEntity<?> resp = null;

		try {
			List<PgMStudent> list =  service.getAllStudents();
			resp = new ResponseEntity<List<PgMStudent>>(
					list,
					HttpStatus.OK);//200-OK
		} catch (Exception e) {
			resp = new ResponseEntity<String>(
					"Unable to fetch student", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
		}
		return resp;
	}
	
	/*
	 * Inserting record to Student Master table
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(
			@RequestBody PgMStudent student) 
	{
		ResponseEntity<String> resp = null;
		try {
			
			Integer id = service.saveStudent(student);
			PgMStudent studentData = null ;
			
				studentData = service.getonecivilnum(student.getCivilNum()) ;
				if(studentData!= null) {
					System.out.println("ID is"+studentData.getStudentId().toString());
				return new ResponseEntity <PgMStudent>(
						studentData,
						HttpStatus.OK);
				
				}
			resp = new ResponseEntity<String>(
					"student '"+student.getStudentId()+student.getCivilNum() +"' Created", 
					HttpStatus.CREATED); //201-Created
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to save Student", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500-ISE
		}
		return resp;
	}
	
	
	
	@GetMapping("/find/{civilNum}")
	public ResponseEntity<?> getOneStudent(
			@PathVariable("civilNum") String civilNum
			)
	{
		PgMStudent student = null ;
		try {
			student = service.getonecivilnum(civilNum) ;
			if(student!= null) {
			return new ResponseEntity <PgMStudent>(student,
					HttpStatus.OK);
			//System.out.println(student.toString());
			}
			
//			else {
//				System.out.println("test");	
//				resp = new ResponseEntity<String>(
//						"Student with  '"+civilNum+"' Not Available", 
//						HttpStatus.BAD_REQUEST); //400-ISE
//			}
			
		}

			catch (Exception e) {
			log.error(e.getMessage());
//			resp = new ResponseEntity<String>(
//					"Student with  '"+civilNum+"' Not Available", 
//					HttpStatus.BAD_REQUEST); //500-ISE
		}

		return new ResponseEntity<String>(
				"Student with  '"+civilNum+"' Not Available", 
				HttpStatus.BAD_REQUEST);
	}
	
	
	//@PatchMapping("/modify")
	@PutMapping("/modify")
	public ResponseEntity<String> updateEmployee(
			@RequestBody PgMStudent student
			) 
	{
		ResponseEntity<String> response = null;
		try {
//			service.updateStudent(student);
			service.modifyStudent(student);
			response = new ResponseEntity<String>("student Updated!",HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;//calls Global Handler
		}
		return response;
	}
	
//	public ResponseEntity<?> updateStudent(@RequestBody PgMStudent student){
	/*
	@PutMapping("/update/{civilNum}")
	public ResponseEntity<?> updateStudent(@PathVariable("civilNum") String civilNum){
		
		ResponseEntity<String> resp = null;
		PgMStudent studentA =repo.findByCivilNum(civilNum);
		System.out.println("found"+studentA.getCivilNum());
		if(student!=null) {
		
		student.setFamilyName(studentA.getFamilyName());
		student.setFirstName(studentA.getFirstName());
		service.updateStudent(student);
		resp = new ResponseEntity<String>("Student"+student.getCivilNum()+"updated",HttpStatus.OK);
		}
		else {
			System.out.println("Record not found");
			resp = new ResponseEntity<String>("Student with"+civilNum+"not found",HttpStatus.NOT_FOUND);
		}
		return resp;
		
	}
	*/

}

