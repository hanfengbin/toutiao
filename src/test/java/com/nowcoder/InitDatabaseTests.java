package com.nowcoder;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nowcoder.dao.*;
import com.nowcoder.model.*;
import com.nowcoder.service.CommentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
//@Sql("/init-schema.sql")
public class InitDatabaseTests {
    @Autowired
    UserDAO userDAO;

    @Autowired
    NewsDAO newsDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;

    @Autowired
    CommentDAO commentDAO;
    @Autowired
    MessageDAO messageDAO;

    @Test
    public void initData() {

        for (int i = 0; i < 50; ++i) {
            Message message=new Message();
            message.setFromId(14);
            message.setToId(i);
            message.setContent(String.format("hello_%d",i));
            message.setHasRead(0);
            message.setCreatedDate(new Date());
            message.setConversationId(String.format("14_%d",i));
            messageDAO.addMessage(message);
        }
    }

}
