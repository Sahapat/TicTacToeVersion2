import java.util.*;

public class Program
{
    public static void main(String[] arg)
    {
        TicTacToe Game = new TicTacToe();
        Scanner getCell = new Scanner(System.in);
        int round = 1;
        while (true)
        {
            Winner check = Game.CheckWinner();
            for (int i = 0; i < 25; i++) System.out.println();
            Game.UpdateTable();
            if (check == Winner.None)
            {
                if (round % 2 == 0)
                    System.out.print("\nRound: " + round + " " + " O");
                else
                    System.out.print("\nRound: " + round + " X");
                System.out.print("\nSelect: ");
                try
                {
                    int selectCell = getCell.nextInt();
                    if (Game.FillTable(selectCell, round))
                    {
                        round++;
                    }
                }
                catch (Exception ex)
                {
                    System.out.print(ex.toString());
                }
            }
            else if (check == Winner.O)
            {
                for (int i = 0; i < 25; i++)
                    System.out.println();
                System.out.print("\t\t\tO Winner!!!");
                break;
            }
            else if (check == Winner.X)
            {
                for (int i = 0; i < 25; i++)
                    System.out.println();
                System.out.print("\t\t\tX Winner!!!");
                break;
            }
            else
            {
                for (int i = 0; i < 25; i++)
                    System.out.println();
                System.out.print("\t\t\tDraw");
                break;
            }
        }
    }
}
