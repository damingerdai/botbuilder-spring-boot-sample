# Welcome Bot

Bot Framework v4 welcome users bot sample.

## To try this sample
- From the root of this project folder:
    - Build the sample using `mvn package`
    - Run it by using `java -jar .\target\welcome-bot.jar`

## Testing the bot using Bot Framework Emulator

[Bot Framework Emulator](https://github.com/microsoft/botframework-emulator) is a desktop application that allows bot developers to test and debug their bots on localhost or running remotely through a tunnel.

- Install the latest Bot Framework Emulator from [here](https://github.com/Microsoft/BotFramework-Emulator/releases)

## Connect to the bot using Bot Framework Emulator
- Launch Bot Framework Emulator
- File -> Open Bot
- Enter a Bot URL of `http://localhost:8080/api/messages`

With the Bot Framework Emulator connected to your running bot, the sample will greet you with welcome messages. See [Send welcome message to users](https://aka.ms/botframework-welcome-instructions) for additional information on how a bot can welcome users to a conversation.