import java.awt.*;

public class CommonConstants {
    public static final Dimension GUI_SIZE = new Dimension(400, 600);

    // Banner configuration
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

    // Task panel configuration
    public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);

    // Add task button configuration
    public static final Dimension ADDTASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);
    
    // Task component configurations
    public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.81), 50);
    public static final Dimension CHECKBOX_SIZE = new Dimension(30, 30);
    public static final Dimension DELETE_BUTTON_SIZE = new Dimension(50, 30);
}
