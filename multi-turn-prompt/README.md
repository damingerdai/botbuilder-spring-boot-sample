# Multi-turn prompt

Bot Framework v4 multi-turn prompt bot sample.

## To try this sample
- From the root of this project folder:
    - Build the sample using `mvn package`
    - Run it by using `java -jar .\target\multi-turn-prompt.jar`

## Testing the bot using Bot Framework Emulator

[Bot Framework Emulator](https://github.com/microsoft/botframework-emulator) is a desktop application that allows bot developers to test and debug their bots on localhost or running remotely through a tunnel.

- Install the latest Bot Framework Emulator from [here](https://github.com/Microsoft/BotFramework-Emulator/releases)

## Connect to the bot using Bot Framework Emulator
- Launch Bot Framework Emulator
- File -> Open Bot
- Enter a Bot URL of `http://localhost:8080/api/messages`

A conversation between a bot and a user often involves asking (prompting) the user for information, parsing the user's response, and then acting on that information. This sample demonstrates how to prompt users for information using the different prompt types included in the [botbuilder-dialogs](https://docs.microsoft.com/en-us/azure/bot-service/bot-builder-concept-dialog?view=azure-bot-service-4.0) library
and supported by the SDK.

The `botbuilder-dialogs` library includes a variety of pre-built prompt classes, including text, number, and datetime types. This sample demonstrates using a text prompt to collect the user's name, then using a number prompt to collect an age.