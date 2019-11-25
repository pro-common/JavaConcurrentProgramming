package chapter1_3_1;

import annotations.NotThreadSafe;

/**
 * ClassName: UnsafeSequence_1_1 <br/>
 * Function: 【1.3.1】程序清单 1-1 非线程安全的数值序列生成器. <br/>
 * date: 2019年9月30日 上午11:19:24 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@NotThreadSafe
public class UnsafeSequence_1_1 {
    private int value;

    public int getNext() {
        return value++;
    }
    
}
