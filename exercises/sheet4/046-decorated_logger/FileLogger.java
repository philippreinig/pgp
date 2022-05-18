import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileLogger extends LoggerDecorator{

    private PrintWriter printWriter;

    public FileLogger(Logger logger, String logFilePath){
        super(logger);
        try {
            this.printWriter = new PrintWriter(logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void log(LogLevel level, String format, Object... args){
        this.logger.log(level, format, args);
        if(this.logLevel.ordinal() >= level.ordinal()){
            this.printWriter.println(level.name() + ": " + String.format(format, args));
            this.printWriter.flush();
        }
    }
}
