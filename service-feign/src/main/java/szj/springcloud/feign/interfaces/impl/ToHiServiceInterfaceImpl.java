package szj.springcloud.feign.interfaces.impl;

import org.springframework.stereotype.Component;
import szj.springcloud.feign.interfaces.ToHiServiceInterface;

@Component
public class ToHiServiceInterfaceImpl implements ToHiServiceInterface {
    @Override
    public String sayHiFromClient() {
        return "Error Hi";
    }
}