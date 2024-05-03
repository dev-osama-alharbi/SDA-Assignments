package sa.osama_alharbi.sda.assigments.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetStoreResponsePojo {
	private int code;
	private String type;
	private String message;
}
