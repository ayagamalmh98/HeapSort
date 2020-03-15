//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package eg.edu.alexu.csd.filestructure.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.filestructure.sort.IHeap;

public class IntegrationTest {
    private final Class<?> heapInterfaceToTest = IHeap.class;
    private final Class<?> sortInterfaceToTest = IHeap.class;

    public IntegrationTest() {
    }

    @Test
    public void testCreationHeap() {
        List<Class<?>> candidateClasses = ReflectionHelper.findClassesImplementing(this.heapInterfaceToTest, this.heapInterfaceToTest.getPackage());
        Assert.assertNotNull("Failed to create instance using interface '" + this.heapInterfaceToTest.getName() + "' !", candidateClasses);
        Assert.assertEquals("You have more than one public implementation of the interface", 1L, (long)candidateClasses.size());
    }

    @Test
    public void testCreationSort() {
        List<Class<?>> candidateClasses = ReflectionHelper.findClassesImplementing(this.sortInterfaceToTest, this.sortInterfaceToTest.getPackage());
        Assert.assertNotNull("Failed to create instance using interface '" + this.sortInterfaceToTest.getName() + "' !", candidateClasses);
        Assert.assertEquals("You have more than one public implementation of the interface", 1L, (long)candidateClasses.size());
    }
}
