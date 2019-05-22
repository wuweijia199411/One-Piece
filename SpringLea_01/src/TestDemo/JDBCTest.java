import com.spring.demo.UserServiceImp;
import com.spring.jdbc.demo1.JdbcDemo1;
import com.spring.jdbc.demo1.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTest {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test1()
    {
        JdbcDemo1 jdbcDemo1=new JdbcDemo1();
        jdbcDemo1.demo1();
    }

    @Test
    public void test2()
    {
        jdbcTemplate.update("insert into account values (null ,?,?)","qiuqiu",20000);

    }

    @Test
    public void test3()
    {
        jdbcTemplate.update("update account set name = ? ,money= ? where id=?","qqq",2000,1);

    }

    @Test
    //查询
    public void test4()
    {
        String name=jdbcTemplate.queryForObject("select name from account where id= ?",String.class,2);
        System.out.println(name);
    }
    @Test
    //封装到对象中
    public void test5()
    {
        Account account=jdbcTemplate.queryForObject("select * from account where id=?",new MyRowMapper(),4);
        System.out.println(account);

    }

    @Test
    //查询多条记录
    public void test6()
    {
        List<Account> list=jdbcTemplate.query("select * from account",new MyRowMapper());
        for (Account account:list)
        {
            String a=new String("asd");
            String b=new String ("asd");
            if(a.equals(b))
            {
                System.out.println(account);
            }

        }

    }


    class MyRowMapper implements RowMapper<Account>
    {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account=new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getDouble("money"));
            return account;
        }
    }




}
