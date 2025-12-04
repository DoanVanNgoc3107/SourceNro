package io;

public interface IMessageHandler {

    void onConnectOK();

    void onConnectionFail();

    void onDisconnected();

    void onMessage(Message message);
}
