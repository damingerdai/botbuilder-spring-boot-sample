package io.github.damingerdai.corebot;

import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.dialogs.ComponentDialog;
import com.microsoft.bot.dialogs.DialogContext;
import com.microsoft.bot.dialogs.DialogTurnResult;
import com.microsoft.bot.dialogs.DialogTurnStatus;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ActivityTypes;
import com.microsoft.bot.schema.InputHints;

import java.util.concurrent.CompletableFuture;

public class CancelAndHelpDialog extends ComponentDialog {

    private final String helpMsgText = "Show help here";
    private final String cancelMsgText = "Cancelling...";

    @Override
    protected CompletableFuture<DialogTurnResult> onContinueDialog(DialogContext innerDc) {
        return interrupt(innerDc).thenCompose(result -> {
            if (result != null) {
                return CompletableFuture.completedFuture(result);
            }
            return super.onContinueDialog(innerDc);
        });
    }

    private CompletableFuture<DialogTurnResult> interrupt(DialogContext innerDc) {
        if (innerDc.getContext().getActivity().isType(ActivityTypes.MESSAGE)) {
            String text = innerDc.getContext().getActivity().getText().toLowerCase();

            switch (text) {
                case "help":
                case "?":
                    Activity helpMessage = MessageFactory
                            .text(helpMsgText, helpMsgText, InputHints.EXPECTING_INPUT);
                    return innerDc.getContext().sendActivity(helpMessage)
                            .thenCompose(sendResult ->
                                    CompletableFuture
                                            .completedFuture(new DialogTurnResult(DialogTurnStatus.WAITING)));
                case "cancel":
                case "quit":
                    Activity cancelMessage = MessageFactory
                            .text(cancelMsgText, cancelMsgText, InputHints.IGNORING_INPUT);
                    return innerDc.getContext()
                            .sendActivity(cancelMessage)
                            .thenCompose(sendResult -> innerDc.cancelAllDialogs());
                default:
                    break;
            }
        }

        return CompletableFuture.completedFuture(null);
    }


    public CancelAndHelpDialog(String id) {
        super(id);
    }
}
