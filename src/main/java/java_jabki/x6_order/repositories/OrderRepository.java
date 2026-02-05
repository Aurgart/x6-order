package java_jabki.x6_order.repositories;

import java_jabki.x6_order.mappers.OrderMapper;
import java_jabki.x6_order.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private static final String INSERT = """
            INSERT INTO  x6_order.order(user_id, order_date , description)
            VALUES (:user_id, now() , :description)
            RETURNING *;
            """;
    private static final String UPDATE = """
            UPDATE  x6_order.order
            SET  description = :description
            WHERE order_id = :order_id
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE x6_order.order
            WHERE order_id = :order_id
            """;

    private static final String DELETE_BY_USER = """
            DELETE x6_order.order
            WHERE user_id = :user_id
            """;

    private static final String GET_BY_ID = """
            SELECT *
            FROM x6_order.order
            WHERE order_id = :order_id
            """;

    private final OrderMapper orderMapp;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Order insert(final Order order) {
        return jdbcTemplate.queryForObject(INSERT, orderParamForSql(order), orderMapp);
    }

    public Order update(final Order order) {
        return jdbcTemplate.queryForObject(UPDATE, orderParamForSql(order), orderMapp);
    }

    public void delete(final Long id) {
        jdbcTemplate.update(DELETE, new MapSqlParameterSource("order_id", id));
    }

    public void deleteByUser(final Long id) {
        jdbcTemplate.update(DELETE, new MapSqlParameterSource("user_id", id));
    }

    public Order getById(final Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, new MapSqlParameterSource("order_id", id), orderMapp);

    }

    public MapSqlParameterSource orderParamForSql(final Order order) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("order_id", order.getOrderId());
        params.addValue("order_date", order.getOrderDate());
        params.addValue("user_id", order.getUserId());
        params.addValue("description", order.getDescription());
        return params;
    }
}
