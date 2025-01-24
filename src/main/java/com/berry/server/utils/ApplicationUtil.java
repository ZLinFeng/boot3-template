package com.berry.server.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zlinfo
 */
public class ApplicationUtil implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static ApplicationContext context;

    private static ConfigurableEnvironment environment;

    public static String getProperty(String key) {
        return environment.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

    public static <T> T getProperty(String key, Class<T> targetType) {
        return environment.getProperty(key, targetType);
    }

    public static <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return environment.getProperty(key, targetType, defaultValue);
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return context.getBean(requiredType);
    }

    public static <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
        return context.getBean(requiredType, args);
    }

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return context.getBean(name, requiredType);
    }

    public static Object getBean(String name, Object... args) throws BeansException {
        return context.getBean(name, args);
    }

    public static boolean containsBean(String name) throws BeansException {
        return context.containsBean(name);
    }

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        context = configurableApplicationContext;
        environment = configurableApplicationContext.getEnvironment();
    }
}
