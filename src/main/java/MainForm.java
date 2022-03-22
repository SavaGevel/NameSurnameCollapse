import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {


    private final static String COLLAPSE_CMD = "Collapse";
    private final static String EXPAND_CMD = "Expand";


    private JPanel mainPanel;

    private JButton collapseExpandButton;

    private JFormattedTextField surnameTextField;
    private JFormattedTextField nameTextField;
    private JFormattedTextField patronymicTextField;

    private JLabel Surname;
    private JLabel Name;
    private JLabel Patronymic;


    public MainForm() {

        collapseExpandButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (collapseExpandButton.getText().equals(COLLAPSE_CMD)) {
                    collapse();
                } else if(collapseExpandButton.getText().equals(EXPAND_CMD)){
                    expand();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void collapse() {
        if (surnameTextField.getText().isBlank() || nameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Поля Surname и Name являются\n обязательными для заполнения",
                    "",
                    JOptionPane.PLAIN_MESSAGE
            );
        } else {
            collapseExpandButton.setText("Expand");
            String snp = "";

            String surname = surnameTextField.getText();
            String name = nameTextField.getText();
            String patronymic = patronymicTextField.getText();

            snp = snp.concat(surname).concat(" ").concat(name).concat(" ").concat(patronymic);

            surnameTextField.setVisible(false);
            patronymicTextField.setVisible(false);

            Surname.setVisible(false);
            Patronymic.setVisible(false);

            Name.setText("SNP");
            nameTextField.setText(snp);
            collapseExpandButton.setText(EXPAND_CMD);
        }
    }

    private void expand() {

        if (nameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Поле SNP пустое",
                    "",
                    JOptionPane.PLAIN_MESSAGE
            );

        } else {

            String[] snp = nameTextField.getText().split(" ");

            if (snp.length == 1) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Поле SNP должно содержать минимум два слова",
                        "",
                        JOptionPane.PLAIN_MESSAGE
                );
            } else {

                Surname.setVisible(true);
                Patronymic.setVisible(true);

                surnameTextField.setVisible(true);
                patronymicTextField.setVisible(true);

                Name.setText("Name");

                surnameTextField.setText(snp[0]);
                nameTextField.setText(snp[1]);
                if (snp.length == 3) {
                    patronymicTextField.setText(snp[2]);
                }

                collapseExpandButton.setText(COLLAPSE_CMD);
            }
        }
    }

}
