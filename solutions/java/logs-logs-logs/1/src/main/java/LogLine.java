public class LogLine {
    private String logLevel;
    private String logMessage;
    public LogLine(String logLine) {
        String[] parts = logLine.split(":",2);
        this.logLevel = parts[0];
        this.logMessage = parts[1].trim();
    }

    public LogLevel getLogLevel() {
        return switch(this.logLevel){
            case "[TRC]" -> LogLevel.TRACE;
            case "[DBG]" -> LogLevel.DEBUG;
            case "[INF]" -> LogLevel.INFO;
            case "[WRN]" -> LogLevel.WARNING;
            case "[ERR]" -> LogLevel.ERROR;
            case "[FTL]" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    private int shortLevel() {
        return switch(this.logLevel){
            case "[TRC]" -> 1;
            case "[DBG]" -> 2;
            case "[INF]" -> 4;
            case "[WRN]" -> 5;
            case "[ERR]" -> 6;
            case "[FTL]" -> 42;
            default -> 0;
        };
    }
    
    public String getOutputForShortLog() {
        return this.shortLevel() + ":" + this.logMessage;
    }
}
