/*
   Name : Dewey Milton
   Date : 29 November 2016
   Purpose : Creates a Panel to submit Address information
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ASUS on 11/29/2016.
 */
public class AddressPanel {

    private JFrame frame;
    private JPanel inputPanel;
    private GridBagConstraints c;
    private JLabel nameL;
    private JTextField name;
    private JLabel telL;
    private JTextField tel;
    private JLabel emailL;
    private JTextField email;
    private JLabel addrL;
    private JTextField addr;
    private JLabel dobL;
    private JTextField dob;
    private JPanel buttP;
    private JButton addFront;
    private JButton addRear;
    private JButton cancel;
    private AddressList list;

    /*
       Name : AddressPanel
       @param AddressList to add new address to the Address list
     */
    public AddressPanel(AddressList newList){
      frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("Input Address");
        frame.setVisible(true);
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.list = newList;

        inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setVisible(true);
        inputPanel.setBackground(new Color(100, 128, 250));
        inputPanel.setPreferredSize(new Dimension(500, 400));
        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, 20, 20, 20);

        nameL = new JLabel("Name: ");
        nameL.setVisible(true);
        inputPanel.add(nameL, c);

        c.gridx = 1;
        name = new JTextField("");
        name.setEditable(true);
        name.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(name, c);

        c.gridx = 0;
        c.gridy = 1;
        telL = new JLabel("Telephone Number: ");
        telL.setVisible(true);
        inputPanel.add(telL, c);

        c.gridx = 1;
        tel = new JTextField("");
        tel.setEditable(true);
        tel.setVisible(true);
        tel.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(tel, c);

        c.gridx = 0;
        c.gridy = 2;
        emailL = new JLabel("Email Address: ");
        emailL.setVisible(true);
        inputPanel.add(emailL, c);

        c.gridx = 1;
        email = new JTextField("");
        email.setVisible(true);
        email.setEditable(true);
        email.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(email, c);

        c.gridx = 0;
        c.gridy = 3;
        addrL = new JLabel("Address: ");
        addrL.setVisible(true);
        inputPanel.add(addrL, c);

        c.gridx = 1;
        addr = new JTextField("");
        addr.setEditable(true);
        addr.setVisible(true);
        addr.setPreferredSize(new Dimension(200, 25));
        inputPanel.add(addr, c);

        c.gridx = 0;
        c.gridy = 4;
        dobL = new JLabel("Date of Birth: ");
        dobL.setVisible(true);
        inputPanel.add(dobL, c);

        c.gridx = 1;
        dob = new JTextField("");
        dob.setVisible(true);
        dob.setEditable(true);
        dob.setPreferredSize(new Dimension(200,25));
        inputPanel.add(dob, c);

        buttP = new JPanel(new FlowLayout(50,25,25));
        buttP.setVisible(true);
        buttP.setPreferredSize(new Dimension(500, 100));
        buttP.setBackground(new Color(100, 128, 250));
        frame.getContentPane().add(buttP, BorderLayout.SOUTH);

        addFront = new JButton("Add to the Front");
        addFront.setVisible(true);
        addFront.setPreferredSize(new Dimension(125, 25));
        buttP.add(addFront);

        /*
           Adds address to the front of an Address List
         */
        addFront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.addToFront(name.getText(), tel.getText(), email.getText(), addr.getText(), dob.getText());
                frame.dispose();
            }
        });

        addRear = new JButton("Add to the Rear");
        addRear.setVisible(true);
        addRear.setPreferredSize(new Dimension(125, 25));
        buttP.add(addRear);

        /*
           Adds address to the rear of an Address List
         */
        addRear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.addToBack(name.getText(), tel.getText(), email.getText(), addr.getText(), dob.getText());
                frame.dispose();
            }
        });

        cancel = new JButton("Cancel");
        cancel.setVisible(true);
        cancel.setPreferredSize(new Dimension(100, 25));
        buttP.add(cancel);


        /*
           Cancels the address add
         */
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


    }


}
