package com.ruida.springbootdemo.utils;

import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author Chen.J.Y
 * @date 2021/4/22
 */
@Component
public final class SnowflakeUtil {

    private static SnowflakeUtil snowflakeUtil;

    @Value("${myApp.system.snowflake.workerId}")
    private void setWorkerId(int workerId) {
        Preconditions.checkArgument(workerId >= 0L && workerId < WORKER_ID_MAX_VALUE);
        SnowflakeUtil.snowflakeUtil = new SnowflakeUtil(workerId);
    }

    // 暴露一个公共方法，获取雪花id
    public static long nextId() {
        return snowflakeUtil.generateKey();
    }

    // 基数 从2020-01-01 00:00:00.000开始计算
    private static final long EPOCH;

    // 毫秒级序列位 12位 最大可生成4096个数字
    private static final long SEQUENCE_BITS = 12L;
    // 机器识别码 10位 可取值0-1023
    private static final long WORKER_ID_BITS = 10L;
    // 计算掩码 4095，用于快速计算生成的毫秒级序列位是否已达到最大限制
    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;
    // 机器识别位 在二进制层面 左移位数
    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;
    // 时间戳位 在二进制层面 左移位数
    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

    // 机器识别码最大位数
    private static final long WORKER_ID_MAX_VALUE = 1 << WORKER_ID_BITS;

    // 可允许的服务器时钟回退毫秒数，如果需要，可调整此参数
    private static final long MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS = 60_000;

    // 服务器id，每台服务器应不重复
    private long workId = 0;
    // 当前毫秒数的自增序列
    private long sequence;
    // 上一次生成id的毫秒数
    private long lastMilliseconds;
    // 在每个新的毫秒时，动态变更成0/1为了在低并发时，生成的id能够均匀分布单双数
    private byte sequenceOffset;

    // 初始化开始时间
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }

    /**
     * 处理构造函数
     */
    public SnowflakeUtil() {
    }

    public SnowflakeUtil(int workerId) {
        Preconditions.checkArgument(workerId >= 0L && workerId < WORKER_ID_MAX_VALUE);
        this.workId = workerId;
    }

    /**
     * 获取雪花id
     */
    private synchronized long generateKey() {
        long currentMilliseconds = System.currentTimeMillis();
        if (waitTolerateTimeDifferenceIfNeed(currentMilliseconds)) currentMilliseconds = System.currentTimeMillis();
        if (lastMilliseconds == currentMilliseconds) {
            if (0L == (sequence = (sequence + 1) & SEQUENCE_MASK)) {
                currentMilliseconds = waitUntilNextTime(lastMilliseconds);
            }
        } else {
            vibrateSequenceOffset();
            sequence = sequenceOffset;
        }
        lastMilliseconds = currentMilliseconds;
        return ((currentMilliseconds - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }

    @SneakyThrows
    private boolean waitTolerateTimeDifferenceIfNeed(final long currentMilliseconds) {
        if (lastMilliseconds <= currentMilliseconds) return false;
        long timeDifferenceMilliseconds = lastMilliseconds - currentMilliseconds;
        Preconditions.checkState(timeDifferenceMilliseconds < MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS,
                "服务器时间被回拨了，上次生成id的时间 %d，当前时间 %d", lastMilliseconds, currentMilliseconds);
        Thread.sleep(currentMilliseconds);
        return true;
    }

    /**
     * 休眠至下一毫秒
     */
    private long waitUntilNextTime(final long lastMilliseconds) {
        long now = System.currentTimeMillis();
        while (now < lastMilliseconds) {
            now = System.currentTimeMillis();
        }
        return now;
    }

    private void vibrateSequenceOffset() {
        sequenceOffset = (byte) (~sequenceOffset & 1);
    }
}