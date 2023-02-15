package xyz.zlflearn.wisdom.common;

/**
 * @author zhengLongfei
 * @date 2023-02-14-20:26
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    /**
     * 设置值
     * @param id
     */
    public static void set(Long id){
        threadLocal.set(id);
    }
    /**
     * 获取值
     * @return
     * */
    public static Long get(){
        return threadLocal.get();
    }
}
