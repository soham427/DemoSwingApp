package com.pass;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        new LoginWindow("Login");
    }
}

class LoginWindow extends JFrame implements ActionListener {
    // Constants
    private final int SCREEN_POS_X = 500;
    private final int SCREEN_POS_Y = 250;
    private final int SCREEN_WIDTH = 300;
    private final int SCREEN_HEIGHT = 280;
    private final int COMP_GAP = 30;

    // Components
    private JButton btnClear, btnLogin;
    private JLabel lblHeading, lblUserId, lblPassword;
    private JTextField txtUserId, txtPassword;
    private JPanel panelHeading, panelUserName, panelPassword, panelControls;

    LoginWindow(String title) {
        setTitle(title);
        setBounds(SCREEN_POS_X, SCREEN_POS_Y, SCREEN_WIDTH, SCREEN_HEIGHT);
        setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        addComponents();
        addListeners();
        setVisible(true);
    }

    private void addComponents() {
        /*
        * The layout managers require a bit more code but the added code is understandable and intuitive
        * Making a GUI change is relatively easier and all components are structured logically.
         */
        panelHeading = new JPanel();
        panelHeading.setLayout(new BoxLayout(panelHeading, BoxLayout.LINE_AXIS));
        panelUserName = new JPanel();
        panelUserName.setLayout(new BoxLayout(panelUserName, BoxLayout.LINE_AXIS));
        panelPassword =  new JPanel();
        panelPassword.setLayout(new BoxLayout(panelPassword, BoxLayout.LINE_AXIS));
        panelControls = new JPanel();
        panelControls.setLayout(new BoxLayout(panelControls, BoxLayout.LINE_AXIS));

        lblHeading = new JLabel("Enter Password", SwingConstants.CENTER);

        lblUserId = new JLabel("Username:");
        lblPassword = new JLabel("Password:");

        txtUserId = new JTextField();
        txtUserId.setMaximumSize(new Dimension(COMP_GAP * 3, COMP_GAP));
        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(COMP_GAP * 3, COMP_GAP));

        btnClear = new JButton("Clear");
        btnLogin = new JButton("Login");

        // Heading
        panelHeading.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelHeading.add(lblHeading);
        panelHeading.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap

        // Username
        panelUserName.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelUserName.add(lblUserId);
        panelUserName.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelUserName.add(txtUserId);
        panelUserName.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap

        // Password
        panelPassword.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelPassword.add(lblPassword);
        panelPassword.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelPassword.add(txtPassword);
        panelPassword.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap

        // Buttons
        panelControls.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelControls.add(btnClear);
        panelControls.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap
        panelControls.add(btnLogin);
        panelControls.add(Box.createRigidArea(new Dimension(COMP_GAP, 0))); // Horizontal gap

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)); // JFrame's layout
        add(Box.createRigidArea(new Dimension(new Dimension(0, COMP_GAP)))); // Vertical gap
        add(panelHeading);
        add(Box.createRigidArea(new Dimension(new Dimension(0, COMP_GAP)))); // Vertical gap
        add(panelUserName);
        add(Box.createRigidArea(new Dimension(new Dimension(0, COMP_GAP)))); // Vertical gap
        add(panelPassword);
        add(Box.createRigidArea(new Dimension(new Dimension(0, COMP_GAP)))); // Vertical gap
        add(panelControls);
        add(Box.createRigidArea(new Dimension(new Dimension(0, COMP_GAP)))); // Vertical gap
    }

    private void addListeners() {
        /*
        * Notice! 'this' object is being looked at as an ActionListener
        * It's actually a JFrame. This is how interfaces encapsulate data.
        * The JButtons receiving the object can only access the actionPerformed() method
        * i.e. Sharing required functionality without exposing all class fields.
        */
        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch-Case is better than IF-ELSE
        switch (e.getActionCommand()) {
            case "Clear":
                txtPassword.setText("");
                txtUserId.setText("");
                break;
            case "Login":
                // Create a test JFrame and display
                JFrame newWindow = new JFrame("Test Window");
                newWindow.setBounds(SCREEN_POS_X, SCREEN_POS_Y, SCREEN_WIDTH, SCREEN_HEIGHT / 2);
                newWindow.setVisible(true);
                break;
            default:
                break; // Do nothing here. But having a default condition is good practice
        }
    }
}
