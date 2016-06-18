package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 18/06/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CalcTest {
    @Autowired
    private Calc calc;


    @Test
    @Rollback(false)
    public void testSum() throws Exception {
        Assert.assertEquals(5, calc.sum(2,3));
    }
    @Test
    public void testSum2() throws Exception {
        Assert.assertEquals(6, calc.sum(3,3));
    }
}