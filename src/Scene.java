public class Scene implements Runnable{
    
    private ScenePanel scenePanel;
    @SuppressWarnings("unused")
    private SceneFrame sceneFrame;
    private Thread thread;
    private final int FPS = 120;

    public Scene() {
        scenePanel = new ScenePanel();
        sceneFrame = new SceneFrame(scenePanel);
        scenePanel.requestFocus();
        startLoop();
    }

    public void startLoop() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int frames = 0;
        double timePerFrame = 1000000000.0/FPS;
        long currentTime, previousTime = System.nanoTime();
        long lastChecked = System.currentTimeMillis();

        while(true)
        {
            currentTime = System.nanoTime();

            if((currentTime - previousTime) >= timePerFrame)
            {
                previousTime = currentTime;
                frames++;
                scenePanel.repaint();
            }

            if(System.currentTimeMillis() - lastChecked >= 1000){
                lastChecked = System.currentTimeMillis();
                System.out.println("FPS " + frames);
                frames = 0;
            }
        }
    }
}
