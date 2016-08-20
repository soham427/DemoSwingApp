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

class LoginWindow extends JFrame {
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
        * This is the recommended way to implement EventListeners using Anonymous classes
        * An Anonymous class is simply a class without a name and reference. There is
        * * no way access it or change. It's simply used to inject functionality into other objects
        * * They behave just like an inner class and can be replaced if functionality needs to be shared
        * * For e.g. if we had two buttons doing the exact same thing
        *
        * The first button implements them normally
        * The second button uses a lambda expression to inject the same functionality
        * * And as the syntax indicates, no object is being created in this case
        * * It's behaving more like assigning a delegate (only provides a method instead of an object)
        * * Lambda injection is only useful when the interface only has a single method
        */
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a test JFrame and display
                JFrame newWindow = new JFrame("Test Window");
                newWindow.setBounds(SCREEN_POS_X, SCREEN_POS_Y, SCREEN_WIDTH, SCREEN_HEIGHT / 2);
                newWindow.setVisible(true);
            }
        });

        // Lambda expressions require Language level 8 or above
        btnClear.addActionListener(e -> {
            txtPassword.setText("");
            txtUserId.setText("");
        });
    }
}
