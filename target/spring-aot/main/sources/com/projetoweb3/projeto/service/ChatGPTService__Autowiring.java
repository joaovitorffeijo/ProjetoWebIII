package com.projetoweb3.projeto.service;

import java.lang.String;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChatGPTService}.
 */
public class ChatGPTService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChatGPTService apply(RegisteredBean registeredBean, ChatGPTService instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setApiKey", String.class).resolve(registeredBean, args -> instance.setApiKey(args.get(0)));
    return instance;
  }
}
