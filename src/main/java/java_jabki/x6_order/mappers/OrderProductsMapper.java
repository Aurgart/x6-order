package java_jabki.x6_order.mappers;

import java_jabki.x6_order.model.OrderProducts;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class OrderProductsMapper implements RowMapper<OrderProducts> {
    @Override
    public OrderProducts mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrderProducts.builder()
                .orderId(rs.getInt("order_id"))
                .productId(rs.getInt("product_id"))
                .quantity(rs.getInt("quantity"))
                .comments(rs.getString("comments"))
                .updateDate(rs.getDate("update_date"))
                .build();
    }
}
