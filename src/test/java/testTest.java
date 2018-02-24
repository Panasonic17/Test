import org.junit.Test;

import static org.junit.Assert.assertNotNull;



public class testTest {

    @Test
    public void test_method_1() {
        ForTest ft=new ForTest();
        Object object=ft.get();
        assertNotNull(object);
    }

}
