import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwapCardAction extends AbstractAction {
    private String key;
    private CreateLayout _layout;

    public SwapCardAction(String name, int mnemonic, String key,
                          CreateLayout firstFrame) {
        super(name);
        this.key = key;
        this._layout = firstFrame;
        putValue(MNEMONIC_KEY, mnemonic);
    }
    public SwapCardAction(){}; // to just create an instance and use the SwapCards method

    @Override
    public void actionPerformed(ActionEvent evt) {
        _layout.SwapCards(key);
    }




}
