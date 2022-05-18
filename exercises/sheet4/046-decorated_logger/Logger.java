
public interface Logger {
    default void trace(String format, Object... args) {
        this.log(LogLevel.Trace, format, args);
    }
    default void debug(String format, Object... args) {
        this.log(LogLevel.Debug, format, args);
    }
    default void info(String format, Object... args) {
        this.log(LogLevel.Info, format, args);
    }
    default void warn(String format, Object... args) {
        this.log(LogLevel.Warn, format, args);
    }
    default void error(String format, Object... args) {
        this.log(LogLevel.Error, format, args);
    }

    void setLogLevel(LogLevel level);
    void log(LogLevel level, String format, Object... args);
}