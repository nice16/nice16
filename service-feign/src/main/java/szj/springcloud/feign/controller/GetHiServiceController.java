package szj.springcloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import szj.springcloud.feign.interfaces.ToHiServiceInterface;

@RestController
public class GetHiServiceController {
    @Autowired
    ToHiServiceInterface toHi;
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String sayHi(){
        return toHi.sayHiFromClient();
    }
}