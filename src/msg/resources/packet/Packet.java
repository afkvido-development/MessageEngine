package msg.resources.packet;

import msg.i;
import msg.resources.message.TextMessage;

public class Packet {

    private final String UserToken;

    private final String MessageContent;

    private final TextMessage Message;

    private final String messageID;

    private final String constructedPacket;


    public Packet (String userToken, TextMessage message) {

        this.UserToken = userToken;
        this.Message = message;
        this.MessageContent = message.getContent();
        this.messageID = message.getMessageID();


        this.constructedPacket = "{" + "\"userToken\":\"" + this.UserToken + "\",\"message\":\"" + this.MessageContent + "\",\"messageID\":\"" + this.messageID + "\"}";
        i.debugLine("Packet", i.gray + this.constructedPacket);

    }


    public void send () {
        // TODO
        // Use HTTPS encryption to send the message
        // Use the user token to identify the user
        // Finally, we'll make an HTTP POST request to the server
    }


}
