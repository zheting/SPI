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