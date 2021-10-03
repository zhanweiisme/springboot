import com.lovezhan.App;
import com.lovezhan.utils.SaltDictUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.IOException;

@SpringBootTest(classes = App.class)
public class CrawlerProTest {

    @Test
    public void password() throws IOException {
        String salt = SaltDictUtil.getKeyValues("st_47");
        String md5_account= DigestUtils.md5DigestAsHex("sitechadmin".getBytes());
        String md5_password=DigestUtils.md5DigestAsHex("@Sitechadmin123".getBytes());
        String md5_password123456=DigestUtils.md5DigestAsHex("123456".getBytes());
        String md5_salt=DigestUtils.md5DigestAsHex(salt.getBytes());
        String realPassword=md5_account+md5_password+md5_salt;
        System.out.println(md5_account + "-" + md5_password + "-" + md5_salt );
        System.out.println(md5_account + "-" + md5_password123456 + "-" + md5_salt );
        System.out.println("realPassword--" + realPassword);
    }



}
