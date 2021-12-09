package behavior.chainOfResponsibility;

abstract class Logger {
    private Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void sendMessage(String message) {
        if (!canWrite(message)) {
            return;
        }
        if (nextLogger != null) {
            nextLogger.sendMessage(message);
        }
    }

    abstract boolean canWrite(String message);
}

class ErrorLogger extends Logger {
    @Override
    boolean canWrite(String message) {
        System.out.println("errorLogger: " + message);
        if (message.equals("error")) {
            return false;
        }
        return true;
    }
}

class InfoLogger extends Logger {
    @Override
    boolean canWrite(String message) {
        System.out.println("infoLogger: " + message);
        if (message.equals("info")) {
            return false;
        }
        return true;
    }
}

public class Main {
    public static Logger getLoggerChain() {
        Logger errLogger = new ErrorLogger();
        Logger infoLogger = new InfoLogger();
        infoLogger.setNextLogger(errLogger);

        return infoLogger;
    }
    public static void main(String[] args) {
        Logger loggerChain = getLoggerChain();

        loggerChain.sendMessage("error");
    }
}