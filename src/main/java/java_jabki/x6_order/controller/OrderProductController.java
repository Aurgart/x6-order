package java_jabki.x6_order.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java_jabki.x6_order.model.OrderProduct;
import java_jabki.x6_order.service.OrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order_product")
@Tag(name ="Заказики-товары")
public class OrderProductController {
    private final OrderProductService orderProductService;

    @PostMapping
    @Operation(summary = "Создать товар")
    public OrderProduct create(@RequestBody OrderProduct item){
        return orderProductService.addOrderProduct(item);
    }
}
