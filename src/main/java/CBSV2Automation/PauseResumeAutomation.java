package CBSV2Automation;

public class PauseResumeAutomation extends Base {

    public static void checkPause() {
        synchronized (lock) {
            while (paused) {
                try {
                    lock.wait(); // Pause execution
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void togglePause() {
        synchronized (lock) {
            paused = !paused;
            if (!paused) {
                lock.notify(); 
            }
        }
    }

    public static boolean isPaused() {
        return paused;
    }
}
