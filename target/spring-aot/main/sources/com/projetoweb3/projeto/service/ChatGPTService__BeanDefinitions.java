package com.projetoweb3.projeto.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatGPTService}.
 */
public class ChatGPTService__BeanDefinitions {
  /**
   * Get the bean definition for 'chatGPTService'.
   */
  public static BeanDefinition getChatGPTServiceBeanDefinition() {
    Class<?> beanType = ChatGPTService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<ChatGPTService> instanceSupplier = InstanceSupplier.using(ChatGPTService::new);
    instanceSupplier = instanceSupplier.andThen(ChatGPTService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
