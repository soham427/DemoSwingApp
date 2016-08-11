package com.pass;

import java.awt.Dimension;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        new LoginWindow("Login");
    }
}

class LoginWindow extends JFrame {
    // Constants
    private final int SCREEN_POS_X = 500;
    private final int SCREEN_POS_Y = 250;
    private final int SCREEN_WIDTH = 300;
    private final int SCREEN_HEIGHT = 250;

    // Components
    private JButton btnClear, btnLogin;
    private JLabel lblHeading, lblUserId, lblPassword;
    private JTextField txtUserId, txtPassword;

    LoginWindow(String title) {
        setTitle(title);
        setBounds(SCREEN_POS_X, SCREEN_POS_Y, SCREEN_WIDTH, SCREEN_HEIGHT);
        setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        addComponents();
        setLayout(null); // required to stop the default Layout Manager from overriding setBounds() of components
        setVisible(true);
    }

    private void addComponents() {
        /*
        * All the numbers used in setting the components' bounds are highly unintuitive and not scalable
        * The implementation requires less code but is pain to maintain
        * For e.g. Simply adding a new component to this design will require re-adjusting most of the components.
         */
        lblHeading = new JLabel("Enter Password", SwingConstants.CENTER);
        lblHeading.setBounds(0,10,SCREEN_WIDTH - 20, 20);

        lblUserId = new JLabel("User ID:");
        lblUserId.setBounds(30,60,SCREEN_WIDTH/3, 20);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30,100,SCREEN_WIDTH/3, 20);

        txtUserId = new JTextField();
        txtUserId.setBounds(SCREEN_WIDTH/3 + 50, 60, SCREEN_WIDTH/3, 20);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(SCREEN_WIDTH/3 + 50, 100, SCREEN_WIDTH/3, 20);

        btnClear = new JButton("Clear");
        btnClear.setBounds(20, 160, SCREEN_WIDTH/3, 30);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(SCREEN_WIDTH/3 + 65, 160, SCREEN_WIDTH/3, 30);

        add(lblHeading);
        add(lblUserId);
        add(lblPassword);
        add(txtUserId);
        add(txtPassword);
        add(btnClear);
        add(btnLogin);
    }
}
