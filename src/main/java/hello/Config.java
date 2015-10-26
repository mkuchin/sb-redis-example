package hello;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
@Configuration
@EnableAutoConfiguration 
public class Config {
	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory ob = new JedisConnectionFactory();
		ob.setHostName("localhost");
		ob.setPort(6379);
		return ob;
	}
	@Bean
	public StringRedisTemplate  stringRedisTemplate(){
		return new StringRedisTemplate(jedisConnectionFactory());
	}
} 
