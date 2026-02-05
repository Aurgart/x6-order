package java_jabki.x6_order.service;

import java_jabki.x6_order.model.ProductStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalProductService {

    private final RestClient restClient;

    public ExternalProductService(){
        this.restClient  = RestClient.builder().baseUrl("http://localhost:8086/api/v1").build();
    }

    public boolean GetProduct(long productId){
        ProductStatus exist = restClient.get().uri("/product/item/{id}",productId).retrieve().body(ProductStatus.class);
        return exist.status;
    }
}
