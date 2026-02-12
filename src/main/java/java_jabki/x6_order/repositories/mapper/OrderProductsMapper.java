package java_jabki.x6_order.repositories.mapper;

import java_jabki.x6_order.model.OrderProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class OrderProductsMapper implements RowMapper<OrderProduct> {
    @Override
    public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrderProduct.builder()
                .orderId(rs.getLong("order_id"))
                .productId(rs.getLong("product_id"))
                .quantity(rs.getInt("quantity"))
                .comments(rs.getString("comments"))
                .updateDate(rs.getObject("update_date", LocalDate.class))
                .build();
    }
}
