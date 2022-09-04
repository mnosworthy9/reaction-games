import javax.swing.*;

public class Program {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> CreateAndShowGui());
    }

    private static void CreateAndShowGui() {
        CreateLayout mainPanel = new CreateLayout();

        JFrame frame = new JFrame("CreateLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
