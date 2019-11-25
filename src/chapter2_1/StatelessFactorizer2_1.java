package chapter2_1;

import java.math.BigInteger;

import javax.servlet.*;

import annotations.ThreadSafe;

/**
 * ClassName: StatelessFactorizer2_1 <br/>
 * Function: 【2.1】程序清单 2-1 一个无状态 Servlet. <br/>
 * date: 2019年10月9日 上午11:09:27 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@ThreadSafe
public class StatelessFactorizer2_1 extends GenericServlet implements Servlet {
	private static final long serialVersionUID = -9105056070089391401L;
	
	/**
	 * 无状态对象一定是线程安全的。
	 * 		StatelessFactorizer 是无状态的：它既不包含任何域，也不包含任何对其它类中域的引用。
	 * 		计算过程中的临时状态仅存在于线程栈上的局部变量中，并且只能由正在执行的线程访问。
	 * 		访问 StatelessFactorizer 的线程不会影响另一个访问同一个 StatelessFactorizer 的线程的计算结果，
	 * 		因为这两个线程并没有共享状态，就好像它们都在访问不同的实例。
	 */

	public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
}
