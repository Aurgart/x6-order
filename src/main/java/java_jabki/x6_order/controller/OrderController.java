package java_jabki.x6_order.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java_jabki.x6_order.model.Order;
import java_jabki.x6_order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
@Tag(name ="Заказики")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @Operation(summary = "Создать заказ")
    public Order create(@RequestBody Order ord){
        return orderService.addOrder(ord);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Чекнуть заказ")
    public Order getById(@PathVariable("id") String id){
        return orderService.getbyId(Long.parseLong(id));
    }
}
