swarm-main-error-gradle
=======================

This is an example project of an issue related to running a wildfly-swarm project built with gradle from the IDE.

Running this project by the generated swarm.jar, it behaves as expected. However, running from the IDE results
in the application not being deployed.

This issue is probably related to https://issues.jboss.org/browse/SWARM-542

### Running via jar

```
./gradlew clean build
java -jar build/libs/swarm-main-error-gradle-swarm.jar
```

### Running via IntelliJ

Run the main method from com.example.MyMain class. Gradle does not populate the local M2REPO, so the first time 
this project is run, you might need to use the following properties, as described in https://issues.jboss.org/browse/SWARM-542:

```
-Dremote.maven.repo=https://repository.jboss.org/nexus/content/groups/m2-proxy/,https://repository.jboss.org/nexus/content/groups/public/"
-Dmaven.download.message=true
```

### Running via Eclipse

I haven't tested it


### Console output example

Via jar:

```
17:24:56,386 INFO  [org.jboss.msc] (main) JBoss MSC version 1.2.6.Final
17:24:56,561 INFO  [org.jboss.as] (MSC service thread 1-6) WFLYSRV0049: WildFly Core 2.0.10.Final "Kenny" starting
2016-07-29 17:24:57,673 WARN  [org.jboss.as.txn] (ServerService Thread Pool -- 17) WFLYTX0013: Node identifier property is set to the default value. Please make sure it is unique.
2016-07-29 17:24:57,683 INFO  [org.jboss.as.naming] (ServerService Thread Pool -- 15) WFLYNAM0001: Activating Naming Subsystem
2016-07-29 17:24:57,701 INFO  [org.wildfly.extension.io] (ServerService Thread Pool -- 14) WFLYIO001: Worker 'default' has auto-configured to 8 core threads with 64 task threads based on your 4 available processors
2016-07-29 17:24:57,722 INFO  [org.jboss.as.naming] (MSC service thread 1-6) WFLYNAM0003: Starting Naming Service
2016-07-29 17:24:57,751 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 18) WFLYUT0003: Undertow 1.3.15.Final starting
2016-07-29 17:24:57,751 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-1) WFLYUT0003: Undertow 1.3.15.Final starting
2016-07-29 17:24:57,819 WARN  [io.undertow] (ServerService Thread Pool -- 18) UT005060: Predicate exists['%{o,Content-Type}'] and regex[pattern='(?:text/plain|text/html|application/xhtml+xml|text/xml|application/xml|application/xml+rss|text/css|text/javascript|application/x-javascript|application/javascript|text/javascript|application/json|text/css)(;.*)?', value=%{o,Content-Type}, full-match=true] uses old style square braces to define predicates, which will be removed in a future release. predicate[value] should be changed to predicate(value)
2016-07-29 17:24:57,820 WARN  [io.undertow] (ServerService Thread Pool -- 18) UT005060: Predicate exists['%{o,Content-Type}'] and regex[pattern='(?:text/plain|text/html|application/xhtml+xml|text/xml|application/xml|application/xml+rss|text/css|text/javascript|application/x-javascript|application/javascript|text/javascript|application/json|text/css)(;.*)?', value=%{o,Content-Type}, full-match=true] uses old style square braces to define predicates, which will be removed in a future release. predicate[value] should be changed to predicate(value)
2016-07-29 17:24:57,900 INFO  [org.xnio] (MSC service thread 1-2) XNIO version 3.3.4.Final
2016-07-29 17:24:57,911 INFO  [org.xnio.nio] (MSC service thread 1-2) XNIO NIO Implementation Version 3.3.4.Final
2016-07-29 17:24:57,956 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0012: Started server default-server.
2016-07-29 17:24:57,957 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0018: Host default-host starting
2016-07-29 17:24:58,152 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0025: WildFly Core 2.0.10.Final "Kenny" started in 2136ms - Started 79 of 89 services (19 services are lazy, passive or on-demand)
2016-07-29 17:24:58,215 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-7) WFLYUT0006: Undertow HTTP listener default listening on [0:0:0:0:0:0:0:0]:8080
2016-07-29 17:25:00,752 INFO  [org.wildfly.swarm.runtime.deployer] (main) deploying swarm-main-error-gradle-1.0.war
2016-07-29 17:25:00,775 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-2) WFLYSRV0027: Starting deployment of "swarm-main-error-gradle-1.0.war" (runtime-name: "swarm-main-error-gradle-1.0.war")
2016-07-29 17:25:03,359 WARN  [org.jboss.as.server.deployment] (MSC service thread 1-3) WFLYSRV0059: Class Path entry vaadin-server-7.5.1.jar in /swarm-main-error-gradle-1.0.war/WEB-INF/lib/vaadin-cdi-1.0.3.jar  does not point to a valid jar for a Class-Path reference.
2016-07-29 17:25:03,359 WARN  [org.jboss.as.server.deployment] (MSC service thread 1-3) WFLYSRV0059: Class Path entry vaadin-sass-compiler-0.9.12.jar in /swarm-main-error-gradle-1.0.war/WEB-INF/lib/vaadin-cdi-1.0.3.jar  does not point to a valid jar for a Class-Path reference.
2016-07-29 17:25:03,359 WARN  [org.jboss.as.server.deployment] (MSC service thread 1-3) WFLYSRV0059: Class Path entry vaadin-shared-7.5.1.jar in /swarm-main-error-gradle-1.0.war/WEB-INF/lib/vaadin-cdi-1.0.3.jar  does not point to a valid jar for a Class-Path reference.
2016-07-29 17:25:03,360 WARN  [org.jboss.as.server.deployment] (MSC service thread 1-3) WFLYSRV0059: Class Path entry jsoup-1.8.1.jar in /swarm-main-error-gradle-1.0.war/WEB-INF/lib/vaadin-cdi-1.0.3.jar  does not point to a valid jar for a Class-Path reference.
2016-07-29 17:25:04,011 WARN  [org.jboss.as.dependency.private] (MSC service thread 1-2) WFLYSRV0018: Deployment "deployment.swarm-main-error-gradle-1.0.war" is using a private module ("org.jboss.jts:main") which may be changed or removed in future versions without notice.
2016-07-29 17:25:04,225 INFO  [org.jboss.weld.deployer] (MSC service thread 1-8) WFLYWELD0003: Processing weld deployment swarm-main-error-gradle-1.0.war
2016-07-29 17:25:04,316 INFO  [org.hibernate.validator.internal.util.Version] (MSC service thread 1-8) HV000001: Hibernate Validator 5.2.3.Final
2016-07-29 17:25:04,404 INFO  [org.apache.deltaspike.core.util.ProjectStageProducer] (MSC service thread 1-8) Computed the following DeltaSpike ProjectStage: Production
2016-07-29 17:25:04,521 INFO  [org.jboss.weld.deployer] (MSC service thread 1-3) WFLYWELD0006: Starting Services for CDI deployment: swarm-main-error-gradle-1.0.war
2016-07-29 17:25:04,613 INFO  [org.jboss.weld.Version] (MSC service thread 1-3) WELD-000900: 2.3.2 (Final)
2016-07-29 17:25:04,673 INFO  [org.jboss.weld.deployer] (MSC service thread 1-4) WFLYWELD0009: Starting weld service for deployment swarm-main-error-gradle-1.0.war
2016-07-29 17:25:04,897 INFO  [org.jboss.weld.Event] (MSC service thread 1-1) WELD-000411: Observer method [BackedAnnotatedMethod] protected org.apache.deltaspike.core.impl.exclude.extension.ExcludeExtension.vetoBeans(@Observes ProcessAnnotatedType, BeanManager) receives events for all annotated types. Consider restricting events using @WithAnnotations or a generic type with bounds.
2016-07-29 17:25:04,899 INFO  [org.jboss.weld.Event] (MSC service thread 1-1) WELD-000411: Observer method [BackedAnnotatedMethod] protected org.apache.deltaspike.core.impl.interceptor.GlobalInterceptorExtension.promoteInterceptors(@Observes ProcessAnnotatedType, BeanManager) receives events for all annotated types. Consider restricting events using @WithAnnotations or a generic type with bounds.
2016-07-29 17:25:04,920 INFO  [org.jboss.weld.Event] (MSC service thread 1-1) WELD-000411: Observer method [BackedAnnotatedMethod] protected org.apache.deltaspike.core.impl.message.MessageBundleExtension.detectInterfaces(@Observes ProcessAnnotatedType) receives events for all annotated types. Consider restricting events using @WithAnnotations or a generic type with bounds.
2016-07-29 17:25:04,963 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.jmx.MBeanExtension activated=true
2016-07-29 17:25:04,964 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.config.ConfigurationExtension activated=true
2016-07-29 17:25:04,964 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.exception.control.extension.ExceptionControlExtension activated=true
2016-07-29 17:25:04,964 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.message.MessageBundleExtension activated=true
2016-07-29 17:25:04,964 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.interceptor.GlobalInterceptorExtension activated=true
2016-07-29 17:25:04,989 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.exclude.extension.ExcludeExtension activated=true
2016-07-29 17:25:04,989 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.exclude.CustomProjectStageBeanFilter activated=true
2016-07-29 17:25:04,990 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.exclude.GlobalAlternative activated=true
2016-07-29 17:25:04,991 INFO  [org.apache.deltaspike.core.util.ClassDeactivationUtils] (MSC service thread 1-1) class: org.apache.deltaspike.core.impl.scope.DeltaSpikeContextExtension activated=true
2016-07-29 17:25:05,284 INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 1) WELD-001125: Illegal bean type java.util.Comparator<org.apache.deltaspike.core.api.exception.control.HandlerMethod<?>> ignored on [EnhancedAnnotatedTypeImpl] public final  class org.apache.deltaspike.core.impl.exception.control.ExceptionHandlerComparator
2016-07-29 17:25:05,402 INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 1) WELD-001125: Illegal bean type java.util.Comparator<javax.enterprise.inject.spi.AnnotatedConstructor<? super T>> ignored on [EnhancedAnnotatedTypeImpl] private static  class org.apache.deltaspike.core.util.Annotateds$AnnotatedConstructorComparator
2016-07-29 17:25:05,403 INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 5) WELD-001125: Illegal bean type java.util.Comparator<javax.enterprise.inject.spi.AnnotatedCallable<? super T>> ignored on [EnhancedAnnotatedTypeImpl] private static  class org.apache.deltaspike.core.util.Annotateds$AnnotatedCallableComparator
2016-07-29 17:25:05,406 INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 5) WELD-001125: Illegal bean type java.util.Comparator<javax.enterprise.inject.spi.AnnotatedMethod<? super T>> ignored on [EnhancedAnnotatedTypeImpl] private static  class org.apache.deltaspike.core.util.Annotateds$AnnotatedMethodComparator
2016-07-29 17:25:05,408 INFO  [org.jboss.weld.Bootstrap] (Weld Thread Pool -- 1) WELD-001125: Illegal bean type java.util.Comparator<javax.enterprise.inject.spi.AnnotatedField<? super T>> ignored on [EnhancedAnnotatedTypeImpl] private static  class org.apache.deltaspike.core.util.Annotateds$AnnotatedFieldComparator
2016-07-29 17:25:05,557 INFO  [com.vaadin.cdi.internal.VaadinExtension] (MSC service thread 1-1) UIScopedContext registered for Vaadin CDI
2016-07-29 17:25:05,559 INFO  [com.vaadin.cdi.internal.VaadinExtension] (MSC service thread 1-1) ViewScopedContext registered for Vaadin CDI
2016-07-29 17:25:05,857 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Initializing web context for path 
2016-07-29 17:25:05,857 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Discovering Vaadin UIs...
2016-07-29 17:25:05,858 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) 1 beans inheriting from UI discovered!
2016-07-29 17:25:05,859 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Vaadin UI com.example.MyUI is marked as @CDIUI without context path, this UI is accessible from context root of deployment
2016-07-29 17:25:05,859 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Available Vaadin UIs for CDI deployment [/ => MyUI]
2016-07-29 17:25:05,861 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Registering VaadinServlet with CDIUIProvider
2016-07-29 17:25:05,863 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Mapping VaadinServlet to /*
2016-07-29 17:25:05,864 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 2) Done deploying Vaadin UIs
2016-07-29 17:25:05,882 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 2) WFLYUT0021: Registered web context: /
2016-07-29 17:25:05,892 INFO  [org.jboss.as.server] (main) WFLYSRV0010: Deployed "swarm-main-error-gradle-1.0.war" (runtime-name : "swarm-main-error-gradle-1.0.war")
^C2016-07-29 17:25:37,333 INFO  [org.jboss.as.server] (Thread-4) WFLYSRV0220: Server shutdown has been requested.
2016-07-29 17:25:37,375 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-8) WFLYUT0008: Undertow HTTP listener default suspending
2016-07-29 17:25:37,379 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-8) WFLYUT0007: Undertow HTTP listener default stopped, was bound to [0:0:0:0:0:0:0:0]:8080
2016-07-29 17:25:37,382 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 20) WFLYUT0022: Unregistered web context: /
2016-07-29 17:25:37,392 INFO  [com.vaadin.cdi.internal.ContextDeployer] (ServerService Thread Pool -- 20) Vaadin web context destroyed
2016-07-29 17:25:37,401 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-5) WFLYUT0019: Host default-host stopping
2016-07-29 17:25:37,402 INFO  [org.jboss.weld.deployer] (MSC service thread 1-6) WFLYWELD0010: Stopping weld service for deployment swarm-main-error-gradle-1.0.war
2016-07-29 17:25:37,406 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-3) WFLYUT0004: Undertow 1.3.15.Final stopping
2016-07-29 17:25:37,511 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-6) WFLYSRV0028: Stopped deployment swarm-main-error-gradle-1.0.war (runtime-name: swarm-main-error-gradle-1.0.war) in 168ms
2016-07-29 17:25:37,515 INFO  [org.jboss.as] (MSC service thread 1-8) WFLYSRV0050: WildFly Core 2.0.10.Final "Kenny" stopped in 170ms
``` 


