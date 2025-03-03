package com.piggymetrics.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.domain.UserFactory;
import com.piggymetrics.account.service.AccountService;

import java.math.BigDecimal;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@ExtendWith(SpringExtension.class)
class AccountControllerDiffblueTest {
    @MockBean
    private AccountService accountService;

    @Autowired
    private AccountController accountController;

    /**
     * Test {@link AccountController#createNewAccount(User)}.
     * <p>
     * Method under test: {@link AccountController#createNewAccount(User)}
     */
    @Test
    @DisplayName("Test createNewAccount(User)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testCreateNewAccount() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   org.mockito.exceptions.base.MockitoException:
        //   Mockito cannot mock this class: interface com.piggymetrics.account.service.AccountService.
        //   Mockito can only mock non-private & non-final classes.
        //   If you're not sure why you're getting this error, please report to the mailing list.
        //   Java               : 17
        //   JVM vendor name    : Oracle Corporation
        //   JVM vendor version : 17.0.11+7-LTS-207
        //   JVM name           : Java HotSpot(TM) 64-Bit Server VM
        //   JVM version        : 17.0.11+7-LTS-207
        //   JVM info           : mixed mode, sharing
        //   OS name            : Windows 11
        //   OS version         : 10.0
        //   Underlying exception : java.lang.UnsupportedOperationException: Cannot define class using reflection
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.UnsupportedOperationException: Cannot define class using reflection
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Unavailable.defineClass(ClassInjector.java:821)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.inject(ClassInjector.java:185)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:187)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   com.diffblue.cover.sandbox.execution.ForbiddenByPolicyException: Sandboxing policy violation
        //       at java.base/java.lang.Class.forName0(Native Method)
        //       at java.base/java.lang.Class.forName(Class.java:375)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Indirect.make(ClassInjector.java:640)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:302)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:290)
        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:318)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.<clinit>(ClassInjector.java:70)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:184)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.mockito.Mockito.mock(Mockito.java:1768)
        //   com.diffblue.cover.exception.BaseException: Sandboxing policy violation
        //       at java.base/java.lang.Class.forName0(Native Method)
        //       at java.base/java.lang.Class.forName(Class.java:375)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Indirect.make(ClassInjector.java:640)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:302)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:290)
        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:318)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.<clinit>(ClassInjector.java:70)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:184)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.mockito.Mockito.mock(Mockito.java:1768)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for java.lang.ClassLoader.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(UserFactory.createUser()));

        // Act
        MockMvcBuilders.standaloneSetup(accountController).build().perform(requestBuilder);
    }

    /**
     * Test {@link AccountController#saveCurrentAccount(Principal, Account)}.
     * <p>
     * Method under test:
     * {@link AccountController#saveCurrentAccount(Principal, Account)}
     */
    @Test
    @DisplayName("Test saveCurrentAccount(Principal, Account)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testSaveCurrentAccount() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   org.mockito.exceptions.base.MockitoException:
        //   Mockito cannot mock this class: interface com.piggymetrics.account.service.AccountService.
        //   Mockito can only mock non-private & non-final classes.
        //   If you're not sure why you're getting this error, please report to the mailing list.
        //   Java               : 17
        //   JVM vendor name    : Oracle Corporation
        //   JVM vendor version : 17.0.11+7-LTS-207
        //   JVM name           : Java HotSpot(TM) 64-Bit Server VM
        //   JVM version        : 17.0.11+7-LTS-207
        //   JVM info           : mixed mode, sharing
        //   OS name            : Windows 11
        //   OS version         : 10.0
        //   Underlying exception : java.lang.IllegalArgumentException: Could not create type
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.IllegalArgumentException: Could not create type
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:140)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:40)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:77)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:43)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:53)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:96)
        //       at org.mockito.Mockito.mock(Mockito.java:1954)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.NoSuchMethodError: 'net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder.appendMostSpecific(java.lang.Class[])'
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:134)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.lambda$mockClass$0(TypeCachingBytecodeGenerator.java:47)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:40)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:77)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:43)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:53)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:96)
        //       at org.mockito.Mockito.mock(Mockito.java:1954)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
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
        String content = (new ObjectMapper()).writeValueAsString(account);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/current")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(accountController).build().perform(requestBuilder);
    }

    /**
     * Test {@link AccountController#getCurrentAccount(Principal)}.
     * <p>
     * Method under test: {@link AccountController#getCurrentAccount(Principal)}
     */
    @Test
    @DisplayName("Test getCurrentAccount(Principal)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testGetCurrentAccount() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   org.mockito.exceptions.base.MockitoException:
        //   Mockito cannot mock this class: interface com.piggymetrics.account.service.AccountService.
        //   Mockito can only mock non-private & non-final classes.
        //   If you're not sure why you're getting this error, please report to the mailing list.
        //   Java               : 17
        //   JVM vendor name    : Oracle Corporation
        //   JVM vendor version : 17.0.11+7-LTS-207
        //   JVM name           : Java HotSpot(TM) 64-Bit Server VM
        //   JVM version        : 17.0.11+7-LTS-207
        //   JVM info           : mixed mode, sharing
        //   OS name            : Windows 11
        //   OS version         : 10.0
        //   Underlying exception : java.lang.IllegalArgumentException: Could not create type
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.IllegalArgumentException: Could not create type
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:140)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:40)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:77)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:43)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:53)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:96)
        //       at org.mockito.Mockito.mock(Mockito.java:1954)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.NoSuchMethodError: 'net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder.appendMostSpecific(java.lang.Class[])'
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:134)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.lambda$mockClass$0(TypeCachingBytecodeGenerator.java:47)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:40)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:77)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:43)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:53)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:96)
        //       at org.mockito.Mockito.mock(Mockito.java:1954)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/current");

        // Act
        MockMvcBuilders.standaloneSetup(accountController).build().perform(requestBuilder);
    }

    /**
     * Test {@link AccountController#getAccountByName(String)}.
     * <p>
     * Method under test: {@link AccountController#getAccountByName(String)}
     */
    @Test
    @DisplayName("Test getAccountByName(String)")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testGetAccountByName() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: Failed to load ApplicationContext
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   org.mockito.exceptions.base.MockitoException:
        //   Mockito cannot mock this class: interface com.piggymetrics.account.service.AccountService.
        //   Mockito can only mock non-private & non-final classes.
        //   If you're not sure why you're getting this error, please report to the mailing list.
        //   Java               : 17
        //   JVM vendor name    : Oracle Corporation
        //   JVM vendor version : 17.0.11+7-LTS-207
        //   JVM name           : Java HotSpot(TM) 64-Bit Server VM
        //   JVM version        : 17.0.11+7-LTS-207
        //   JVM info           : mixed mode, sharing
        //   OS name            : Windows 11
        //   OS version         : 10.0
        //   Underlying exception : java.lang.UnsupportedOperationException: Cannot define class using reflection
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   java.lang.UnsupportedOperationException: Cannot define class using reflection
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Unavailable.defineClass(ClassInjector.java:821)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.inject(ClassInjector.java:185)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:187)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.createMock(MockitoPostProcessor.java:222)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:192)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:174)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:144)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:131)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:284)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:172)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:694)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:107)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   com.diffblue.cover.sandbox.execution.ForbiddenByPolicyException: Sandboxing policy violation
        //       at java.base/java.lang.Class.forName0(Native Method)
        //       at java.base/java.lang.Class.forName(Class.java:375)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Indirect.make(ClassInjector.java:640)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:302)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:290)
        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:318)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.<clinit>(ClassInjector.java:70)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:184)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.mockito.Mockito.mock(Mockito.java:1768)
        //   com.diffblue.cover.exception.BaseException: Sandboxing policy violation
        //       at java.base/java.lang.Class.forName0(Native Method)
        //       at java.base/java.lang.Class.forName(Class.java:375)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Indirect.make(ClassInjector.java:640)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:302)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$CreationAction.run(ClassInjector.java:290)
        //       at java.base/java.security.AccessController.doPrivileged(AccessController.java:318)
        //       at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.<clinit>(ClassInjector.java:70)
        //       at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:184)
        //       at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
        //       at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4457)
        //       at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:121)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
        //       at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
        //       at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
        //       at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
        //       at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
        //       at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:25)
        //       at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
        //       at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
        //       at org.mockito.Mockito.mock(Mockito.java:1855)
        //       at org.mockito.Mockito.mock(Mockito.java:1768)
        //   To avoid this error, consider adding a custom base class to setup static
        //   mocking for java.lang.ClassLoader.
        //   For details on how to set up a custom base class, please follow this link:
        //   https://docs.diffblue.com/features/cover-cli/writing-tests/custom-test-setup
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{name}", "Smith");

        // Act
        MockMvcBuilders.standaloneSetup(accountController).build().perform(requestBuilder);
    }
}
