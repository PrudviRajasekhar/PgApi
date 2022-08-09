package om.pgstudent.heac.model;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ErrorType {

	public ErrorType(String time, String status, String message) {
		// TODO Auto-generated constructor stub
	}
	private String time;
	private String status;
	private String message;
	
}

