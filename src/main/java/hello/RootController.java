package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.redis.core.StringRedisTemplate;

@RestController
public class RootController {
    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/")
    public String index() {
        long counter = template.opsForValue().increment("counter", 1);
        return Long.toString(counter);
    }

}
