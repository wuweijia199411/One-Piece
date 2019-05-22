import com.spring.aop.*;
import com.spring.aopfight.ProductDao;
import com.spring.demo.CustomerService;
import com.spring.demo.UserService;
import com.spring.demo.userDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo1 {

    @Test
    public void test()
    {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        userDAO userDAO= (userDAO) app.getBean("userDAO");
        userDAO.save();

    }
    @Test
    public void demo_1()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        userDAO userdaO=(userDAO) applicationContext.getBean("userDao");
        userdaO.save();

    }

    @Test
    public void demo_2()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userservice=(UserService) applicationContext.getBean("userService");
        userservice.save();

    }

    @Test
    public void demo_3()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService cs=(CustomerService) applicationContext.getBean("customerService");
        System.out.println(cs);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void demo_4()
    {
        UserDao userdao=new UserDaoImpl();
        UserDao proxy= new JDKProxy(userdao).createProxy();
        proxy.delete();
        proxy.save();
    }
    @Test
    public void demo_5()
    {
        CustomerDao customerDao=new CustomerDao();
        CustomerDao cp=new CglibProxy(customerDao).createProxy();
        cp.delete();
        cp.save();

    }
    @Resource(name="productDao")
    private ProductDao productDao;
    @Test
    public void demo_aop1()
    {
        productDao.save();
        productDao.search();
        productDao.delete();
        productDao.update();
    }





}
