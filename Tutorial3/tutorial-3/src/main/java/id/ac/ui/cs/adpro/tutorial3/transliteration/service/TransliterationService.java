package id.ac.ui.cs.adpro.tutorial3.transliteration.service;

public interface TransliterationService {

    void setRequestType(String type);

    boolean isRequestEncode();

    String getRequestValue();

    void setRequestValue(String value);

    String encode(String text);

    String decode(String code);

    String processAeronCipher(String text, String type);

    String processAeronShifter(String text, int shift);
}
