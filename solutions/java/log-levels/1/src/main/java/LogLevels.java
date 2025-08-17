public class LogLevels {
    
    public static String message(String logLine) {
        String[] parts = logLine.split(":");
        return parts[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] parts = logLine.split(":");
        return switch(parts[0]){
            case "[INFO]" -> "info";
            case "[WARNING]" -> "warning";
            case "[ERROR]" -> "error";
            default -> "we really should have error handling here...";            
        };
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)",message(logLine),logLevel(logLine));
    }
}
