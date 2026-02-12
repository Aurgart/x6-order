package java_jabki.x6_order;

import java_jabki.x6_order.model.OrderProduct;
import java_jabki.x6_order.repositories.OrderProductsRepository;
import java_jabki.x6_order.service.ExternalProductService;
import java_jabki.x6_order.service.OrderProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class X6OrderProductTests {
    @Mock
    private OrderProductsRepository orderProductLogic;
    @Mock
    private ExternalProductService productService;
    @InjectMocks
    private OrderProductService orderProductService;


    @Test
    void createOrderProductTest() {
        RuntimeException excp = assertThrows(RuntimeException.class, () -> orderProductService.addOrderProduct(
                OrderProduct.builder()
                        .orderId(1L)
                        .productId(9L)
                        .comments("Test")
                        .quantity(100)
                        .updateDate(LocalDate.now())
                        .build())
        );
        Assertions.assertNotNull(excp.getMessage());
    }
}
