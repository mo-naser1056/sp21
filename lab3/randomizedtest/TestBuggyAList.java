package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> right = new AListNoResizing<>();
        BuggyAList<Integer> wrong = new BuggyAList<>();
        for(int i = 0; i < 1000; i++){
            int random = StdRandom.uniform(0, 3);
            if (random == 0 && right.size() != 0){
                assertEquals(right.removeLast(), wrong.removeLast());
            }
            else if (random == 1 && right.size() != 0){
                assertEquals(right.getLast(), wrong.getLast());
            }
            else if(random == 2) {
                int x = StdRandom.uniform(0, 100);
                right.addLast(x);
                wrong.addLast(x);
            }
            else assertEquals(right.size(), wrong.size());
        }
    }

}

