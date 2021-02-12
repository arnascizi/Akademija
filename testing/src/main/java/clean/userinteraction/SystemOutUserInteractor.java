package clean.userinteraction;

import clean.inputhandling.InputReader;

public class SystemOutUserInteractor implements UserInteractor, UserTextPrinter {

    private InputReader inputReader;

    public SystemOutUserInteractor(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public String writeAndGetResponse(String text) throws Exception {
        write(text);
        return inputReader.readUserInput();
    }

    @Override
    public void write(String text) throws Exception {
        System.out.println(text);
    }
}
