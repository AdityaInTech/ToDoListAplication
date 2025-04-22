import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {
    JTextField taskField;
    JButton addButton, deleteButton;
    JPanel taskPanel;

    public ToDoListApp() {
        setTitle("To-Do List ");
        setSize(600, 400);

        setLayout(new BorderLayout());


        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Completed Tasks");

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.NORTH);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskText = taskField.getText();
                   JCheckBox taskCheckBox = new JCheckBox(taskText);
                    taskPanel.add(taskCheckBox);
                    taskPanel.revalidate();
                    taskField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] components = taskPanel.getComponents();

                for (int i = components.length - 1; i >= 0; i--) {
                    JCheckBox box = (JCheckBox) components[i];
                    if (box.isSelected()) {
                        taskPanel.remove(box);
                    }
                }

                taskPanel.revalidate();
                taskPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        new ToDoListApp().setVisible(true);  // Create an instance of the ToDo List app and make it visible
    }
}
