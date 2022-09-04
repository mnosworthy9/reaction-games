import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class HomeScreen extends JPanel {

    public HomeScreen(final CreateLayout createLayout) {

        JButton Login = new JButton(new SwapCardAction("Login",
                KeyEvent.VK_R, Login.class.toString(), createLayout));

//        JButton Game1Button = new JButton(new SwapCardAction("Game1",
//                KeyEvent.VK_R, GameDescription.class.toString(), firstFrame));
//
//        JButton Game2Button = new JButton(new SwapCardAction("Game2",
//                KeyEvent.VK_R, Game2Description.class.toString(), firstFrame));
//
//        JButton Game3Button = new JButton(new SwapCardAction("Game3",
//                KeyEvent.VK_R, Game3Description.class.toString(), firstFrame));
//
//        JButton Game4Button = new JButton(new SwapCardAction("Game4",
//                KeyEvent.VK_R, Game4Description.class.toString(), firstFrame));
//
//        JButton StatsButton = new JButton(new SwapCardAction("Stats",
//                KeyEvent.VK_R, Stats.class.toString(), firstFrame));
//
//        JButton LogoutButton = new JButton(new SwapCardAction("Logout",
//                KeyEvent.VK_R, Login.class.toString(), firstFrame));

        add(Login);
//        add(Game1Button);
//        add(Game2Button);
//        add(Game3Button);
//        add(Game4Button);
//        add(StatsButton);

//        add(LogoutButton); need to add this when the user is logged in
    }
}
