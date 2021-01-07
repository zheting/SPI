package cn.java.money.driver.spi;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDriverManagerSPI {

    /*
     *  这里获取连接时，没有加载Driver, 为什么可以获得连接？
     *  原因：
     *  DriverManager 中有静态代码块
     *
       static {
        loadInitialDrivers();
        println("JDBC DriverManager initialized");
        }

     * loadInitialDrivers()首先从系统属性获取驱动类 System.getProperty("jdbc.drivers")
     * 其次通过SPI发现配置的驱动：  类路径下 META-INF/services/java.sql.Driver 文件中配置的实现
     *
     *
     *
     */
    @Test
    public void test() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=GMT";
        String user = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

}
