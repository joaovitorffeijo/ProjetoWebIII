package com.projetoweb3.projeto.service;

import java.lang.String;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SpotifyService}.
 */
public class SpotifyService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SpotifyService apply(RegisteredBean registeredBean, SpotifyService instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setAccessToken", String.class).resolve(registeredBean, args -> instance.setAccessToken(args.get(0)));
    return instance;
  }
}
