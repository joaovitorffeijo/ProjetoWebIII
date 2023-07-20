package com.projetoweb3.projeto.controller;

import com.projetoweb3.projeto.service.ChatGPTService;
import com.projetoweb3.projeto.service.SpotifyService;
import java.lang.Class;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ApiMashupController}.
 */
public class ApiMashupController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'apiMashupController'.
   */
  private static BeanInstanceSupplier<ApiMashupController> getApiMashupControllerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ApiMashupController>forConstructor(ChatGPTService.class, SpotifyService.class)
            .withGenerator((registeredBean, args) -> new ApiMashupController(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'apiMashupController'.
   */
  public static BeanDefinition getApiMashupControllerBeanDefinition() {
    Class<?> beanType = ApiMashupController.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getApiMashupControllerInstanceSupplier());
    return beanDefinition;
  }
}
