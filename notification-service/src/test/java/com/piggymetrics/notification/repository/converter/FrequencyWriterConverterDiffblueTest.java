package com.piggymetrics.notification.repository.converter;

import static org.junit.Assert.assertEquals;

import com.piggymetrics.notification.domain.Frequency;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FrequencyWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FrequencyWriterConverterDiffblueTest {
    @Autowired
    private FrequencyWriterConverter frequencyWriterConverter;

    /**
     * Test {@link FrequencyWriterConverter#convert(Frequency)} with
     * {@code Frequency}.
     * <p>
     * Method under test: {@link FrequencyWriterConverter#convert(Frequency)}
     */
    @Test
    public void testConvertWithFrequency() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange, Act and Assert
        assertEquals(7, (new FrequencyWriterConverter()).convert(Frequency.WEEKLY).intValue());
    }

    /**
     * Test {@link FrequencyWriterConverter#convert(Frequency)} with
     * {@code Frequency}.
     * <p>
     * Method under test: {@link FrequencyWriterConverter#convert(Frequency)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConvertWithFrequency2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/core/NestedIOException
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
        //   java.lang.NoClassDefFoundError: org/springframework/core/NestedIOException
        //       at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:309)
        //       at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:233)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:273)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:93)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:187)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:119)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:127)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
        //   java.lang.ClassNotFoundException: org.springframework.core.NestedIOException
        //       at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:309)
        //       at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:233)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:273)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:93)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:187)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:119)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:127)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:212)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1709)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:556)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:546)
        //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:702)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        frequencyWriterConverter.convert(Frequency.WEEKLY);
    }
}
