import com.spring.aopannotation.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopannotationTest {

    @Resource(name = "orderDao")
    private OrderDao orderDao;
    @Test
    public void demo1()
    {
        orderDao.save();
        orderDao.delete();
        orderDao.update();
        orderDao.search();

    }
}

