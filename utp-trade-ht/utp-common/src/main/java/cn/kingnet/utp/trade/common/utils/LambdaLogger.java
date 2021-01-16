package cn.kingnet.utp.trade.common.utils;

import org.slf4j.Logger;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * debug 输出日志，方便开发且不影响系统生产运行性能
 *
 * @author zhongli
 * @date 2018/10/17
 */
public class LambdaLogger {
    public static void debug(Logger log, String format, Supplier<?>... argSuppliers) {
        if (!log.isDebugEnabled()) {
            return;
        }
        if (argSuppliers == null) {
            log.debug(format);
            return;
        }

        Object[] args = new Object[argSuppliers.length];
        for (int i = 0; i < argSuppliers.length; i++) {
            args[i] = argSuppliers[i].get();
        }
        log.debug(format, args);
    }

    public static void debug(Logger log, Consumer<Logger> consumer) {
        if (!log.isDebugEnabled()) {
            return;
        }
        consumer.accept(log);
    }

    public static void debug(Logger log, String format, Object... args) {
        if (!log.isDebugEnabled()) {
            return;
        }
        if (args == null) {
            log.debug(format);
            return;
        }
        log.debug(format, args);
    }

    public static void info(Logger log, String format, Supplier<?>... argSuppliers) {
        if (!log.isInfoEnabled()) {
            return;
        }
        if (argSuppliers == null) {
            log.info(format);
            return;
        }

        Object[] args = new Object[argSuppliers.length];
        for (int i = 0; i < argSuppliers.length; i++) {
            args[i] = argSuppliers[i].get();
        }
        log.info(format, args);
    }

    public static void info(Logger log, String format, Object... args) {
        if (!log.isInfoEnabled()) {
            return;
        }
        if (args == null) {
            log.info(format);
            return;
        }
        log.info(format, args);
    }

    public static void info(Logger log, Consumer<Logger> consumer) {
        if (!log.isInfoEnabled()) {
            return;
        }
        consumer.accept(log);
    }

    public static void warn(Logger log, String format, Object... args) {
        if (!log.isWarnEnabled()) {
            return;
        }
        if (args == null) {
            log.warn(format);
            return;
        }
        log.warn(format, args);
    }

    public static void warn(Logger log, Consumer<Logger> consumer) {
        if (!log.isWarnEnabled()) {
            return;
        }
        consumer.accept(log);
    }
    public static void warn(Logger log, String format, Supplier<?>... argSuppliers) {
        if (!log.isWarnEnabled()) {
            return;
        }
        if (argSuppliers == null) {
            log.warn(format);
            return;
        }

        Object[] args = new Object[argSuppliers.length];
        for (int i = 0; i < argSuppliers.length; i++) {
            args[i] = argSuppliers[i].get();
        }
        log.warn(format, args);
    }

    public static void error(Logger log, String format, Object... args) {
        if (!log.isErrorEnabled()) {
            return;
        }
        if (args == null) {
            log.error(format);
            return;
        }
        log.error(format, args);
    }

    public static void error(Logger log, String format, Supplier<?>... argSuppliers) {
        if (!log.isErrorEnabled()) {
            return;
        }
        if (argSuppliers == null) {
            log.error(format);
            return;
        }

        Object[] args = new Object[argSuppliers.length];
        for (int i = 0; i < argSuppliers.length; i++) {
            args[i] = argSuppliers[i].get();
        }
        log.error(format, args);
    }

    public static void error(Logger log, Consumer<Logger> consumer) {
        if (!log.isErrorEnabled()) {
            return;
        }
        consumer.accept(log);
    }
}
