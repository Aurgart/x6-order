package java_jabki.x6_order.repositories;

import java_jabki.x6_order.repositories.mapper.OrderProductsMapper;
import java_jabki.x6_order.model.OrderProduct;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderProductsRepository {

    private static final String INSERT = """
            INSERT INTO  x6_order.order_products(order_id, product_id , quantity, comments)
            VALUES (:order_id, :product_id , :quantity, :comments)
            RETURNING *;
            """;
    private static final String UPDATE = """
            UPDATE  x6_order.order_products
            SET  quantity = :quantity,
                update_date = now()
            WHERE order_id = :order_id
            RETURNING *;
            """;
    private static final String DELETE = """
            DELETE x6_order.order_products
            WHERE order_id = :order_id
            """;
    private static final String GET_BY_ORDER_ID = """
            SELECT *
            FROM x6_order.order_products
            WHERE order_id = :order_id
            """;

    private final OrderProductsMapper orderProdMapp;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderProduct insert(final OrderProduct orderProd) {
        return jdbcTemplate.queryForObject(INSERT, orderProdParamForSql(orderProd), orderProdMapp);
    }

    public OrderProduct update(final OrderProduct orderProd) {
        return jdbcTemplate.queryForObject(UPDATE, orderProdParamForSql(orderProd), orderProdMapp);
    }

    public void delete(final Long id) {
        jdbcTemplate.update(DELETE, new MapSqlParameterSource("order_id", id));
    }

    public List<OrderProduct> getByOrderId(final Long id) {
        return jdbcTemplate.query(GET_BY_ORDER_ID, new MapSqlParameterSource("order_id", id), orderProdMapp);
    }


    public MapSqlParameterSource orderProdParamForSql(final OrderProduct orderProd) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("order_id", orderProd.getOrderId());
        params.addValue("product_id", orderProd.getProductId());
        params.addValue("quantity", orderProd.getQuantity());
        params.addValue("comments", orderProd.getComments());
        params.addValue("update_date", orderProd.getUpdateDate());
        return params;
    }
}
