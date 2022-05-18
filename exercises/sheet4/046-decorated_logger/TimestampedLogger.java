import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class TimestampedLogger extends LoggerDecorator {

    public TimestampedLogger(Logger logger){
        super(logger);
    }

    @Override
    public void log(LogLevel level, String format, Object... args){
        Object[] newVarArgs = new Object[args.length + 1];
        System.arraycopy(args, 0, newVarArgs, 1, args.length);
        newVarArgs[0] = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.logger.log(level, "%s " + format, newVarArgs);
    }
}
