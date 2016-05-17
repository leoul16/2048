package cs2114.Game2048;

import sofia.util.Random;

// -------------------------------------------------------------------------
/**
 * This is the underlying class that defines the board of the game 2048. This
 * class deals with the backbone of the game such as saving tile locations,
 * dealing with the logical movement of the tiles based off of directional input
 * and provides the required mechanism for saving tile values and applicable
 * moves. This class uses a 2D array to store the numbers associated with each
 * tile and handles the combination of like numbers when movement commands are
 * given.
 *
 * @author jaurban John Urban
 * @author jamesf1 James Fenwick
 * @author leoul16 Leoul Yiheyis
 * @author jaechoi Jae Choi
 * @version 2014.04.29
 */

public class Board
{
    // -------------------------------------------------------------------------
    // Fields
    private int[][] locations;


    // ----------------------------------------------------------
    /**
     * Create a new board object.
     */
    public Board()
    {
        locations = new int[4][4];
        addNew();
        addNew();
    }


    // ----------------------------------------------------------
    /**
     * This moves all of the array references to the left
     */
    public void moveLeft()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                recursiveMoveLeft(i, j);
            }
        }
        addNew();
    }


    // ----------------------------------------------------------
    /**
     * moves the given value as far as it can to the left
     *
     * @param iY
     *            the y coordinate of the the value in question
     * @param jX
     *            the x coordinate of the value in question
     */
    public void recursiveMoveLeft(int iY, int jX)
    {
        if (locations[iY][jX] == 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else if (jX == 0)
        {
            locations[iY][0] = locations[iY][jX];
        }
        else if (locations[iY][jX - 1] == locations[iY][jX])
        {
            locations[iY][jX - 1] = 2 * locations[iY][jX];
            locations[iY][jX] = 0;
        }
        else if (locations[iY][jX - 1] != locations[iY][jX]
            && locations[iY][jX - 1] != 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else
        {
            locations[iY][jX - 1] = locations[iY][jX];
            locations[iY][jX] = 0;
            recursiveMoveLeft(iY, (jX - 1));
        }
    }


    // ----------------------------------------------------------
    /**
     * This moves all of the array references to the right
     */
    public void moveRight()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j >= 0; j--)
            {
                recursiveMoveRight(i, j);
            }
        }
        addNew();
    }


    // ----------------------------------------------------------
    /**
     * moves the given value as far as it can to the Right
     *
     * @param iY
     *            the y coordinate of the the value in question
     * @param jX
     *            the x coordinate of the value in question
     */
    public void recursiveMoveRight(int iY, int jX)
    {
        if (locations[iY][jX] == 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else if (jX == 3)
        {
            locations[iY][3] = locations[iY][jX];
        }
        else if (locations[iY][jX + 1] == locations[iY][jX])
        {
            locations[iY][jX + 1] = 2 * locations[iY][jX];
            locations[iY][jX] = 0;
        }
        else if (locations[iY][jX + 1] != locations[iY][jX]
            && locations[iY][jX + 1] != 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else
        {
            locations[iY][jX + 1] = locations[iY][jX];
            locations[iY][jX] = 0;
            recursiveMoveRight(iY, (jX + 1));
        }
    }


    // ----------------------------------------------------------
    /**
     * This moves all of the array references up
     */
    public void moveUp()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                recursiveMoveUp(i, j);
            }
        }
        addNew();
    }


    // ----------------------------------------------------------
    /**
     * moves the given value as far as it can up
     *
     * @param iY
     *            the y coordinate of the the value in question
     * @param jX
     *            the x coordinate of the value in question
     */
    public void recursiveMoveUp(int iY, int jX)
    {
        if (locations[iY][jX] == 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else if (iY == 0)
        {
            locations[0][jX] = locations[iY][jX];
        }
        else if (locations[iY - 1][jX] == locations[iY][jX])
        {
            locations[iY - 1][jX] = 2 * locations[iY][jX];
            locations[iY][jX] = 0;
        }
        else if (locations[iY - 1][jX] != locations[iY][jX]
            && locations[iY - 1][jX] != 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else
        {
            locations[iY - 1][jX] = locations[iY][jX];
            locations[iY][jX] = 0;
            recursiveMoveUp((iY - 1), jX);
        }
    }


    // ----------------------------------------------------------
    /**
     * This moves all of the array references down
     */
    public void moveDown()
    {
        for (int i = 3; i >= 0; i--)
        {
            for (int j = 0; j < 4; j++)
            {
                recursiveMoveDown(i, j);
            }
        }
        addNew();
    }


    // ----------------------------------------------------------
    /**
     * moves the given value as far as it can down
     *
     * @param iY
     *            the y coordinate of the the value in question
     * @param jX
     *            the x coordinate of the value in question
     */
    public void recursiveMoveDown(int iY, int jX)
    {
        if (locations[iY][jX] == 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else if (iY == 3)
        {
            locations[3][jX] = locations[iY][jX];
        }
        else if (locations[iY + 1][jX] == locations[iY][jX])
        {
            locations[iY + 1][jX] = 2 * locations[iY][jX];
            locations[iY][jX] = 0;
        }
        else if (locations[iY + 1][jX] != locations[iY][jX]
            && locations[iY + 1][jX] != 0)
        {
            locations[iY][jX] = locations[iY][jX];
        }
        else
        {
            locations[iY + 1][jX] = locations[iY][jX];
            locations[iY][jX] = 0;
            recursiveMoveDown((iY + 1), jX);
        }
    }


    // ----------------------------------------------------------
    /**
     * This will add a new tile to the board if there is space
     */
    private void addNew()
    {
        int newTile = Random.generator().nextInt(2) + 1;
        int tileValue = (int)Math.pow(2, newTile);
        boolean occupied = true;
        int num = 0;
        while (occupied && num <= 16)
        {
            int x = Random.generator().nextInt(4);
            int y = Random.generator().nextInt(4);
            if (locations[x][y] == 0)
            {
                locations[x][y] = tileValue;
                occupied = false;
            }
            num++;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the value at a given location
     *
     * @param y
     *            the y-coordinate of the location to be checked
     * @param x
     * @return the value of the chosen location
     */
    public int getValue(int y, int x)
    {
        return locations[y][x];
    }


    // ----------------------------------------------------------
    /**
     * Changes the value at a given location
     *
     * @param y
     *            the y-coordinate of the location be changed
     * @param x
     *            the x-coordinate of the location be changed
     * @param value
     *            the new value of the tile
     */
    public void setValue(int y, int x, int value)
    {
        locations[y][x] = value;
    }


    // ----------------------------------------------------------
    /**
     * Returns a 2D integer array for the screen to access the state of the
     * board
     *
     * @return the current board
     */
    public int[][] getBoard()
    {
        return locations;
    }
}
