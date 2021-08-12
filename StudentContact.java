import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class will display a window with a combo box. The user can select a
 * student name and their parent's contact info will show.
 */

public class StudentContact extends JFrame {

    private JPanel comboPanel;
    private JPanel buttonPanel;
    private JPanel displayPanel;
    private JComboBox studentNameComboBox;
    private JButton button;
    private JTextArea display;

    private String[] studentNames = { "Jaxson Henry", "Jade Smith", "Matthew Del Valle", "Sawyer Scott",
            "Madison Jones" };
    private String[] dadPhone = { "3053017893", "7862345768", "9545438976", "3052453456", "9547732940" };
    private String[] momPhone = { "7863234598", "3058795643", "9544356721", "7863425640", "7862349865" };

    public StudentContact() {

        setTitle("Student Contact Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildComboPanel();
        buildButtonPanel();
        buildDisplayPanel();

        add(comboPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
        add(displayPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private void buildComboPanel() {

        comboPanel = new JPanel();

        studentNameComboBox = new JComboBox(studentNames);

        comboPanel.add(studentNameComboBox);
    }

    private void buildButtonPanel() {

        buttonPanel = new JPanel();

        button = new JButton("View Contact Info");
        button.addActionListener(new ButtonListener());

        buttonPanel.add(button);
    }

    private void buildDisplayPanel() {

        displayPanel = new JPanel();

        display = new JTextArea();
        display.setEditable(false);
        display.setPreferredSize(new Dimension(200, 60));

        displayPanel.add(display);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String selectedStudent = studentNameComboBox.getSelectedItem().toString();

            display.setText("Student: " + selectedStudent + "\nDad Phone: " + formatDadPhoneNumber() + "\nMom Phone: "
                    + formatMomPhoneNumber());
        }
    }

    /**
     * This method will format the phone number --> (XXX)XXX-XXXX
     * 
     * @return will return a formatted phone number
     */
    private String formatDadPhoneNumber() {

        int selectedStudentIndex = studentNameComboBox.getSelectedIndex();
        String dadPhoneNumber = dadPhone[selectedStudentIndex].toString();

        StringBuilder str = new StringBuilder(dadPhoneNumber);
        str.insert(0, "("); // Will insert the open parentheses at the beginning of the area code
        str.insert(4, ")"); // Will insert the closing parentheses at the end of the area code
        str.insert(8, "-"); // Will insert a dash after the first three numbers of the phone number

        return str.toString(); // Will reture a string with the formatted phone number
    }

    /**
     * This method will format the phone number --> (XXX)XXX-XXXX
     * 
     * @return will return a formatted phone number
     */

    private String formatMomPhoneNumber() {

        int selectedStudentIndex = studentNameComboBox.getSelectedIndex();
        String momPhoneNumber = momPhone[selectedStudentIndex].toString();

        StringBuilder str = new StringBuilder(momPhoneNumber);
        str.insert(0, "(");
        str.insert(4, ")");
        str.insert(8, "-");

        return str.toString();
    }

    public static void main(String[] args) {
        new StudentContact();
    }
}