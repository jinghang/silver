package hang.silver.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Created by Vino on 16/5/7.
 * 订单生成规则:
 * 正常情况下:年(2位)+月(2位)+日(2位)+秒(5位)+循环自增值(3位)+随机码(2位)共16位
 * 非正常情况下:年(2位)+月(2位)+日(2位)+秒(5位)+随机码(5位)共16位
 * 注:非正常情况在同时开启1W个线程的情况下并未发生
 * 业务编码(1位)：自营、通用件、全车件待定
 */
public class OrderNumGen {
    //循环自增上限,超出则从初始值开始
    private static int maxLoop = 999;
    private static int initNum  = 100;
    private volatile static AtomicInteger atomicInteger;
    /**
     * author: Vino
     * date: 2016/5/8
     * function: DCL获取单例atomicInteger
     * @return
     */
    private static AtomicInteger getAtomicInteger() {
        if (atomicInteger == null) {
            synchronized (OrderNumGen.class) {
                if (atomicInteger == null)
                    atomicInteger = new AtomicInteger(initNum);//初始值为100
            }
        }
        return atomicInteger;
    }
    /**
     * author: Vino
     * date: 2016/5/8
     * function: 订单号生成
     * @return
     */
    public static Long next() {
        //获取单例
        AtomicInteger atomicInteger = getAtomicInteger();
        //原子性自增并返回自增前的值
        int nextValue = atomicInteger.getAndIncrement();
        //若循环次数已超过上限
        if (nextValue > maxLoop) {
            //CAS更新值成功
            if (atomicInteger.compareAndSet(nextValue + 1, initNum)) {
                atomicInteger.getAndIncrement();
                return getNextNormally(initNum);
            }
            else {//CAS更新值失败
                //重新获取
                nextValue = atomicInteger.getAndIncrement();
                if (nextValue <= maxLoop)
                    return getNextNormally(nextValue);
                else{//非正常情况下
                    return getNextUnNormally();
                }
            }
        }
        return getNextNormally(nextValue);
    }
    public static Long getNextNormally(int nextValue) {
        int randomNum=(int)(Math.random()*90)+10;//2位随机码
        return Long.valueOf(getDateNum()+nextValue+randomNum);
    }
    public static Long getNextUnNormally() {
        int randomNum = (int)(Math.random()*90000)+10000;//5位随机码
        return Long.valueOf(getDateNum()+randomNum);
    }
    /**
     * author: Vino
     * date: 2016/5/8
     * function: 获取订单号中的时间部分
     * @return
     */
    public static String getDateNum(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String sTime = simpleDateFormat.format(date);
        Integer nSecond = Integer.valueOf(sTime.substring(6,8)) * 60 * 60 +Integer.valueOf(sTime.substring(8,10)) * 60
                + Integer.valueOf(sTime.substring(10,12));
        String sSecond = String.valueOf(nSecond);
        if(sSecond.length() < 5){
            for(int i = 5,j = sSecond.length(); i > j; i--){
                sSecond = "0" + sSecond;
            }
        }
        return sTime.substring(0,6)+sSecond;
    }
}