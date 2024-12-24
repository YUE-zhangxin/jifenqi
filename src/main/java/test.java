import java.nio.ByteBuffer;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class test {
    public static void main(String[] args) {
        ConcurrentHashMap<Long, ArrayBlockingQueue<String>> queueSendMap = new ConcurrentHashMap<>();
        System.out.println("创建成功queueSendMap：" + queueSendMap);
        ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(1024);
        //queueSendMap.putIfAbsent(1L, bq);
        ArrayBlockingQueue<String> oldq = queueSendMap.putIfAbsent(1L, bq);
        System.out.println(oldq);
        System.out.println(queueSendMap);
        if (oldq != null) {
            oldq.add("oldq");
        } else {
            bq.add("bq");
        }
        System.out.println(queueSendMap);


        final ByteBuffer lenBuffer = ByteBuffer.allocateDirect(4);

        ByteBuffer incomingBuffer = lenBuffer;

        boolean initialize = false;

        if(incomingBuffer == lenBuffer){
            System.out.println(1);
        }else if (!initialize){
            System.out.println(2);
        }

    }


}
