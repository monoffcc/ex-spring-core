package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {
    @Test
    void filterScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        Assertions.assertThat(ac.getBean(BeanA.class)).isInstanceOf(BeanA.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean(BeanB.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes= MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes= MyExcludeComponent.class)
    )
    public static class ComponentFilterAppConfig{

    }
}
