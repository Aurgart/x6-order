package java_jabki.x6_order.service;

import java_jabki.x6_order.exception.OrderException;
import java_jabki.x6_order.model.OrderProduct;
import java_jabki.x6_order.repositories.OrderProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductService {
    private final OrderProductsRepository products;
    private final ExternalProductService items;

    public OrderProduct addOrderProduct(OrderProduct item) {
        validateItem(item);
        return products.insert(item);
    }

    public OrderProduct updOrderProduct(OrderProduct item) {
        validateItem(item);
        return products.update(item);
    }

    private void validateItem(OrderProduct item) {
        if (!items.getProduct(item.getProductId())) {
            throw new OrderException("Product not found");
        }
    }

}
