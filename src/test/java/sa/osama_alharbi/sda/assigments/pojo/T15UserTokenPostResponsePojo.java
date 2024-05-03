package sa.osama_alharbi.sda.assigments.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class T15UserTokenPostResponsePojo {
	private T15UserPostResponsePojo user;
	private String token;
}