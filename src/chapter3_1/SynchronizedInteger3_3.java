package chapter3_1;

import annotations.GuardedBy;
import annotations.ThreadSafe;

/**
 * ClassName: MutableInteger3_2 <br/>
 * Function: 【3.1】程序清单 3-3 线程安全的可变整数类. <br/>
 * date: 2019年10月14日 下午3:41:24 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@ThreadSafe
public class SynchronizedInteger3_3 {
    @GuardedBy("this") private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
