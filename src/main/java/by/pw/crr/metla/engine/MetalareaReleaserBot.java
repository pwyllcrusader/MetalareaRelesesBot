package by.pw.crr.metla.engine;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MetalareaReleaserBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

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
