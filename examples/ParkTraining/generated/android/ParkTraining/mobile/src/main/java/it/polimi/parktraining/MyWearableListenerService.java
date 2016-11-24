package it.polimi.parktraining;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;
import java.util.HashMap;
import java.util.Map;

public class MyWearableListenerService extends WearableListenerService {

    public static Map<String, String> messages = new HashMap<>();

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        String messagePath = messageEvent.getPath();
        byte[] messageData = messageEvent.getData();
        String messageContent = new String(messageData);

        //Change messagePath if exists
        String tmpPath = messagePath;
        int i = 0;
        while(messages.containsKey(tmpPath)) {
            tmpPath = messagePath + "_" + i;
            i++;
        }

        //Collect messages
        messages.put(tmpPath, messageContent);

        //You can reference to the messages from any activity like this
        //Map<String, String> messages = MyWearableListenerService.messages;
        //int numMessages = messages.size();
		//String lastMessage = (String) messages.values().toArray()[0];

    }

}
