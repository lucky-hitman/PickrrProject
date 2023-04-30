import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Sample {
    private static final Logger logger
            = LoggerFactory.getLogger(Sample.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", Sample.class);
    }
}