Via IntelliJ

```
Dependencies not bundled, will resolve from local M2REPO
17:25:53,404 INFO  [org.jboss.msc] (main) JBoss MSC version 1.2.6.Final
17:25:53,833 INFO  [org.jboss.as] (MSC service thread 1-6) WFLYSRV0049: WildFly Core 2.0.10.Final "Kenny" starting
2016-07-29 17:25:54,770 WARN  [org.jboss.as.txn] (ServerService Thread Pool -- 17) WFLYTX0013: Node identifier property is set to the default value. Please make sure it is unique.
2016-07-29 17:25:54,783 INFO  [org.wildfly.extension.io] (ServerService Thread Pool -- 13) WFLYIO001: Worker 'default' has auto-configured to 8 core threads with 64 task threads based on your 4 available processors
2016-07-29 17:25:54,784 INFO  [org.jboss.as.naming] (ServerService Thread Pool -- 18) WFLYNAM0001: Activating Naming Subsystem
2016-07-29 17:25:54,819 INFO  [org.wildfly.extension.undertow] (ServerService Thread Pool -- 11) WFLYUT0003: Undertow 1.3.15.Final starting
2016-07-29 17:25:54,820 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-1) WFLYUT0003: Undertow 1.3.15.Final starting
2016-07-29 17:25:54,838 INFO  [org.jboss.as.naming] (MSC service thread 1-7) WFLYNAM0003: Starting Naming Service
2016-07-29 17:25:54,902 WARN  [io.undertow] (ServerService Thread Pool -- 11) UT005060: Predicate exists['%{o,Content-Type}'] and regex[pattern='(?:text/plain|text/html|application/xhtml+xml|text/xml|application/xml|application/xml+rss|text/css|text/javascript|application/x-javascript|application/javascript|text/javascript|application/json|text/css)(;.*)?', value=%{o,Content-Type}, full-match=true] uses old style square braces to define predicates, which will be removed in a future release. predicate[value] should be changed to predicate(value)
2016-07-29 17:25:54,909 WARN  [io.undertow] (ServerService Thread Pool -- 11) UT005060: Predicate exists['%{o,Content-Type}'] and regex[pattern='(?:text/plain|text/html|application/xhtml+xml|text/xml|application/xml|application/xml+rss|text/css|text/javascript|application/x-javascript|application/javascript|text/javascript|application/json|text/css)(;.*)?', value=%{o,Content-Type}, full-match=true] uses old style square braces to define predicates, which will be removed in a future release. predicate[value] should be changed to predicate(value)
2016-07-29 17:25:55,014 INFO  [org.xnio] (MSC service thread 1-1) XNIO version 3.3.4.Final
2016-07-29 17:25:55,025 INFO  [org.xnio.nio] (MSC service thread 1-1) XNIO NIO Implementation Version 3.3.4.Final
2016-07-29 17:25:55,081 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0012: Started server default-server.
2016-07-29 17:25:55,082 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0018: Host default-host starting
2016-07-29 17:26:00,803 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0025: WildFly Core 2.0.10.Final "Kenny" started in 7509ms - Started 79 of 89 services (19 services are lazy, passive or on-demand)
2016-07-29 17:26:00,859 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0006: Undertow HTTP listener default listening on [0:0:0:0:0:0:0:0]:8080
2016-07-29 17:26:00,947 INFO  [stdout] (main) Warning:  The encoding 'UTF-8' is not supported by the Java runtime.
2016-07-29 17:26:00,947 INFO  [stdout] (main) Warning: encoding "UTF-8" not supported, using UTF-8
2016-07-29 17:26:00,957 INFO  [org.wildfly.swarm.runtime.deployer] (main) deploying 560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar
2016-07-29 17:26:00,980 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-1) WFLYSRV0027: Starting deployment of "560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar" (runtime-name: "560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar")
2016-07-29 17:26:01,179 WARN  [org.jboss.as.dependency.private] (MSC service thread 1-3) WFLYSRV0018: Deployment "deployment.560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar" is using a private module ("org.jboss.jts:main") which may be changed or removed in future versions without notice.
2016-07-29 17:26:01,667 INFO  [org.jboss.as.server] (main) WFLYSRV0010: Deployed "560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar" (runtime-name : "560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar")
2016-07-29 17:29:04,720 INFO  [org.jboss.as.server] (Thread-4) WFLYSRV0220: Server shutdown has been requested.
2016-07-29 17:29:04,733 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-5) WFLYUT0008: Undertow HTTP listener default suspending
2016-07-29 17:29:04,736 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-1) WFLYUT0019: Host default-host stopping
2016-07-29 17:29:04,737 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-5) WFLYUT0007: Undertow HTTP listener default stopped, was bound to [0:0:0:0:0:0:0:0]:8080
2016-07-29 17:29:04,740 INFO  [org.wildfly.extension.undertow] (MSC service thread 1-6) WFLYUT0004: Undertow 1.3.15.Final stopping
2016-07-29 17:29:04,782 INFO  [org.hibernate.validator.internal.util.Version] (MSC service thread 1-4) HV000001: Hibernate Validator 5.2.3.Final
2016-07-29 17:29:04,868 INFO  [org.jboss.as.server.deployment] (MSC service thread 1-8) WFLYSRV0028: Stopped deployment 560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar (runtime-name: 560aa0f2-f5ff-4d3e-9af3-3aa5316348bd.jar) in 144ms
2016-07-29 17:29:04,872 INFO  [org.jboss.as] (MSC service thread 1-6) WFLYSRV0050: WildFly Core 2.0.10.Final "Kenny" stopped in 142ms

Process finished with exit code 130 (interrupted by signal 2: SIGINT)
```