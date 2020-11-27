package sw.personal.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sw.personal.datasourceconfig.DataSourceType;

@Aspect
@Component
public class DataSourceAop {
    private static final Logger log = LoggerFactory.getLogger(DataSourceAop.class);

    @Before( "execution(* sw.personal.service.primary..*.*(..))")
    public void setDataSource2test01() {
        log.info("primary");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA01);
    }

    @Before("execution(* sw.personal.service.second..*.*(..))")
    public void setDataSource2test02() {
        log.info("second");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA02);
    }
}
