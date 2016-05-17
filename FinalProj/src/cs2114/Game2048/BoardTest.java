package cs2114.Game2048;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This tests the functionality of the board class. This tests for a number of
 * situations in which the board class might encounter problems and shows that
 * it can deal with the situations.
 *
 * @author jaurban John Urban
 * @author jamesf1 James Fenwick
 * @author leoul16 Leoul Yiheyis
 * @author jaechoi Jae Choi
 * @version 2014.04.29
 */

public class BoardTest
    extends TestCase
{
    // -------------------------------------------------------------------------
    // Fields
    private Board field;


    // ----------------------------------------------------------
    /**
     * Create a new boardTest object.
     */
    public BoardTest()
    {
        // Noting here
    }


    // ----------------------------------------------------------
    /**
     * establishes the initial conditions for the tests
     */
    public void setUp()
    {
        field = new Board();
    }


    // ----------------------------------------------------------
    /**
     * Tests the functionality of moving up
     */
    public void testMoveUp()
    {
        // field[Y][X]
        field.setValue(3, 1, 8);

        field.setValue(2, 2, 8);

        assertEquals(8, field.getBoard()[3][1]);
        assertEquals(8, field.getBoard()[2][2]);

        field.moveUp();

        assertEquals(0, field.getBoard()[3][1]);
        assertEquals(8, field.getBoard()[0][1]);

        assertEquals(0, field.getBoard()[2][2]);
        assertEquals(8, field.getBoard()[0][2]);
    }


    // ----------------------------------------------------------
    /**
     * Tests moving the values down
     */
    public void testMoveDown()
    {
        field.setValue(2, 2, 2);

        field.setValue(1, 3, 2);

        assertEquals(2, field.getBoard()[2][2]);

        assertEquals(2, field.getBoard()[1][3]);

        field.moveDown();

        assertEquals(0, field.getBoard()[2][2]);
        assertEquals(2, field.getBoard()[3][2]);

        assertEquals(0, field.getBoard()[1][3]);
        assertEquals(2, field.getBoard()[3][3]);

    }


    // ----------------------------------------------------------
    /**
     * Tests moving the values to the right
     */
    public void testMoveRight()
    {
        field.setValue(2, 1, 2);

        field.setValue(3, 1, 2);

        assertEquals(2, field.getBoard()[2][1]);

        assertEquals(2, field.getBoard()[3][1]);

        field.moveRight();

        assertEquals(0, field.getBoard()[2][1]);
        assertEquals(2, field.getBoard()[2][3]);

        assertEquals(0, field.getBoard()[3][1]);
        assertEquals(2, field.getBoard()[2][3]);
    }


    // ----------------------------------------------------------
    /**
     * Tests moving the values to the left
     */
    public void testMoveLeft()
    {
        field.setValue(2, 3, 2);

        field.setValue(3, 3, 2);

        assertEquals(2, field.getBoard()[2][3]);

        assertEquals(2, field.getBoard()[3][3]);

        field.moveLeft();

        assertEquals(0, field.getBoard()[2][3]);
        assertEquals(2, field.getBoard()[2][1]);

        assertEquals(0, field.getBoard()[3][3]);
        assertEquals(2, field.getBoard()[2][1]);
    }
}
