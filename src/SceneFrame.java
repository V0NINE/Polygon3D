import javax.swing.JFrame;

public class SceneFrame extends JFrame{

    private JFrame frame;

    public SceneFrame(ScenePanel scenePanel) {
        this.frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scenePanel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
