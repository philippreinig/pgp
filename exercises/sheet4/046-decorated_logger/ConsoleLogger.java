public class ConsoleLogger extends LoggerDecorator{
    public ConsoleLogger(Logger logger){
        super(logger);
    }

    @Override
    public void log(LogLevel level, String format, Object... args){
        this.logger.log(level, format, args);
    }
}
