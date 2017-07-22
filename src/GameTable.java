import javafx.scene.control.Tab;

import java.util.Objects;

public class GameTable
{
    protected byte[][] Table;
    protected char[][] Display;

    public GameTable(int Row, int Column)
    {
        Table = new byte[Row][Column];
        Display = new char[Row][Column];
    }

    public void ClearTable()
    {
        for (int i = 0; i < Table.length; i++)
        {
            for (int j = 0; j < Table[i].length; j++)
            {
                Table[i][j] = 0;
            }
        }
    }
}

enum Winner
{
    None,
    X,
    O,
    Draw
};
