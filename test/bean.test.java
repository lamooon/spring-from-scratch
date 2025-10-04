package com.example.bean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Import your main classes
import com.example.BeanDefinition;
import com.example.BeanFactory;

/**
 * Tests the core functionality of the minimal BeanFactory and BeanDefinition.
 */
public class BeanFactoryTest {

    private BeanFactory factory;

    // Runs before every test
    @BeforeEach
    void setUp() {
        factory = new BeanFactory();
    }

    @Test
    @DisplayName("Registers and retrieves a single BeanDefinition successfully")
    void testRegisterAndRetrieveBean() {
        BeanDefinition bean = new BeanDefinition(String.class);

        factory.create(bean);
        BeanDefinition result = factory.get(bean.getName());

        assertNotNull(result, "Expected BeanDefinition to be found in factory");
        assertEquals(bean, result, "Expected the registered BeanDefinition to match");
    }

    @Test
    @DisplayName("Rejects duplicate BeanDefinition names")
    void testDuplicateBeanRegistration() {
        BeanDefinition bean1 = new BeanDefinition(String.class);
        BeanDefinition bean2 = new BeanDefinition(Integer.class);

        // Force same name to simulate duplication
        bean2.setName(bean1.getName());

        factory.create(bean1);
        factory.create(bean2); // Should trigger duplicate check and skip registration

        int count = factory.getBeanFactory().size();
        assertEquals(1, count, "Factory should contain only one unique bean after duplicates");
    }

    @Test
    @DisplayName("Returns null for non-existent beans")
    void testLookupNonExistentBean() {
        BeanDefinition result = factory.get("does-not-exist");
        assertNull(result, "Expected null when no BeanDefinition is found");
    }
}