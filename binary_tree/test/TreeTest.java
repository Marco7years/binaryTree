import component.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    BinaryTree bt;

    @Test
    public void addingElementTest() {
        bt = new BinaryTree();
        bt.add(6);
        bt.add(5);

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(5));

        assertFalse(bt.containsNode(1));
    }

}
