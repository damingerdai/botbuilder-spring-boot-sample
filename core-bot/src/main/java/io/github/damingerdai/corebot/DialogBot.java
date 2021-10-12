package io.github.damingerdai.corebot;

import com.microsoft.bot.builder.*;
import com.microsoft.bot.dialogs.Dialog;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class DialogBot<T extends Dialog> extends ActivityHandler {

    private Dialog dialog;
    private BotState conversationState;
    private BotState userState;

    /**
     * Gets the dialog in use.
     *
     * @return instance of dialog
     */
    protected Dialog getDialog() {
        return dialog;
    }

    /**
     * Gets the conversation state.
     *
     * @return instance of conversationState
     */
    protected BotState getConversationState() {
        return conversationState;
    }

    /**
     * Gets the user state.
     *
     * @return instance of userState
     */
    protected BotState getUserState() {
        return userState;
    }

    /**
     * Sets the dialog in use.
     *
     * @param withDialog the dialog (of Dialog type) to be set
     */
    protected void setDialog(Dialog withDialog) {
        dialog = withDialog;
    }

    /**
     * Sets the conversation state.
     *
     * @param withConversationState the conversationState (of BotState type) to be set
     */
    protected void setConversationState(BotState withConversationState) {
        conversationState = withConversationState;
    }

    /**
     * Sets the user state.
     *
     * @param withUserState the userState (of BotState type) to be set
     */
    protected void setUserState(BotState withUserState) {
        userState = withUserState;
    }

    /**
     * Creates a DialogBot.
     *
     * @param withConversationState ConversationState to use in the bot
     * @param withUserState         UserState to use
     * @param withDialog            Param inheriting from Dialog class
     */
    public DialogBot(
            ConversationState withConversationState, UserState withUserState, T withDialog
    ) {
        this.conversationState = withConversationState;
        this.userState = withUserState;
        this.dialog = withDialog;
    }

    /**
     * Saves the BotState objects at the end of each turn.
     *
     * @param turnContext
     * @return
     */
    @Override
    public CompletableFuture<Void> onTurn(TurnContext turnContext) {
        return super.onTurn(turnContext)
                // Save any state changes that might have occurred during the turn.
                .thenCompose(turnResult -> conversationState.saveChanges(turnContext, false))
                .thenCompose(saveResult -> userState.saveChanges(turnContext, false));
    }

    /**
     * This method is executed when the turnContext receives a message activity.
     *
     * @param turnContext
     * @return
     */
    @Override
    protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        LoggerFactory.getLogger(DialogBot.class).info("Running dialog with Message Activity.");

        // Run the Dialog with the new message Activity.
        return Dialog.run(dialog, turnContext, conversationState.createProperty("DialogState"));
    }
}
