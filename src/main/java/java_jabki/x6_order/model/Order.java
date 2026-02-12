package java_jabki.x6_order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private Long orderId;
    private Long userId;
    private LocalDate orderDate;
    private String description;
}
