public class LoggingTests {
    public static void main(String[] args){
        LogLevel level = LogLevel.Warn;

        BaseLogger baseLogger = new BaseLogger(level);
        ConsoleLogger consoleLogger = new ConsoleLogger(baseLogger);
        Logger fileLogger = new TimestampedLogger(new LeveledLogger(new FileLogger(baseLogger, "./testLogFile.log")));

        fileLogger.log(level, "%s", "test");

    }
}
