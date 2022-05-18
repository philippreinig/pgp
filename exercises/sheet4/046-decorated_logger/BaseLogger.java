public class BaseLogger implements Logger{
    private LogLevel logLevel;

    public BaseLogger (LogLevel logLevel){
        this.setLogLevel(logLevel);
    }

    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void log(LogLevel level, String format, Object... args) {
        if (level.ordinal() >= this.logLevel.ordinal()){
            if (LogLevel.Error == level) System.err.println(String.format(format, args));
            else System.out.println(String.format(format, args));
        }
    }

}
