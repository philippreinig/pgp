public class LoggerDecorator implements Logger{
    protected Logger logger;

    protected LogLevel logLevel = LogLevel.Warn;

    public LoggerDecorator(Logger logger){
        this.logger = logger;
    }

    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        this.logger.log(level, format, args);
    }
}
