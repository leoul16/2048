package cs2114.Game2048;

import sofia.graphics.Color;
import sofia.graphics.*;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * This is the implementation of the GUI for the game 2048. This will start the
 * game and graphically represent the tiles and movement of the tiles used in
 * this game. It will eventually allow for the user to swipe across the screen
 * to determine which direction the tiles should be moved.
 *
 * @author jaurban John Urban
 * @author jamesf1 James Fenwick
 * @author leoul16 Leoul Yiheyis
 * @author jaechoi Jae Choi
 * @version 2014.04.30
 */
public class Screen
    extends ShapeScreen
{
    // -------------------------------------------------------------------------
    // Fields
    private TextShape[][]      nums;
    private RectangleShape[][] tilez;
    private Board              gameBoard;
    /**
     * The size of the squares in pixels
     */
    public static float        squareSize;
    private float              size;


    // ----------------------------------------------------------
    /**
     * This sets the board up for the game 2048 to be played, laying out the
     * background tiles and eventually the numbered tiles that are used to
     * actually play the game
     */
    public void initialize()
    {
        gameBoard = new Board();
        nums = new TextShape[4][4];
        tilez = new RectangleShape[4][4];
        size = Math.min(getWidth(), getHeight());
        squareSize = size / 4;

        for (int i = 0; i <= 3; i++)
        {
            for (int j = 0; j <= 3; j++)
            {

                RectangleShape current =
                    new RectangleShape(
                        (i * squareSize),
                        (j * squareSize),
                        ((i + 1) * squareSize),
                        (j + 1) * squareSize);
                tilez[i][j] = current;
                nums[i][j] =
                    new TextShape(
                        convertBoard()[j][i],
                        (i * squareSize + (squareSize / 4)),
                        (j * squareSize + (squareSize / 4)));
                nums[i][j].setTypeSize(8);
                current.setColor(Color.darkGray);
                current.setFillColor(Color.gainsboro);
                current.setStrokeWidth(10.0);
                add(current);
                add(nums[i][j]);
            }
        }
        printNum(convertBoard());
    }


    // ----------------------------------------------------------
    /**
     * moves all the values up on the board
     */
    public void upClicked()
    {
        gameBoard.moveUp();
        printNum(convertBoard());
    }


    // ----------------------------------------------------------
    /**
     * moves all the values down on the board
     */
    public void downClicked()
    {
        gameBoard.moveDown();
        printNum(convertBoard());
    }


    // ----------------------------------------------------------
    /**
     * Moves all the value to the left side of the board
     */
    public void leftClicked()
    {
        gameBoard.moveLeft();
        printNum(convertBoard());
    }


    // ----------------------------------------------------------
    /**
     * Moves all the value to the Right side of the board
     */
    public void rightClicked()
    {
        gameBoard.moveRight();
        printNum(convertBoard());
    }


    // ----------------------------------------------------------
    /**
     * Resets the board
     */
    public void resetClicked()
    {
        gameBoard = new Board();
        printNum(convertBoard());
    }


    /**
     * This converts the 2D array retrieved from the board class into a usable
     * string array
     */
    private String[][] convertBoard()
    {
        String[][] str = new String[4][4];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (gameBoard.getBoard()[i][j] != 0)
                {
                    str[i][j] = Integer.toString(gameBoard.getBoard()[i][j]);
                }
                else
                {
                    str[i][j] = "";
                }
            }
        }
        return str;
    }


    // ----------------------------------------------------------
    /**
     * changes the textShapes to represent changes in the board
     *
     * @param string
     */
    private void printNum(String[][] string)
    {
        for (int i = 0; i <= 3; i++)
        {
            for (int j = 0; j <= 3; j++)
            {
                nums[i][j].setText(string[j][i]);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * This allows for access to the 2D textShape array for testing
     *
     * @return the textShapes used to represent the numbers
     */
    public TextShape[][] getTextShapes()
    {
        return nums;
    }
}
