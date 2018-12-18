package test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
//如果ContextConfiguration文件不对，会Failed to load ApplicationContext
public class Test2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    @Test
    public void m() {
        LOGGER.info("Hello words！");
    }
}