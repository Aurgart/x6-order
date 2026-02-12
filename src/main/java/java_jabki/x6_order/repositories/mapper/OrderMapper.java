package java_jabki.x6_order.repositories.mapper;

import java_jabki.x6_order.model.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper  implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .orderId(rs.getLong("order_id"))
                .userId(rs.getLong("user_id"))
                .orderDate(rs.getDate("order_date").toLocalDate())
                .description(rs.getString("description"))
                .build();
    }

}
