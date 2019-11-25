package chapter2_3;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import annotations.NotThreadSafe;

/**
 * ClassName: UnsafeCachingFactorizer2_5 <br/>
 * Function: 【2.3】程序清单 2-5 该 Servlet 在没有足够原子性保证的情况下对其最近计算结果进行缓存（不要这么做）. <br/>
 * date: 2019年10月9日 下午4:03:48 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@NotThreadSafe
public class UnsafeCachingFactorizer2_5 extends GenericServlet implements Servlet {
	private static final long serialVersionUID = -7152653680919679003L;
	
	/**
	 * 这种方法并不正确，尽管这些原子引用本身都是线程安全的，但在 UnsafeCachingFartorizer 中存在着竞态条件，这可能产生错误的结果。
	 * 当在不变性条件中涉及多个变量时，各个变量之间并不是彼此独立的，而是某个变量的值会对其他变量的值产生约束。
	 * 因此，当更新某一个变量时，需要在同一个原子操作中对其它变量同时进行更新。
	 */
	
	private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<BigInteger[]>();

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get()))
            encodeIntoResponse(resp, lastFactors.get());
        else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(resp, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}

