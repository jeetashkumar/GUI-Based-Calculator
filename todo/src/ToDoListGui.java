import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class ToDoListGui extends JFrame implements ActionListener {
    private JPanel taskPanel, taskComponentJPanel;

    public ToDoListGui() {
        super("TO DO LIST APPLICATION");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(CommonConstants.GUI_SIZE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        addGuiComponents();
    }

    private void addGuiComponents() {
        JLabel bannerLabel = new JLabel("TO DO LIST", SwingConstants.CENTER);
        bannerLabel.setFont(createFont("LEMONMILT-Light.otf", 24f));
        bannerLabel.setPreferredSize(CommonConstants.BANNER_SIZE);
        add(bannerLabel, BorderLayout.NORTH);

        taskComponentJPanel = new JPanel();
        taskComponentJPanel.setLayout(new BoxLayout(taskComponentJPanel, BoxLayout.Y_AXIS));
        
        taskPanel = new JPanel(new BorderLayout());
        taskPanel.add(taskComponentJPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(taskComponentJPanel);
        scrollPane.setPreferredSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        add(scrollPane, BorderLayout.CENTER);

        JButton addTaskButton = new JButton("ADD TASK");
        addTaskButton.setFont(createFont("LEMONMILK.otf", 26f));
        addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addTaskButton.addActionListener(this);
        add(addTaskButton, BorderLayout.SOUTH);
    }

    private Font createFont(String resource, float size) {
        try {
            File customFontFile = new File(getClass().getClassLoader().getResource(resource).toURI());
            return Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(size);
        } catch (Exception e) {
            System.out.println("Error loading font: " + e.getMessage());
            return new Font("SansSerif", Font.PLAIN, (int) size);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("ADD TASK")) {
            TaskComponent taskComponent = new TaskComponent(taskComponentJPanel);
            taskComponentJPanel.add(taskComponent);
            
            if (taskComponentJPanel.getComponentCount() > 1) {
                TaskComponent previousTask = (TaskComponent) taskComponentJPanel.getComponent(
                        taskComponentJPanel.getComponentCount() - 2);
                previousTask.getTaskField().setBackground(null);
            }
            
            taskComponent.getTaskField().requestFocus();
            taskComponentJPanel.revalidate();
            taskComponentJPanel.repaint();
        }
    }
}
