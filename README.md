# SPI
　SPI ，全称为 Service Provider Interface，是一种服务发现机制。它通过在ClassPath路径下的META-INF/services文件夹查找文件，自动加载文件里所定义的类。  这一机制为很多框架扩展提供了可能，比如在Dubbo、JDBC中都使用到了SPI机制。

## SPI Coding
第一步： META-INF/services 在类路径下的目录，目录名称是固定的。

第二步： 在META-INF/services目录下添加文件， 文件名字是接口的全限定类名。

第三步：添加文件的内容是实现类的全限定类名，多个实现类用换行符分隔。

第四步： 返回接口实现类的迭代器。

Iterator<SPIService> providers = Service.providers(SPIService.class);
 
ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        
        
 ## JAVA SPI 简介
 SPI 是 Java 提供的一种服务加载方式，全名为 Service Provider Interface。根据 Java 的 SPI 规范，我们可以定义一个服务接口，具体的实现由对应的实现者去提供，即服务提供者。
 然后在使用的时候再根据 SPI 的规范去获取对应的服务提供者的服务实现。通过 SPI 服务加载机制进行服务的注册和发现，可以有效的避免在代码中将服务提供者写死。从而可以基于接口编程，实现模块间的解耦。
 
 ## SPI 机制的约定
 
 1 在 META-INF/services/ 目录中创建以接口全限定名命名的文件，该文件内容为API具体实现类的全限定名
 
 2 使用 ServiceLoader 类动态加载 META-INF 中的实现类
 
 3 如 SPI 的实现类为 Jar 则需要放在主程序 ClassPath 中
 
 4 API 具体实现类必须有一个不带参数的构造方法