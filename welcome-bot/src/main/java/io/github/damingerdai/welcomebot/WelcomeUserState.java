package io.github.damingerdai.welcomebot;

public class WelcomeUserState {

    private boolean didBotWelcomeUser = false;

    // Gets whether the user has been welcomed in the conversation.
    public boolean getDidBotWelcomeUser() {
        return didBotWelcomeUser;
    }

    // Sets whether the user has been welcomed in the conversation.
    public void setDidBotWelcomeUser(boolean withDidWelcomUser) {
        didBotWelcomeUser = withDidWelcomUser;
    }
}
