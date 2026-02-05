package java_jabki.x6_order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class OrderProducts {
    private int orderId;
    private int productId;
    private int quantity;
    private String comments;
    private Date updateDate;
}
