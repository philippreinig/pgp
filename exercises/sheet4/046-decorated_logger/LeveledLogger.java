public class LeveledLogger extends LoggerDecorator {

    public LeveledLogger (Logger logger){
        super(logger);
    }

    @Override
    public void log(LogLevel level, String format, Object... args){
        Object[] newVarArgs = new Object[args.length + 1];
        System.arraycopy(args, 0, newVarArgs, 1, args.length);
        newVarArgs[0] = "[" + level.name() + "]";
        this.logger.log(level, "%s " + format, newVarArgs);
    }
}
