import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {

    // window attributes
    public JFrame window;
    public JPanel textPanel;
    public JButton[][] buttons;
    public JLabel textField;
    public int gridSize = 16; //16 means 16x16(256) cells are made
    public static int width = 400 ;
    public static int height = 400;
    private static int bombCount = 40;
    private static int flagCount = 0;

    // cell attributes
    public boolean isFLagged;
    public boolean isBombed; // checks if a square contains bomb
    public boolean isCleared;

    ArrayList<>


//    ArrayList<Integer> xPositions; // X bomb positions
//    ArrayList<Integer> yPositions; // Y bomb position;

    public Game()
    {
        //create window & set characteristics
        createWindow();

        //create bomb field
        createBombField();
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
        for(int i = 0; i < gridSize; ++i)
        {
            for(int j = 0; j < gridSize; ++j)
            {

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