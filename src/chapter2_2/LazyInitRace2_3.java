package chapter2_2;

import annotations.NotThreadSafe;

/**
 * ClassName: LazyInitRace2_3 <br/>
 * Function: 【2.2】程序清单 2-3 延迟初始化中的竞态条件（不要这么做）. <br/>
 * date: 2019年10月9日 下午3:23:51 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
@NotThreadSafe
public class LazyInitRace2_3 {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}

class ExpensiveObject { }

