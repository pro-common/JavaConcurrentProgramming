package chapter3_1;

/**
 * ClassName: NoVisibility3_1 <br/>
 * Function: 【3.1】程序清单 3-1 在没有同步的情况下共享变量（不要这么做）. <br/>
 * date: 2019年10月14日 下午3:22:59 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
public class NoVisibility3_1 {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
