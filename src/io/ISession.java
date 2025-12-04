package io;

/**
 * @author Ghost
 *
 */
public interface ISession {

    public abstract boolean isConnected();
    public abstract void sendMessage(Message message);
    public abstract void close();

}
