package api.version_1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String address;
    private String email;
    private Long phone;
}
