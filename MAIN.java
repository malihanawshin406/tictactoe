import javax.swing.*;
public class MAIN
{
    public static void main(String[] args)
    {
        DatabaseHandler.initializeDB();
        SwingUtilities.invokeLater(()->
        {
            MainMenuView mainMenu=new MainMenuView();
            mainMenu.setVisible(true);
        });
    }
}