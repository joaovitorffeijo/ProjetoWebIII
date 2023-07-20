package com.projetoweb3.projeto;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link ProjetoWeb3Application}.
 */
public class ProjetoWeb3Application__BeanDefinitions {
  /**
   * Get the bean definition for 'projetoWeb3Application'.
   */
  public static BeanDefinition getProjetoWebApplicationBeanDefinition() {
    Class<?> beanType = ProjetoWeb3Application.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    ConfigurationClassUtils.initializeConfigurationClass(ProjetoWeb3Application.class);
    beanDefinition.setInstanceSupplier(ProjetoWeb3Application$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
