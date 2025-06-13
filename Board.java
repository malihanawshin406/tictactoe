public class Board
{
    private char[][] grid;
    public Board()
    {
        grid = new char[3][3];
        initializeBoard();
    }
    private void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grid[i][j] = '-';
            }
        }
    }
    public void display()
    {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isValidMove(int x, int y)
    {
        return x >= 0 && x < 3 && y >= 0 && y < 3 && grid[x][y] == '-';
    }
    public void placeMove(int x, int y, char symbol)
    {
        grid[x][y] = symbol;
    }
    public boolean checkWinner(char symbol)
    {
        for (int i = 0; i < 3; i++)
        {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol)
            {
                return true;
            }
        }
        for (int j = 0; j < 3; j++)
        {
            if (grid[0][j] == symbol && grid[1][j] == symbol && grid[2][j] == symbol)
            {
                return true;
            }
        }
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol)
        {
            return true;
        }
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)
        {
            return true;
        }
        return false;
    }
    public boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (grid[i][j] == '-')
                {
                    return false;
                }
            }
        }
        return true;
    }
    public char getCell(int x, int y)
    {
        return grid[x][y];
    }
}