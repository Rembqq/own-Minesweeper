import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // window attributes
    public JFrame window;
    public JPanel textPanel;
    public JButton[][] buttons;
    public JLabel textField;
    public int gridSize = 16; //16 means 16x16(256) cells are made
    public static int width = 600 ;
    public static int height = 600;
    public static int initialBombCount = 40;
    public static int userCurrentBombCount;
    public static int realCurrentBombCount;
    public static int flagCount = 0;
    

    // cell attributes
    Cell[][] cells = new Cell[gridSize][gridSize];

    //ArrayList<>


//    ArrayList<Integer> xPositions; // X bomb positions
//    ArrayList<Integer> yPositions; // Y bomb position;

    public Game()
    {
        //create window & set characteristics
        createWindow();

        //create bomb field
        createBombField();

        //calculate each cell neighbour mines
        calculateBombsNearby();


    }
    private void createWindow()
    {
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Minesweeper");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window.setBounds(dimension.width/2 - width/2, dimension.height/2 - height/2, width, height);
    }

    private void createBombField()
    {
        boolean containsBomb;
        int bombsMarked = 0;
        for(int i = 0; i < gridSize; ++i)
        {
            for(int j = 0; j < gridSize; ++j)
            {
                cells[i][j].isBombed = calculateBombChance(i, j, bombsMarked);
                if(cells[i][j].isBombed) {bombsMarked++;}
            }
        }
    }

    private boolean calculateBombChance(int i, int j, int bombsMarked)
    {
        /*int chances;

        chances = (int)(Math.random() * (gridSize * gridSize - i * j) - (initialBombCount - bombsMarked));
        return chances <= 0;*/
        return (Math.random() * (gridSize * gridSize - i * j) <= (initialBombCount - bombsMarked));
    }

    private void calculateBombsNearby()
    {
        int mines_near;
        for(int i = 0; i < gridSize; ++i)
        {
            for(int j = 0; j < gridSize; ++j)
            {
                if(cells[i-1][j].isBombed && i != 0)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i-1][j-1].isBombed && i != 0 && j != 0)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i-1][j+1].isBombed && i != 0 && j != gridSize)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i+1][j-1].isBombed && i != gridSize && j != 0)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i+1][j].isBombed && i != gridSize)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i+1][j+1].isBombed && i != gridSize && j != gridSize)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i][j-1].isBombed && j != 0)
                {
                    cells[i][j].minesNearby++;
                }
                if(cells[i][j+1].isBombed && j != gridSize)
                {
                    cells[i][j].minesNearby++;
                }
            }
        }
    }


    // user available functions
    public void setFLag()
    {

    }
    public void clearCell()
    {

    }


}