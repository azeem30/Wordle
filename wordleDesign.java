package wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class wordleDesign extends JFrame implements ActionListener
{
    JPanel panel;
    static ArrayList<JTextField> textFields = new ArrayList<>();
    JButton check;
    JLabel chances;
    int tries = 5;
    wordleDesign()
    {
        createFrame();
        createPanel();
        createTextFields();
        updateChances();
        checkWord();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void createFrame()
    {
        setSize(500,500);
    }
    void createPanel()
    {
        panel = new JPanel();
        panel.setBounds(90,80,300,100);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBackground(Color.GRAY);
        add(panel);
    }

    void createTextFields()
    {
        for(int i=0;i<wordleLogic.sizeOfWord;i++)
        {
            textFields.add(new JTextField());
            textFields.get(i).setFont(new Font("Tahoma",Font.BOLD,32));
            textFields.get(i).setHorizontalAlignment(JTextField.CENTER);
        }
        for(int i =0 ; i< wordleLogic.sizeOfWord; i++)
        {
            panel.add(textFields.get(i));
        }
    }

    void checkWord()
    {
        check= new JButton("Check");
        check.setBounds(200,400,100,40);
        check.addActionListener(this);
        add(check);
    }

    void updateChances()
    {
        chances = new JLabel("Chances remaining "+ tries);
        chances.setBounds(150,300,200,40);
        add(chances);
    }

    public static void main(String[] args) {
        new wordleLogic();
        new wordleDesign();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==check)
        {
            if(tries >0)
            {
                for (int j = 0; j < wordleLogic.sizeOfWord; j++) {
                    if (wordleLogic.matchExactLetter(j))
                    {
                        textFields.get(j).setBackground(Color.green);
                    }
                    else if (wordleLogic.matchLetter(j))
                    {
                        textFields.get(j).setBackground(Color.yellow);
                    }
                    else
                    {
                        textFields.get(j).setBackground(Color.WHITE);
                    }
                }
                tries -= 1;
                chances.setText("Chances remaining " + tries);
            }
            else
            {
            JOptionPane.showMessageDialog(null,"Sorry! You couldn't guess the word.");
            System.exit(0);
            }
        }
    }
}
