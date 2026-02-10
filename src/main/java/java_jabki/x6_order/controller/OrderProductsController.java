package java_jabki.x6_order.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java_jabki.x6_order.model.OrderProducts;
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
public class OrderProductsController {
    private final OrderProductService orderProductService;

    @PostMapping
    @Operation(summary = "Создать товар")
    public OrderProducts create(@RequestBody OrderProducts item){
        return orderProductService.addOrderProduct(item);
    }
}
