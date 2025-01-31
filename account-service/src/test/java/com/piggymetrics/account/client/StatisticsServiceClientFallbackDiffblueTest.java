package com.piggymetrics.account.client;

import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StatisticsServiceClientFallback.class})
@ExtendWith(SpringExtension.class)
class StatisticsServiceClientFallbackDiffblueTest {
    @Autowired
    private StatisticsServiceClientFallback statisticsServiceClientFallback;

    /**
     * Test
     * {@link StatisticsServiceClientFallback#updateStatistics(String, Account)}.
     * <p>
     * Method under test:
     * {@link StatisticsServiceClientFallback#updateStatistics(String, Account)}
     */
    @Test
    @DisplayName("Test updateStatistics(String, Account)")
    @Disabled("TODO: Complete this test")
    void testUpdateStatistics() {
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

        // Arrange
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal("2.6"));
        saving.setCapitalization(true);
        saving.setCurrency(Currency.USD);
        saving.setDeposit(true);
        saving.setInterest(new BigDecimal("2.6"));

        Account account = new Account();
        account.setExpenses(new ArrayList<>());
        account.setIncomes(new ArrayList<>());
        account.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        account.setName("Smith");
        account.setNote("Note");
        account.setSaving(saving);

        // Act
        statisticsServiceClientFallback.updateStatistics("Smith", account);
    }
}
