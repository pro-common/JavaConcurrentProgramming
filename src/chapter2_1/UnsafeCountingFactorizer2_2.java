package chapter2_1;

import java.math.BigInteger;
import javax.servlet.*;

import annotations.NotThreadSafe;

/**
 * ClassName: UnsafeCountingFactorizer2_2 <br/>
 * Function: 【2.1】程序清单 2-2 在没有同步的情况下统计已处理请求数量的 Servlet. <br/>
 * date: 2019年10月9日 上午11:26:57 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@NotThreadSafe
public class UnsafeCountingFactorizer2_2 extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 8598604251218270381L;
	
	/**
	 * 不幸的是，UnsafeCountingFactorizer 并非线程安全的，尽管它在单线程环境中能正确运行。
	 * 与前面 UnsafeSequence 一样，这个类很可能会丢失一些更新操作。
	 * 虽然递增操作 ++count 是一种紧凑的语法，但这只是一种操作，并非是原子操作，因而它并不会作为一个不可分割的操作来执行。
	 * 实际上，这里包含了三个独立的操作：读取 count 值，将值加 1 ，然后将计算结果写入 count 。
	 * 这是一个 “读取 - 修改 - 写入” 的操作序列，并且其结果状态依赖于之前的状态。
	 */
	
	private long count = 0;

    public long getCount() {
        return count;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
}
