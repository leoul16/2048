package cs2114.Game2048;

import sofia.graphics.TextShape;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 * Tests the Screen class
 *
 * @author jaurban John Urban
 * @author jamesf1 James Fenwick
 * @author leoul16 Leoul Yiheyis
 * @author jaechoi Jae Choi
 * @version 2014.04.30
 */
public class ScreenTest
    extends student.AndroidTestCase<Screen>
{
    private TextShape[][] aView;
    private Button        reset;
    private Button        up;
    private Button        left;
    private Button        right;
    private Button        down;


    // ----------------------------------------------------------
    /**
     * Create a new ScreenTest object.
     */
    public ScreenTest()
    {
        super(Screen.class);
    }


    /**
     * Set up the test class
     */
    public void setUp()
    {
        aView = getScreen().getTextShapes();
    }


    /**
     * Get the number of nonzero numbers in the textViews
     *
     * @return The number of non-zeros
     */
    private int numNums()
    {
        int nums = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (!aView[i][j].getText().equals(""))
                {
                    nums++;
                }
            }
        }

        return nums;
    }


    // ----------------------------------------------------------
    /**
     * Ensure that pressing the directional buttons causes movement
     */
    public void testMove()
    {
        assertEquals(numNums(), 2);
        boolean moveSuccess = false;
        // Try multiple times to allow for combining
        for (int i = 0; i < 10; i++)
        {
            click(left);
            if (numNums() != 3)
            {
                click(reset);
                continue;
            }
            moveSuccess = true;
            break;

        }
        assertTrue(moveSuccess);
        click(up);
        // Make sure there's a tile at the top left
        assertFalse(aView[0][0].getText().equals(""));
        click(right);
        assertFalse(aView[3][0].getText().equals(""));
        click(down);
        assertFalse(aView[3][3].getText().equals(""));
    }


    // ----------------------------------------------------------
    /**
     * Test the reset button
     */
    public void testReset()
    {
        for (int i = 0; i < 10; i++)
        {
            click(left);
            if (numNums() != 3)
            {
                click(reset);
                continue;
            }
            break;
        }
        assertEquals(numNums(), 3);
        click(reset);
        assertEquals(numNums(), 2);
    }

}
