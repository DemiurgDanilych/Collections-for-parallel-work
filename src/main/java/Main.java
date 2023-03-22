import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    static final int NUMBER_OF_TEXT = 10_000;
    static final int TEXT_LENGH = 100_000;
    static final String SYMBOLS = "abc";

    static BlockingQueue<String> queueForA = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueForB = new ArrayBlockingQueue<>(100);
    static BlockingQueue<String> queueForC = new ArrayBlockingQueue<>(100);

    public static void main(String[] args){

        Thread threadA = new Handler(queueForA,'a');
        Thread threadB = new Handler(queueForB,'b');
        Thread threadC = new Handler(queueForC,'c');


        new Thread(() ->{
            System.out.println("Началась генерация текста");
            for (int i = 0; i < NUMBER_OF_TEXT; i++) {
                String text = generateText(SYMBOLS, TEXT_LENGH);
                try {
                    queueForA.put(text);
                    queueForB.put(text);
                    queueForC.put(text);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        threadA.start();
        threadB.start();
        threadC.start();



    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}