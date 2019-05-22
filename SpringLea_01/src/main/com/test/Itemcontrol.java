package com.test;

import com.spring.demo.userDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Itemcontrol {

    @RequestMapping(value = "/itemlist.action")
    public ModelAndView itemList()
    {
        //测试
        /*ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        userDAO userDAO= (userDAO) app.getBean("userDAO");
        userDAO.save();*/


        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/itemList.jsp");
        return mav;
    }

}
