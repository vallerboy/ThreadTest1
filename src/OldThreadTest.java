public class OldThreadTest {
    public static void main(String[] args) {


        Runnable someTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    System.out.println("Witaj, jestem z watku nr 1");
                    Thread.yield();
                }
            }
        };

        Thread thread = new Thread(someTask);
        thread.start();

        for (int i = 0; i < 5000; i = i + 1) {
            System.out.println("Witaj, jestem z watku nr 0");
            Thread.yield();
        }
    }
}
