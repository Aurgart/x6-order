package java_jabki.x6_order;

import java_jabki.x6_order.model.Order;
import java_jabki.x6_order.repositories.OrderProductsRepository;
import java_jabki.x6_order.repositories.OrderRepository;
import java_jabki.x6_order.service.ExternalProductService;
import java_jabki.x6_order.service.ExternalUserService;
import java_jabki.x6_order.service.OrderProductService;
import java_jabki.x6_order.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class X6OrderTests {
    @Mock
    private OrderRepository orderLogic;
    @Mock
    private ExternalUserService userServ;
    @InjectMocks
    private OrderService orderService;



    @Test
    void createOrderTest() {
        /*Assertions.assertDoesNotThrow(() ->
                orderService.addOrder(
                        Order.builder()
                                .orderId(1)
                                .userId(1)
                                .description("Test")
                                .orderDate(LocalDate.now())
                                .build())
        );*/
        RuntimeException excp = assertThrows(RuntimeException.class, () -> orderService.addOrder(Order.builder().orderId(1).userId(0).description("Test").orderDate(LocalDate.now()).build()));
        Assertions.assertNotNull(excp.getMessage());
    }


}
