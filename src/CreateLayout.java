import javax.swing.*;
import java.awt.*;

public class CreateLayout extends JPanel{

    private static final int PREF_W = 800;
    private static final int PREF_H = 600;

    public HomeScreen home = new HomeScreen(this);
    public Login login = new Login(this);

//    public GameDescription description = new GameDescription(this);
//    public ScoreScreen gameScore = new ScoreScreen(this);
//    public Game1 game1 = new Game1(this);
//    public Game2 game2 = new Game2(this);
//    public Game3 game3 = new Game3(this);
//    public Game4 game4 = new Game4(this);
//
//    public Stats stats = new Stats(this);

    public CardLayout cardLayout = new CardLayout();

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public CreateLayout() {
        setLayout(cardLayout);
        add(home, HomeScreen.class.toString());

        add(login, Login.class.toString());

//        add(description, GameDescription.class.toString());
//        add(gameScore, ScoreScreen.class.toString());
//
//        add(game1, Game1.class.toString());
//        add(game2, Game2.class.toString());
//        add(game3, Game3.class.toString());
//        add(game4, Game4.class.toString());
//
//        add(stats, Stats.class.toString());

    }

    public void SwapCards(String key){

        cardLayout.show(this, key);
    }
}
