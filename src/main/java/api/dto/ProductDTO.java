package api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private Short price;
    private String description;
    private Boolean inStock;
}
