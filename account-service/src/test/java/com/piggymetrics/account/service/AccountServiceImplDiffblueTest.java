package com.piggymetrics.account.service;

import com.piggymetrics.account.client.AuthServiceClient;
import com.piggymetrics.account.client.StatisticsServiceClient;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.repository.AccountRepository;

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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AccountServiceImplDiffblueTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @MockBean
    private AuthServiceClient authServiceClient;

    @MockBean
    private StatisticsServiceClient statisticsServiceClient;

    /**
     * Test {@link AccountServiceImpl#findByName(String)}.
     * <p>
     * Method under test: {@link AccountServiceImpl#findByName(String)}
     */
    @Test
    @DisplayName("Test findByName(String)")
    @Disabled("TODO: Complete this test")
    void testFindByName() {
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
        accountServiceImpl.findByName("Smith");
    }

    /**
     * Test {@link AccountServiceImpl#create(User)}.
     * <p>
     * Method under test: {@link AccountServiceImpl#create(User)}
     */
    @Test
    @DisplayName("Test create(User)")
    @Disabled("TODO: Complete this test")
    void testCreate() {
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
        User user = new User();
        user.setPassword("abc");
        user.setUsername("Smith");

        // Act
        accountServiceImpl.create(user);
    }

    /**
     * Test {@link AccountServiceImpl#saveChanges(String, Account)}.
     * <p>
     * Method under test: {@link AccountServiceImpl#saveChanges(String, Account)}
     */
    @Test
    @DisplayName("Test saveChanges(String, Account)")
    @Disabled("TODO: Complete this test")
    void testSaveChanges() {
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

        Account update = new Account();
        update.setExpenses(new ArrayList<>());
        update.setIncomes(new ArrayList<>());
        update.setLastSeen(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        update.setName("Smith");
        update.setNote("Note");
        update.setSaving(saving);

        // Act
        accountServiceImpl.saveChanges("Smith", update);
    }
}
