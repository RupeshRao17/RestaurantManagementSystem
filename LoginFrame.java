import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        super("Login");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());  //GridBagLayout is a flexible layout manager that arranges components in a grid of cells, allowing components to span multiple rows and columns and specifying how components should be positioned and stretched within their cells.
        GridBagConstraints gbc = new GridBagConstraints(); //The GridBagConstraints class in Java Swing is used to specify constraints for components when they are added to a GridBagLayout. This layout manager allows components to be placed in a grid-like format, where each component can span multiple rows and columns and have different alignment and padding settings.
        gbc.insets = new Insets(5, 5, 5, 5); 
      

        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon adminIcon = new ImageIcon("images/login.jpg"); // Replace "admin.png" with your image file path
        Image scaledImage = adminIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Set image size to 200 pixels
        JLabel adminImageLabel = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);

        JLabel adminLabel = new JLabel("Admin", SwingConstants.CENTER);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increase font size

        imagePanel.add(adminImageLabel, BorderLayout.CENTER);
        imagePanel.add(adminLabel, BorderLayout.SOUTH);

        gbc.gridx = 0;  // It specifies the column index of the cell in which the component should be placed. The leftmost column has a gridx value of 0, and the index increases as you move to the right.
        gbc.gridy = 0; // It specifies the row index of the cell in which the component should be placed. The topmost row has a gridy value of 0, and the index increases as you move down.
        gbc.gridwidth = 2; //It defines the number of columns that the component should span. For example, if gridwidth is set to 2, the component will occupy two adjacent columns in the grid layout.
        panel.add(imagePanel, gbc); // Add the image panel

        gbc.gridy++; //Pushes To Next Row
        gbc.gridwidth = 1; //specifies content will only occupy one cell

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15); // Set text field size to 15 columns

        gbc.anchor = GridBagConstraints.WEST; //aligns left
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1; //moves the position to next column
        gbc.fill = GridBagConstraints.HORIZONTAL; //fill specifeis the next component will occupy the remaining space horizontally
        panel.add(usernameField, gbc); // Combine label and text field

        gbc.gridy++; //next row
        gbc.gridx = 0; //reset to zero to start at first column again
        gbc.fill = GridBagConstraints.NONE; //removes the fill constraint

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15); // Set text field size to 15 columns
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(passwordField, gbc); // Combine label and text field

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2; //indicates that the component will span across two columns
        gbc.anchor = GridBagConstraints.CENTER; //aligns to center

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30)); // Set button size
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Check if the username and password match predefined values
                if (username.equals("admin") && password.equals("password")) {
                    // If login successful, close the login frame
                    dispose();
                    // Open the RestaurantManagementSystem frame
                    new RestaurantManagementSystem();
                } else {
                    // Show error message for incorrect credentials
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }
        });
    }
}