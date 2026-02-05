package java_jabki.x6_order.service;

import java_jabki.x6_order.model.UserStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalUserService {

    private final RestClient restClient;

    public ExternalUserService(){
        this.restClient  = RestClient.builder().baseUrl("http://localhost:8085/api/v1").build();
    }

    public boolean CheckUser(long userId){
        UserStatus exist = restClient.get().uri("/user/check/{id}",userId).retrieve().body(UserStatus.class);
        return exist.status;
    }
}
