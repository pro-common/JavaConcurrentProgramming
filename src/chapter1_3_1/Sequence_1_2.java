package chapter1_3_1;

import annotations.GuardedBy;
import annotations.ThreadSafe;

/**
 * ClassName: Sequence_1_2 <br/>
 * Function: 【1.3.1】程序清单 1-2 线程安全的数值序列生成器. <br/>
 * date: 2019年9月30日 上午11:32:23 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@ThreadSafe
public class Sequence_1_2 {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
    
}
