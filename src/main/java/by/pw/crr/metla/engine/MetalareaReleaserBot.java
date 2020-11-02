package by.pw.crr.metla.engine;

import by.pw.crr.metla.dao.ChatUserDAO;
import by.pw.crr.metla.dao.MetalareaReleaseDAO;
import by.pw.crr.metla.entities.ChatUser;
import by.pw.crr.metla.entities.MetalareaRelease;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MetalareaReleaserBot extends TelegramLongPollingBot {

    private final ChatUserDAO userDAO = new ChatUserDAO();
    private final MetalareaReleaseDAO releaseDAO = new MetalareaReleaseDAO();


    //todo more improved time task impl needed
    public MetalareaReleaserBot() {
        Runnable updatingTask = this::updateReleases;
        Thread updatingThread = new Thread(updatingTask);
        updatingThread.start();

        Runnable sendingTask = this::sendReleases;
        Thread sendingThread = new Thread(sendingTask);
        sendingThread.start();
    }


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("/start")) {
                    ChatUser chatUser = new ChatUser();
                    chatUser.setChatId(update.getMessage().getChatId());
                    chatUser.setUsername(update.getMessage().getFrom().getUserName());
                    userDAO.update(chatUser);
                }
            }
        }
    }

    @SneakyThrows
    private void sendReleases() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        while (true) {
            for (MetalareaRelease metalareaRelease : releaseDAO.findAll()) {
                if (!metalareaRelease.isSent()) {
                    for (ChatUser user : userDAO.findAll()) {
                        sendMessage.setChatId(user.getChatId());
                        sendMessage.setText(metalareaRelease.toString());
                        execute(sendMessage);
                        metalareaRelease.setSent(true);
                        releaseDAO.update(metalareaRelease);
                    }
                    Thread.sleep(3_125);
                }
            }
            Thread.sleep(300_000);
        }
    }

    @SneakyThrows
    private void updateReleases() {
        MetalareaParser.INSTANCE.parseReleases().forEach(releaseDAO::update);
        Thread.sleep(300_000);
    }

    @Override
    public String getBotUsername() {
        return "MetlaReleasesBot";
    }

    @Override
    public String getBotToken() {
        return "1212582110:AAFJY4cF4cDP7CD5clgtiLnsd4amk5BoHjQ";
    }
}
