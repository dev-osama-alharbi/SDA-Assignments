package sa.osama_alharbi.sda.assigments.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T16ContactResponsePojo {
	private String _id;
	private String firstName;
	private String lastName;
	private String country;
	private String birthdate;
	private String phone;
	private String city;
	private String postalCode;
	private String stateProvince;
	private String street1;
	private String street2;
	private String email;
	private String owner;
	private int __v;
}