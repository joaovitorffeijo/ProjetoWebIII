package com.projetoweb3.projeto.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpotifyService}.
 */
public class SpotifyService__BeanDefinitions {
  /**
   * Get the bean definition for 'spotifyService'.
   */
  public static BeanDefinition getSpotifyServiceBeanDefinition() {
    Class<?> beanType = SpotifyService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<SpotifyService> instanceSupplier = InstanceSupplier.using(SpotifyService::new);
    instanceSupplier = instanceSupplier.andThen(SpotifyService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
