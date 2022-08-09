package om.pgstudent.heac.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PG_M_STUDENT")

public class PgMStudent {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer StudentId;
	
	private String civilNum;
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
//	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String caoNum;
	
	private String firstName;
	private String firstNameAr;
	private String secondName;
	private String secondNameAr;
	private String thirdNameAr;
	private String thirdName;
	private String fourthName;
	private String fourthNameAr;	
	private String familyNameAr;
	private String familyName;
	private String gsm;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	private String Gender;
	private String passportNum;
	private Date passportExpiryDate;
	private String relationId;
	private String sysId;
	
}
