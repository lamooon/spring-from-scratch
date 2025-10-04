/**
 * Minimal Spring Bean Factory Objective:
 * 1. Save the instantiated Bean Definition in-memory
 * 2. Return the instance when asked
 */

class BeanFactory {
    private Map<String, BeanDefinition> beanFactory = new HashMap<>();
    public BeanFactory() {

    }

    // Getters and Setters
    public Map<String, BeanDefinition> getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(Map<String, BeanDefinition> beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * Creates a metadata.
     * - If there is a duplicated name, throw ConflictingBeanDefinitionException
     */
    public void create(BeanDefinition bean) {
        String name = bean.getName();
        if (beanFactory.contains(bean.name)) {
            System.err.println("Bean name already exists. Choose different one.");
                return;
        }

        beanFactory.put(name, bean);
    }

    /**
     * Look up BeanDefinition from registry
     */
    public BeanDefinition get(String name) {
        return beanFactory.get(name);
    }
}