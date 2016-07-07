import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PrzedszkolakController {
    private Przedszkolak model;
    private PrzedszkolakView view;

    public PrzedszkolakController(Przedszkolak pmodel, PrzedszkolakView pview) {
        this.model=pmodel;
        this.view=pview;
    }
}
