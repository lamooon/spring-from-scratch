package cores.bean;
/**
 * Minimal Spring BeanDefinition Objective:
 * 1. Instantiate the metadata
 * 2. Call BeanFactory to Save / Retrieve it
 */
import java.util.UUID;

public class BeanDefinition {
    private String name;
    private Class<?> beanClass;

    // Constructor
    public BeanDefinition(String name, Class<?> beanClass) {
        this.name = name;
        this.beanClass = beanClass;
    }
    public BeanDefinition(Class<?> beanClass) {
        this.name = generateName(beanClass);
        this.beanClass = beanClass;
    }

    // Getters
    public String getName() {
        return name;
    }

    private String generateName(Class<?> beanClass) {
        String className = beanClass.getName();
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }
}