package java_jabki.x6_order.service;

import java_jabki.x6_order.exception.OrderException;
import java_jabki.x6_order.model.OrderProducts;
import java_jabki.x6_order.repositories.OrderProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductService {
    private final OrderProductsRepository products;
    private final ExternalProductService items;

    public OrderProducts addOrderProduct(OrderProducts item){
        validateItem(item);
        return products.insert(item);
    }

    public OrderProducts updOrderProduct(OrderProducts item){
        validateItem(item);
        return products.update(item);
    }

    private void validateItem(OrderProducts item){
        if(!items.GetProduct(item.getProductId())){
            throw new OrderException("Product not found");
        }
    }

}
