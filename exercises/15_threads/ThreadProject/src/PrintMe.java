/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOLLANDV
 */
class PrintMe implements Runnable {
    public void run() {
            for (int i=1;i<=10;i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                }
                catch (Exception e) {
                                            // sleep interrupted
                }
            
            }
    }
}
