package by.pw.crr.metla.dao;

import by.pw.crr.metla.entities.ChatUser;

public class ChatUserDAO extends GenericDAOImpl<ChatUser, Long> {

    public ChatUserDAO() {
        super(ChatUser.class);
    }
}
