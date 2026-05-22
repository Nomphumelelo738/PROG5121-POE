package com.mycompany.login;

import java.util.ArrayList;
import java.util.Random;

public class Message {

    private static final ArrayList<String[]> sentMessages = new ArrayList<>();
    private static int totalMessagesSent = 0;

    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String messageText;
    private final String messageHash;

    public Message(int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {

        Random rand = new Random();

        long id = (long)(rand.nextDouble() * 9000000000L)
                + 1000000000L;

        return String.valueOf(id);
    }

    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord
                + lastWord).toUpperCase();
    }

    public static String checkMessageLength(String message) {

        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            return "Message exceeds 250 characters.";
        }
    }

    public String sendMessage() {

        totalMessagesSent++;

        sentMessages.add(
                new String[]{
                    messageID,
                    messageHash,
                    recipient,
                    messageText
                });

        return "Message successfully sent.";
    }

    public static String printMessages() {

        if (sentMessages.isEmpty()) {
            return "No messages sent.";
        }

        StringBuilder sb = new StringBuilder();

        for (String[] msg : sentMessages) {

            sb.append("Message ID: ")
              .append(msg[0])
              .append("\n");

            sb.append("Hash: ")
              .append(msg[1])
              .append("\n");

            sb.append("Recipient: ")
              .append(msg[2])
              .append("\n");

            sb.append("Message: ")
              .append(msg[3])
              .append("\n\n");
        }

        return sb.toString();
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }
}

    

