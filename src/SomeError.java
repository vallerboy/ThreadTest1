import java.util.Vector;

public class SomeError {
    public static void main(String[] args) {
        Value age = new Value();
        age.setAge(10);

        for (int i = 0; i < 5000; i++) {
            new SomeThreadTask(age).start();
            System.out.println(age.getAge());
        }

    }

    public static class Value{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    //Drugi sposob
    public static class SomeThreadTask extends Thread {
        private Value age;
        public SomeThreadTask(Value age) {
            this.age = age;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 5000; i++) {
                age.setAge(age.getAge() + 1);
                age.setAge(age.getAge() - 1);
            }
        }
    }

}

