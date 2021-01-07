package cn.java.money.spi.demo1;

import org.junit.jupiter.api.Test;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSPI {

    @Test
    public void test1() {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        while (providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }
    }

    @Test
    public void test2() {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.execute();
        }
    }

}
