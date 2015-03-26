import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Пример простого теста
 */
public class TestA {

    @Test
    public void test1() {
        System.out.println("TestA.test1");

        A a = new A();
        assertEquals(5, a.sum(2, 3));
    }
}
