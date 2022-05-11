import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringTest {

    @Test
    public void contextLoads(){
        RestTemplate restTemplate = new RestTemplate();
        //第二个参数，控制该方法返回值
        String result = restTemplate.getForObject("http://localhost:8965/produce/get",String.class);
        System.out.println(result);

        String name="2";
        Integer age = 12;
        String result1 = restTemplate.getForObject("http://localhost:8965/produce/get?name={1}&age={2}",String.class,name,age);
        System.out.println(result1);

        Map<String,Object> map = new HashMap<>();
        map.put("name","3");
        map.put("age",123);
        String result2 = restTemplate.getForObject("http://localhost:8965/produce/get?name={name}&age={age}",String.class,map);
        System.out.println(result2);

        //单值 访问 PathVariable
        String name1="2";
        Integer age2 = 12;
        String result3 = restTemplate.getForObject("http://localhost:8965/produce/get/{1}/{2}",String.class,name1,age2);
        System.out.println(result3);

        //map 访问 PathVariable
        Map<String,Object> map2 = new HashMap<>();
        map.put("name","3");
        map.put("age",123);
        String result34 = restTemplate.getForObject("http://localhost:8965/produce/get/{name}/{age}",String.class,map2);
        System.out.println(result34);

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8965/produce/get",String.class);
        System.out.println(entity.getBody());
        System.out.println(entity.getStatusCodeValue());
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());

        //restTemplate 使用 exchange

    }
}
