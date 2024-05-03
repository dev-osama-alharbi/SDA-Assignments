package sa.osama_alharbi.sda.assigments.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T15UserPostResponsePojo {
	private String _id;
	private String firstName;
	private String lastName;
	private String email;
	private int __v;
}