package common.test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rxliuli by 2018/5/23 1:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public abstract class BaseTest {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 设置单个测试的最大超时时间
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(30);

    /**
     * 设置抛出异常
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();
}
