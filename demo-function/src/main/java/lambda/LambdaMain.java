package lambda;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaMain {
    private static final Log log = LogFactory.getLog(LambdaMain.class);
    public static void main(String[] args) {
        log.info(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
    }
}
