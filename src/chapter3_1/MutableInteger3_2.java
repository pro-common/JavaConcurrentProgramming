package chapter3_1;

import annotations.NotThreadSafe;

/**
 * ClassName: MutableInteger3_2 <br/>
 * Function: 【3.1】程序清单 3-2 非线程安全的可变整数类. <br/>
 * date: 2019年10月14日 下午3:41:24 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@NotThreadSafe
public class MutableInteger3_2 {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}








