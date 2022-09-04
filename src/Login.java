import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login extends JPanel {

    //it is private so that it cannot be changed outside class - security
    private String loggedInUsername;

    public String GetUsername(){ // returns the username that the user has logged in with
        // if this is null the user has not logged in so cannot save game scores
        // the user should be able to play without logging in though
        return this.loggedInUsername;
    }

    JTextField username, password;
    JButton loginButton, registerButton;
    JLabel title;

    GroupLayout loginPage = new GroupLayout(this);

    public Login(CreateLayout layout) {

        setLayout(loginPage);

        title = new JLabel("Login page");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.BLUE);
        title.setBounds(130,10,300,35);

        add(title);

        username = new JTextField(60);
        password = new JPasswordField(60);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        username.setBounds(150,60,120,30);
        password.setBounds(150,100,120,30);
        loginButton.setBounds(220,140,100,30);
        registerButton.setBounds(100,140,100,30);

        add(username);
        add(password);
        add(loginButton);
        add(registerButton);

        registerButton.addActionListener(ae -> {

            // no text entered
            if(username.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please enter both username and password correctly to register","Register error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String returnedMessage = CreateUser(username.getText(), password.getText());

                JOptionPane.showMessageDialog(null, returnedMessage, "Registered", JOptionPane.INFORMATION_MESSAGE);
                if(returnedMessage == "Successfully Registered"){

                }

            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SqlError", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        loginButton.addActionListener(ae -> {

            if(username.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please enter both username and password correctly to register","Login error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String returnedMessage = LoginUser(username.getText(), password.getText(), layout);

                JOptionPane.showMessageDialog(null, returnedMessage, "LoggedIn", JOptionPane.INFORMATION_MESSAGE);

            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "SqlError", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private String CreateUser(String username, String password) throws SQLException {
        try{

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kik-game", "postgres", ""); // add password

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (username, password) " +
                            String.format("VALUES ('%s', '%s')", username, password) +
                            "RETURNING username;"
            );

            statement.executeQuery();

            return "Successfully Registered";

        } catch (Exception e){
            return e.getMessage();
        }
    }

    private String LoginUser(String username, String password, CreateLayout layout) throws SQLException {
        try {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kik-game", "postgres", ""); // add password

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT username from users " +
                            String.format("WHERE username = '%s' and password = '%s';", username, password)
            );

            ResultSet queryResults = statement.executeQuery();

            while (queryResults.next()){
                loggedInUsername = queryResults.getString(1);
            }

            layout.SwapCards(HomeScreen.class.toString());

            return "Successful Login";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
