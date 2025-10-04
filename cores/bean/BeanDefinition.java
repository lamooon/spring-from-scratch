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
    public BeanDefinition(Class<?> beanClass) {
        this.name = UUID.randomUUID().toString();
        this.beanClass = beanClass;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}