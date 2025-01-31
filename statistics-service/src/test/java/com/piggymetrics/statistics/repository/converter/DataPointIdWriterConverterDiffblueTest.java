package com.piggymetrics.statistics.repository.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.mongodb.DBObject;
import com.piggymetrics.statistics.domain.timeseries.DataPointId;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DataPointIdWriterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataPointIdWriterConverterDiffblueTest {
    @Autowired
    private DataPointIdWriterConverter dataPointIdWriterConverter;

    /**
     * Test {@link DataPointIdWriterConverter#convert(DataPointId)} with
     * {@code DataPointId}.
     * <p>
     * Method under test: {@link DataPointIdWriterConverter#convert(DataPointId)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testConvertWithDataPointId() {
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
        dataPointIdWriterConverter.convert(
                new DataPointId("3", Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
    }

    /**
     * Test {@link DataPointIdWriterConverter#convert(DataPointId)} with
     * {@code DataPointId}.
     * <ul>
     *   <li>Then return {@link Map}.</li>
     * </ul>
     * <p>
     * Method under test: {@link DataPointIdWriterConverter#convert(DataPointId)}
     */
    @Test
    public void testConvertWithDataPointId_thenReturnMap() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
        //   Run dcover create --keep-partial-tests to gain insights into why
        //   a non-Spring test was created.

        // Arrange
        DataPointIdWriterConverter dataPointIdWriterConverter = new DataPointIdWriterConverter();
        Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

        // Act
        DBObject actualConvertResult = dataPointIdWriterConverter.convert(new DataPointId("3", date));

        // Assert
        assertTrue(actualConvertResult instanceof Map);
        assertEquals(2, ((Map<String, Object>) actualConvertResult).size());
        assertEquals("3", ((Map<String, Object>) actualConvertResult).get("account"));
        assertSame(date, ((Map<String, Object>) actualConvertResult).get("date"));
    }
}
