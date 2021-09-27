package io.github.damingerdai.using.cards;

import com.codepoetics.protonpack.collectors.CompletableFutures;
import com.microsoft.bot.builder.ConversationState;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.UserState;
import com.microsoft.bot.dialogs.Dialog;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class RichCardsBot extends DialogBot<Dialog> {

    public RichCardsBot(
            ConversationState withConversationState,
            UserState withUserState,
            Dialog withDialog
    ) {
        super(withConversationState, withUserState, withDialog);
    }

    @Override
    protected CompletableFuture<Void> onMembersAdded(
            List<ChannelAccount> membersAdded, TurnContext turnContext
    ) {
        return turnContext.getActivity().getMembersAdded().stream()
                .filter(member -> !StringUtils
                        .equals(member.getId(), turnContext.getActivity().getRecipient().getId()))
                .map(channel -> {
                    // Greet anyone that was not the target (recipient) of this message.
                    // To learn more about Adaptive Cards, see https://aka.ms/msbot-adaptivecards for more details.
                    Activity reply = MessageFactory.text("Welcome to CardBot."
                            + " This bot will show you different types of Rich Cards."
                            + " Please type anything to get started.");

                    return turnContext.sendActivity(reply);
                })
                .collect(CompletableFutures.toFutureList())
                .thenApply(resourceResponse -> null);
    }
}