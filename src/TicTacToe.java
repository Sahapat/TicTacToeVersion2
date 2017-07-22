import java.io.*;

public class TicTacToe extends GameTable
{
    private final byte EMPTY = 0;
    private final byte X = 1;
    private final byte O = 4;

    public TicTacToe()
    {
        super(3, 3);
        Init();
    }

    public Winner CheckWinner()
    {
        boolean isEmpty = true;
        boolean checkEmpty = true;

        for (int i = 0; i < Table.length; i++)
        {
            int WinnerSum = 0;
            for (int j = 0; j < Table[i].length; j++)
            {
                if (checkEmpty)
                {
                    if (Table[i][j] == EMPTY)
                    {
                        checkEmpty = false;
                        isEmpty = true;
                    }
                    else
                    {
                        checkEmpty = true;
                        isEmpty = false;
                    }
                }
                WinnerSum += Table[i][j];
            }
            if (WinnerSum == 3) return Winner.X;
            else if (WinnerSum == 12) return Winner.O;
        }
        int diaSum = Table[0][0] + Table[1][1] + Table[2][2];
        if (diaSum == 3) return Winner.X;
        else if (diaSum == 12) return Winner.O;

        diaSum = Table[2][0] + Table[1][1] + Table[0][2];
        if (diaSum == 3) return Winner.X;
        else if (diaSum == 12) return Winner.O;

        if (!isEmpty) return Winner.Draw;
        else return Winner.None;
    }

    public boolean FillTable(int CellSelect, int round)
    {
        int Row = 0;
        int Column = 0;
        for (int i = 1; i < CellSelect; i++)
        {
            Column += 1;
            if (Column >= Table.length)
            {
                Row += 1;
                Column = 0;
            }
        }
        if (Table[Row][Column] == EMPTY)
        {
            if (round % 2 == 0)
            {
                Table[Row][Column] = O;
                Display[Row][Column] = 'O';
            }
            else
            {
                Table[Row][Column] = X;
                Display[Row][Column] = 'X';
            }
            return true;
        }
        else return false;
    }

    public void UpdateTable()
    {
        for (int i = 0; i < 25; i++) System.out.println();
        System.out.print("\t\t");
        for (int i = 0; i < 25; i++) System.out.print("#");
        System.out.println("\n\t\t#       #       #       #");
        System.out.printf("\t\t#  %s    #   %s   #   %s   #\n", Display[0][0], Display[0][1], Display[0][2]);
        System.out.println("\t\t#       #       #       #");
        System.out.print("\t\t");
        for (int i = 0; i < 25; i++) System.out.print("#");
        System.out.println("\n\t\t#       #       #       #");
        System.out.printf("\t\t#  %s    #   %s   #   %s   #\n", Display[1][0], Display[1][1], Display[1][2]);
        System.out.println("\t\t#       #       #       #");
        System.out.print("\t\t");
        for (int i = 0; i < 25; i++) System.out.print("#");
        System.out.println("\n\t\t#       #       #       #");
        System.out.printf("\t\t#  %s    #   %s   #   %s   #\n", Display[2][0], Display[2][1], Display[2][2]);
        System.out.println("\t\t#       #       #       #");
        System.out.print("\t\t");
        for (int i = 0; i < 25; i++) System.out.print("#");

    }

    private void Init()
    {
        for (int i = 0; i < Table.length; i++)
        {
            for (int j = 0; j < Table[i].length; j++)
            {
                Table[i][j] = EMPTY;
                Display[i][j] = ' ';
            }
        }
    }
}
