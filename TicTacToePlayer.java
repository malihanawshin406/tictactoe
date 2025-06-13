public class TicTacToePlayer extends Player
{
    private char symbol;
    public TicTacToePlayer(String name,String email,char symbol)
    {
        super(name,email);
        this.symbol=symbol;
    }
    public char getSymbol()
    {
        return symbol;
    }
    public void setSymbol(char symbol)
    {
        this.symbol=symbol;
    }
}