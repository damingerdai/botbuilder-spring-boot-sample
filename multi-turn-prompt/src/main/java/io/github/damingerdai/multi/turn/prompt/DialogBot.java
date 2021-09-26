package io.github.damingerdai.multi.turn.prompt;

import com.microsoft.bot.builder.*;
import com.microsoft.bot.dialogs.Dialog;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class DialogBot extends ActivityHandler {
    protected final Dialog dialog;
    protected final BotState conversationState;
    protected final BotState userState;

    public DialogBot(
            ConversationState withConversationState,
            UserState withUserState,
            Dialog withDialog
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
                .thenCompose(result -> conversationState.saveChanges(turnContext))
                // Save any state changes that might have occurred during the turn.
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
