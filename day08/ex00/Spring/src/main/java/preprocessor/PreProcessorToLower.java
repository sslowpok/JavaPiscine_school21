package preprocessor;

import java.util.Locale;

public class PreProcessorToLower implements PreProcessor {

    @Override
    public String preProcessMessage(String message) {
        return message.toLowerCase(Locale.ROOT);
    }
}
