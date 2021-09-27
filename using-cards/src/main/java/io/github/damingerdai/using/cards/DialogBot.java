package io.github.damingerdai.using.cards;

import com.microsoft.bot.builder.*;
import com.microsoft.bot.dialogs.Dialog;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

// @Component
public class DialogBot<T extends Dialog> extends ActivityHandler {

    protected final Dialog dialog;
    protected final BotState conversationState;
    protected final BotState userState;

    public DialogBot(
            ConversationState withConversationState,
            UserState withUserState,
            T withDialog
    ) {
        dialog = withDialog;
        conversationState = withConversationState;
        userState = withUserState;
    }

    @Override
    public CompletableFuture<Void> onTurn(
            TurnContext turnContext
    ) {
        return super.onTurn(turnContext)
                // Save any state changes that might have occurred during the turn.
                .thenCompose(result -> conversationState.saveChanges(turnContext))
                .thenCompose(result -> userState.saveChanges(turnContext));
    }

    @Override
    protected CompletableFuture<Void> onMessageActivity(
            TurnContext turnContext
    ) {
        LoggerFactory.getLogger(DialogBot.class).info("Running dialog with Message Activity.");

        // Run the Dialog with the new message Activity.
        return Dialog.run(dialog, turnContext, conversationState.createProperty("DialogState"));
    }
}
