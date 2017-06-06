package com.restful;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Admin on 2017/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Test
    public void testHi() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/hi");
        List list = target.request(MediaType.APPLICATION_JSON).get(List.class);
        Assert.assertNotNull(list);
        Assert.assertEquals("hello spring boot", list.get(0));
    }
}
