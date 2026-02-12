package java_jabki.x6_order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java_jabki.x6_order.exception.OrderException;
import java_jabki.x6_order.model.Order;
import java_jabki.x6_order.model.OrderProduct;
import java_jabki.x6_order.model.UserStatus;
import java_jabki.x6_order.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orders;
    private final ExternalUserService users;
    private final OrderProductService orderProducts;
    private final RabbitMQService rabbitMQService;

    public Order addOrder(Order ord){
        validateOrder(ord);
        orders.insert(ord);

        for (OrderProduct orderProduct : ord.getOrderProducts()){
            orderProducts.addOrderProduct(orderProduct);
        }
        try {
            rabbitMQService.send(ord);
        } catch(JsonProcessingException ex) {
            throw new OrderException("Ошибка JSON-сериализации заказа перед отправкой в RabbitMQ");
        }

        return ord;
    }
    public Order getbyId(final Long id) {
        return orders.getById(id);
    }

    public void deleteUser(final Long id) {
        orders.delete(id);
    }

    public void updateUser(Order ord) {
        orders.update(ord);
    }

    private void validateOrder(Order ord){
        if(!users.checkUser(ord.getUserId())) {
            throw new OrderException("Пользователь не найден");
        }
    }
}
