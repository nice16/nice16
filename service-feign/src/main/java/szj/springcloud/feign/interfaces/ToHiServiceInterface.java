package szj.springcloud.feign.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import szj.springcloud.feign.interfaces.impl.ToHiServiceInterfaceImpl;

@Component
@FeignClient(value = "HELLO-SERVICE",fallback = ToHiServiceInterfaceImpl.class)
public interface ToHiServiceInterface {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String sayHiFromClient();
}