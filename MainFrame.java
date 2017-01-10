/*
   Name : Dewey Milton
   Date : 29 November 2016
   Purpose : Creates a GUI for the Address List Class
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private JFrame frame;
    private JPanel screen;
    private JTextArea display;
    private JScrollPane scrollP;
    private JPanel screenPanel;
    private JPanel inputPanel;
    private GridBagConstraints c;
    private JTextField inputBar;
    private JButton telByName;
    private JButton mailByName;
    private JButton dobByName;
    private JButton nameByTel;
    private JPanel lowerP;
    private JButton addNew;
    private JButton show;
    private JButton showRev;
    private JButton stringRev;
    private JButton getSize;
    private JButton isEmpty;
    private  AddressList list;


    public MainFrame(){

        this.list = new AddressList();

         frame = new JFrame();
         frame.setSize(800, 800);
         frame.setTitle("Address Book");
        frame.setBackground(new Color(32,15,128));

        screenPanel = new JPanel(new FlowLayout(15, 15, 15));
        screenPanel.setVisible(true);
        screenPanel.setPreferredSize(new Dimension(550,600));
        screenPanel.setBackground(new Color(5,30, 5));
        frame.getContentPane().add(screenPanel, BorderLayout.LINE_START);

        screen = new JPanel(new BorderLayout());
        screen.setSize(400, 400);
        screen.setPreferredSize(new Dimension(525,575));
        screen.setBackground(new Color(11, 15,255));
        screen.setVisible(true);
        screen.setLayout(new BorderLayout());
        screenPanel.add(screen);

        display = new JTextArea("");
        display.setEditable(false);
        display.setLineWrap(false);
        display.setPreferredSize(new Dimension(525, 550));
        display.setBackground(new Color(255, 251, 198));
        display.setVisible(true);
        scrollP = new JScrollPane(display);
        screen.add(scrollP);


        inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setVisible(true);
        inputPanel.setPreferredSize(new Dimension(225,600));
        inputPanel.setBackground(new Color(71,76,223));
        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20,10,20,10);

        inputBar = new JTextField("");
        inputBar.setEditable(true);
        inputBar.setVisible(true);
        inputBar.setPreferredSize(new Dimension(200,25));
        inputPanel.add(inputBar, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 10, 5, 10);
        telByName = new JButton("Search Telephone Number by Name");
        telByName.setVisible(true);
      //  telByName.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(telByName, c);

        /*
           Displays telephone number associated to given name
         */
        telByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = list.phoneNumberByName(inputBar.getText());
                inputBar.setText("");
                display.setText(input);
            }
        });

        c.gridy = 2;
        mailByName = new JButton("Search E-mail by Name");
        mailByName.setVisible(true);
        mailByName.setPreferredSize(new Dimension(200,25));
        inputPanel.add(mailByName, c);

        /*
          Displays email associated to given name
         */
        mailByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = list.emailByName(inputBar.getText());
                inputBar.setText("");
                display.setText(input);
            }
        });

        c.gridy = 3;
        dobByName = new JButton("Search Date of Birth by Name");
        dobByName.setVisible(true);
        dobByName.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(dobByName, c);

        /*
           Displays Date of Birth associated to by given name
         */
        dobByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = list.dobByName(inputBar.getText());
                inputBar.setText("");
                display.setText(input);
            }
        });

        c.gridy = 4;
        nameByTel = new JButton("Search Name by Telephone Number");
        nameByTel.setVisible(true);
        nameByTel.setPreferredSize(new Dimension(200,25));
        inputPanel.add(nameByTel, c);

        /*
          Displays name associated to by given telephone number
         */
        nameByTel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(list.nameByPhoneNumber(inputBar.getText()));
                inputBar.setText("");
            }
        });

        lowerP = new JPanel(new FlowLayout(10, 10, 10));
        lowerP.setVisible(true);
        lowerP.setPreferredSize(new Dimension(800, 100));
        lowerP.setBackground(new Color(150, 200, 180));
        frame.getContentPane().add(lowerP, BorderLayout.SOUTH);

        addNew = new JButton("Add new Address");
        addNew.setVisible(true);
        addNew.setPreferredSize(new Dimension(200,25));
        lowerP.add(addNew);

        show = new JButton("Show Address List");
        show.setVisible(true);
        show.setPreferredSize(new Dimension(200,25));
        lowerP.add(show);

        /*
          Display address list
         */
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = list.toString();
                display.setText(input);
            }
        });

        showRev = new JButton("Reverse List");
        showRev.setVisible(true);
        showRev.setPreferredSize(new Dimension(200, 25));
        lowerP.add(showRev);

        /*
           Create new address list in reverse
         */
        showRev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = list.reverse();
            }
        });

        getSize = new JButton("Show Size");
        getSize.setVisible(true);
        getSize.setPreferredSize(new Dimension(200, 25));
        lowerP.add(getSize);

        /*
          Displays size of address list
         */
        getSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = "" + list.sizeOf();
                display.setText(input);
            }
        });

        isEmpty = new JButton("Show is Empty");
        isEmpty.setVisible(true);
        isEmpty.setPreferredSize(new Dimension(200, 25));
        lowerP.add(isEmpty);

        /*
          displays if an address list is empty
         */
        isEmpty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = "" + list.isEmpty();
                display.setText(input);
            }
        });

        stringRev = new JButton("Show list in Reverse");
        stringRev.setVisible(true);
        stringRev.setPreferredSize(new Dimension(200, 25));
        lowerP.add(stringRev);

        /*
           calls a recursive toString method to display in reverse
         */

        stringRev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = list.reverseToString();
                  display.setText(input);
            }
        });

        /*
           Add new Address to the list
         */
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddressPanel panel = new AddressPanel(list);
            }
        });

    }

    /*
        Name : Run
        Starts the GUI
     */
    public void run(){
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
