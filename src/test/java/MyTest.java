import com.lovezhan.App;
import com.lovezhan.bean.AdminUser;
import com.lovezhan.bean.Book;
import com.lovezhan.bean.MyUser;
import com.lovezhan.mapper.AdminUserMapper;
import com.lovezhan.mapper.MyUserMapper;
import com.lovezhan.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest(classes = App.class)
public class MyTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AdminUserMapper mapper;

    @Autowired
    private MyUserMapper myUserMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private BookService bookServiceImpl;


    @Test
    public void test(){
        Long aLong = jdbcTemplate.queryForObject("select count(1) from admin_user", Long.class);
        log.info("记录数：{}",aLong);
    }


    @Test
    public void testMybatis() {
        AdminUser adminUser = mapper.selectByPrimaryKey(1);
        System.out.println(adminUser);
    }

    @Test
    public void testMybatisPlus() {
        MyUser myUser = myUserMapper.selectById(1L);
        log.info("myuser: {}", myUser);
    }

    @Test
    public void testStringRedisTemplate(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("hello","boy");
        System.out.println(stringStringValueOperations.get("hello"));
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory)redisConnectionFactory;
        System.out.println(redisConnectionFactory.getClass());
        System.out.println(jedisConnectionFactory.getClientName());
    }

    @Test
    public void testCache() {
        Long count = bookServiceImpl.getBookById(1);
        System.out.println(count);
    }

}
