package om.pgstudent.heac.exception.handler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import om.pgstudent.heac.exception.StudentNotFoundException;
import om.pgstudent.heac.model.ErrorType;

public class StudentErrorHandler {
	/**
	 * In case of StudentNotFoundException is thrown
	 * from any controller method, this logic gets
	 * executed which behaves like re-usable and
	 * clear code (Code Modularity)
	 * @param pne
	 * @return ResponseEntity
	 */

	//@ResponseBody
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleNotFound(
			StudentNotFoundException pne)
	{
		
		return new ResponseEntity<String>(
				pne.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
