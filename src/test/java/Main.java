import com.netherbyte.nbl4j.Logger;
import com.netherbyte.nbl4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        method2();
    }
    public static void method2() {
        logger.debug(1);
        logger.info(2);
        logger.warn(3);
        logger.error(4);
        logger.trace(5);
    }
}
