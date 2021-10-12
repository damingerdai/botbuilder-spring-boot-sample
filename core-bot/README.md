# CoreBot

Bot Framework v4 core bot sample.

This bot has been created using [Bot Framework](https://dev.botframework.com), it shows how to:

- Use [LUIS](https://www.luis.ai) to implement core AI capabilities
- Implement a multi-turn conversation using Dialogs
- Handle user interruptions for such things as `Help` or `Cancel`
- Prompt for and validate requests for information from the user
## To try this sample

- From the root of this project folder:
    - Build the sample using `mvn package`
    - Run it by using `java -jar .\target\core-bot.jar`

## Testing the bot using Bot Framework Emulator

[Bot Framework Emulator](https://github.com/microsoft/botframework-emulator) is a desktop application that allows bot developers to test and debug their bots on localhost or running remotely through a tunnel.

- Install the latest Bot Framework Emulator from [here](https://github.com/Microsoft/BotFramework-Emulator/releases)

### Connect to the bot using Bot Framework Emulator
- Launch Bot Framework Emulator
- File -> Open Bot
- Enter a Bot URL of `http://localhost:8080/api/messages`

### Create a LUIS Application to enable language understanding

The LUIS model for this example can be found under `cognitiveModels/FlightBooking.json` and the LUIS language model setup, training, and application configuration steps can be found [here](https://docs.microsoft.com/en-us/azure/bot-service/bot-builder-howto-v4-luis?view=azure-bot-service-4.0&tabs=cs).

Once you created the LUIS model, update `application.properties` with your `LuisAppId`, `LuisAPIKey` and `LuisAPIHostName`.

```
  LuisAppId="Your LUIS App Id"
  LuisAPIKey="Your LUIS Subscription key here"
  LuisAPIHostName="Your LUIS App region here (i.e: westus.api.cognitive.microsoft.com)"
```