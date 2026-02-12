package java_jabki.x6_order.model;

import lombok.Data;

@Data
public class ApiError {
    final boolean result;
    final String description;
}

