package api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private Long orderId;
    private Long productId;
    private double price;
    private int quantity;
}
