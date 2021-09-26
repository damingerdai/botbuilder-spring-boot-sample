package io.github.damingerdai.using.adaptive.cards;

import com.codepoetics.protonpack.collectors.CompletableFutures;
import com.microsoft.bot.builder.ActivityHandler;
import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.schema.Attachment;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.Serialization;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class AdaptiveCardsBot extends ActivityHandler {

    private static final String welcomeText = "This bot will introduce you to AdaptiveCards. "
            + "Type anything to see an AdaptiveCard.";

    // This array contains the file names of our adaptive cards
    private final String[] cards = {
            "FlightItineraryCard.json",
            "ImageGalleryCard.json",
            "LargeWeatherCard.json",
            "RestaurantCard.json",
            "SolitaireCard.json"
    };

    @Override
    protected CompletableFuture<Void> onMembersAdded(
            List<ChannelAccount> membersAdded,
            TurnContext turnContext
    ) {
        return sendWelcomeMessage(turnContext);
    }

    @Override
    protected CompletableFuture<Void> onMessageActivity(TurnContext turnContext) {
        Random r = new Random();
        Attachment cardAttachment = createAdaptiveCardAttachment(cards[r.nextInt(cards.length)]);

        return turnContext.sendActivity(MessageFactory.attachment(cardAttachment)).thenCompose(result ->{
            return turnContext.sendActivity(MessageFactory.text("Please enter any text to see another card."))
                    .thenApply(sendResult -> null);
        });
    }

    private static CompletableFuture<Void> sendWelcomeMessage(TurnContext turnContext) {
        return turnContext.getActivity()
                .getMembersAdded()
                .stream()
                .filter(
                        member -> !StringUtils
                                .equals(member.getId(), turnContext.getActivity().getRecipient().getId())
                )
                .map(
                        channel -> turnContext.sendActivities(
                                MessageFactory.text(
                                        String.format("Welcome to Adaptive Cards Bot %s. %s", channel.getName(), welcomeText)
                                )
                        )
                )
                .collect(CompletableFutures.toFutureList())
                .thenApply(resourceResponses -> null);
    }

    private static Attachment createAdaptiveCardAttachment(String filePath) {
        try (
                InputStream inputStream = Thread.currentThread().
                        getContextClassLoader().getResourceAsStream(filePath)
        ) {
            String adaptiveCardJson = IOUtils
                    .toString(inputStream, StandardCharsets.UTF_8.toString());

            Attachment attachment = new Attachment();
            attachment.setContentType("application/vnd.microsoft.card.adaptive");
            attachment.setContent(Serialization.jsonToTree(adaptiveCardJson));

            return attachment;

        } catch (IOException e) {
            e.printStackTrace();
            return new Attachment();
        }
    }
}
