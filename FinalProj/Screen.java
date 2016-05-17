package cs2114.Game2048;

import android.widget.Button;
import android.graphics.Paint.Cap;
import sofia.graphics.Color;
import android.R.color;
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
 * @version 2014.04.16
 */
public class Screen
    extends ShapeScreen
{
    // -------------------------------------------------------------------------
    // Fields
    private int[][]     prevBoard;
    private int[][]     currentBoard;
    private Tile[][]    tilez;
    private board       gameBoard;
    /**
     * The size of the squares in pixels
     */
    public static float squareSize;
    private float       size;
    private float       downX;
    private float       downY;
    private Button up;
    private Button down;
    private Button left;
    private Button right;


    // ----------------------------------------------------------
    /**
     * This sets the board up for the game 2048 to be played, laying out the
     * background tiles and eventually the numbered tiles that are used to
     * actually play the game
     */
    public void initialize()
    {
        gameBoard = new board();
        currentBoard = gameBoard.getBoard();
        tilez = new Tile[4][4];
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
                current.setColor(Color.darkGray);
                current.setFillColor(Color.gainsboro);
                current.setStrokeWidth(10.0);
                current.setStrokeCap(Cap.ROUND);
                add(current);
            }
        }
        printNum(convertBoard());
    }


    private void drawBoard()
    {
        prevBoard = currentBoard;
        currentBoard = gameBoard.getBoard();
        for (int i = 0; i <= 3; i++)
        {
            for (int j = 0; j <= 3; j++)
            {
                if (currentBoard[i][j] == prevBoard[i][j])
                {
                    continue;
                }

            }
        }

    }


    /**
     * Record the touch-down in order to calculate the swipe direction
     *
     * @param x
     *            The touch-down x
     * @param y
     *            The touch-down y
     */
    public void onTouchDown(float x, float y)
    {
        downX = x;
        downY = y;
        //this.processTouch(x, y);

    }


    /**
     * Move the tiles in the appropriate direction upon a touch-move
     *
     * @param x
     *            The
     * @param y
     *            The x
     */
    public void onTouchUp(float x, float y)
    {
        this.processTouch(x, y);
    }

    public void resetClicked()
    {
        this.initialize();

    }

    public void processTouch(float x, float y)
    {
        int dx = (int)(x - downX);
        int dy = (int)(y - downY);
        boolean xLarger = (Math.abs(dx) > Math.abs(dy));
        if (xLarger && Math.abs(dx) > 4)
        {
            if (dx > 0)
            {
                gameBoard.moveRight();
            }
            if (dx < 0)
            {
                gameBoard.moveLeft();
            }
        }
        else
        {
            if (Math.abs(dy) > 4)
            {
                if (dy < 0)
                {
                    gameBoard.moveUp();
                }
                if (dy > 0)
                {
                    gameBoard.moveUp();
                }
            }
        }
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
                str[i][j] = Integer.toString(gameBoard.getBoard()[i][j]);
            }
        }
        return str;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param string
     */
    private void printNum(String[][] string)
    {
        for (int i = 0; i <= 3; i++)
        {
            for (int j = 0; j <= 3; j++)
            {
                add(new TextShape(
                    string[i][j],
                    (i * squareSize + (squareSize / 2)),
                    (j * squareSize + (squareSize / 2))));
            }
        }
    }


    public void upClicked()
    {
        gameBoard.moveUp();
        printNum(convertBoard());
    }

    public void downClicked()
    {
        gameBoard.moveDown();
        printNum(convertBoard());

    }

    public void rightClicked()
    {
        gameBoard.moveRight();
        printNum(convertBoard());

    }

    public void leftClicked()
    {
        gameBoard.moveLeft();
        printNum(convertBoard());

    }


}
