package com.stajokulu.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;

import java.beans.Introspector;

@Component
@SuppressWarnings({"unchecked"})
public final class ApplicationContextProvider implements ApplicationContextAware {

  private static final ApplicationContextProvider INSTANCE = new ApplicationContextProvider();
  private static ApplicationContext applicationContext;

  ApplicationContextProvider() {}

  public ApplicationContextProvider(ApplicationContext context) {
    this.setApplicationContext(context);
  }

  public static ApplicationContextProvider getInstance() {
    return INSTANCE;
  }

  @Override
  public void setApplicationContext(ApplicationContext appContext) throws BeansException {
    applicationContext = appContext;
  }

  public <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(Introspector.decapitalize(clazz.getSimpleName()), clazz);
  }
}
