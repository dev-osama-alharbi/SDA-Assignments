package sa.osama_alharbi.sda.assigments.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePojo {
	private int id;
	private String employee_name;
	private int employee_salary;
	private int employee_age;
	private String profile_image;
}
