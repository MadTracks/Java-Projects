public class ComparatorThread extends Thread {
    public ComparatorThread(PriorityQ queue,String name,int pixelsize){
        threadqueue=queue;
        threadname=name;
        pixel=pixelsize;
    }
    @Override
    public void run() {
        try {
            RGBcolor element;
            int i=0;
            while (i<pixel) {
                System.out.println(threadname + threadqueue.remove_max());
                i++;
            }
        }
        catch (InterruptedException e){
            System.out.println("Threads interrupted.");
        }
    }
    String threadname;
    PriorityQ threadqueue;
    int pixel;
}
