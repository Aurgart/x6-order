package java_jabki.x6_order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class OrderProducts {
    private int orderId;
    private int productId;
    private int quantity;
    private String comments;
    private LocalDate updateDate;
}
