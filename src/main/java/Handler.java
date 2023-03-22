import java.util.concurrent.BlockingQueue;

public class Handler extends Thread{

    private BlockingQueue<String> queue;
    private char symbol;

    public Handler(BlockingQueue<String> queue,char symbol) {
        this.queue = queue;
        this.symbol = symbol;
    }


    @Override
    public void run() {
        System.out.println("Начинаю поиск " + symbol);
        while (true){
            String text;

            try {
                text = queue.take();
                int maxSize = 0;
                for (int i = 0; i < text.length(); i++) {
                    for (int j = 0; j < text.length(); j++) {
                        if (i >= j) {
                            continue;
                        }
                        boolean wrongFound = false;
                        for (int k = i; k < j; k++) {
                            if (text.charAt(k) != symbol) {
                                wrongFound = true;
                                break;
                            }
                        }
                        if (!wrongFound && maxSize < j - i) {
                            maxSize = j - i;
                        }
                    }
                }
                System.out.println(text.substring(0, 100) + " -> " + maxSize + " Символ " + symbol);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.isEmpty()){
                System.out.println("Обработчик символа " + symbol + " закончил работу.");
                interrupted();
            }
        }

    }
}
