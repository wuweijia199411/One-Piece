import com.spring.tx.demo3.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx3.xml")
public class AccountTest {

    @Resource(name = "accountService")
    private AccountService accountService;
    @Test
    public void test1()
    {
        accountService.transfer("wuweijia","wuwei",1000d);
    }

    @Test
    public void test()
    {
        accountService.transfer("wuweijia","wuwei",1000d);
    }


}
