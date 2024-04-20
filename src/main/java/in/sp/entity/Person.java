package in.sp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
	private String party_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private char gender;
	private String birth_date;
	private String material_status_enum_id;
	private String employment_status_enum_id;
	private String occupation;
}
