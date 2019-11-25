package chapter2_2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import annotations.ThreadSafe;

/**
 * ClassName: CountingFactorizer2_4 <br/>
 * Function: 【2.2】程序清单 2-4 使用 AtomicLong 类型的变量来统计已处理请求的数量. <br/>
 * date: 2019年10月9日 下午3:38:11 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@ThreadSafe
public class CountingFactorizer2_4 extends GenericServlet implements Servlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() { return count.get(); }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {}
    BigInteger extractFromRequest(ServletRequest req) {return null; }
    BigInteger[] factor(BigInteger i) { return null; }
}
