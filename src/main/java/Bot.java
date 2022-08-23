import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "AudioAlex_Bot";
    }

    @Override
    public String getBotToken() {
        return "5703962531:AAFARELxw9XFJoNsqt9RDpAFL6NG7JL8Soo";
    }
//Egzod CQACAgIAAxkBAAMHYwSnnpQHEJNzaAv_03Y22NfrpgMAApIfAALYoCBI2kZQYYHmuSQpBA
//Rammstein -CQACAgIAAxkBAAMJYwSn5pG_edsRqnHFhMEDKpkTNGIAApYfAALYoCBIqN4M8cdfBKgpBA
//ДДТ -CQACAgIAAxkBAAMLYwSoLYXwjWYQbGfLmqTvI3EwIuYAApgfAALYoCBIbUxohaV2PRgpBA


    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        KeyboardRow keyboardRow1=new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Rammstein"));
        KeyboardRow keyboardRow2=new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("ДДТ"));
        keyboardRow2.add(new KeyboardButton("Egzod"));

        List<KeyboardRow> list=new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);

        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendAudio sendAudio= new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile=new InputFile();

        switch (update.getMessage().getText()){
            case"Rammstein":
                inputFile.setMedia("CQACAgIAAxkBAAMJYwSn5pG_edsRqnHFhMEDKpkTNGIAApYfAALYoCBIqN4M8cdfBKgpBA");
                break;
            case "ДДТ":
                inputFile.setMedia("CQACAgIAAxkBAAMLYwSoLYXwjWYQbGfLmqTvI3EwIuYAApgfAALYoCBIbUxohaV2PRgpBA");
                break;
            case "Egzod":
                inputFile.setMedia("CQACAgIAAxkBAAMHYwSnnpQHEJNzaAv_03Y22NfrpgMAApIfAALYoCBI2kZQYYHmuSQpBA");
                break;
        }
        sendAudio.setAudio(inputFile);
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
