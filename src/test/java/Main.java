import com.netherbyte.nbl4j.Channel;
import com.netherbyte.nbl4j.Logger;
import com.netherbyte.nbl4j.Loggers;

public class Main {
    private static final Logger logger = Loggers.get("Test");
    public static void main(String[] args) {
        method2();
    }
    public static void method2() {
        logger.trace("Test!", Channel.ERROR);
    }
}
