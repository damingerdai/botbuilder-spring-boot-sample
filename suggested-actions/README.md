# Suggested actions

Bot Framework v4 suggested actions bot sample.

## To try this sample
- From the root of this project folder:
    - Build the sample using `mvn package`
    - Run it by using `java -jar .\target\suggested-actions.jar`

## Testing the bot using Bot Framework Emulator

[Bot Framework Emulator](https://github.com/microsoft/botframework-emulator) is a desktop application that allows bot developers to test and debug their bots on localhost or running remotely through a tunnel.

- Install the latest Bot Framework Emulator from [here](https://github.com/Microsoft/BotFramework-Emulator/releases)

## Connect to the bot using Bot Framework Emulator
- Launch Bot Framework Emulator
- File -> Open Bot
- Enter a Bot URL of `http://localhost:8080/api/messages`

## Interacting with the bot

Suggested actions enable your bot to present buttons that the user  can tap to provide input. Suggested actions appear close to the composer and enhance user experience. They enable the user to answer a question or make a selection with a  simple tap of a button, rather than having to type a response with a  keyboard.

Unlike buttons that appear within rich cards (which remain visible  and accessible to the user even after being tapped), buttons that appear within the suggested actions pane will disappear after the user makes a selection. This prevents the user from tapping stale buttons within a  conversation and simplifies bot development (since you will not need to  account for that scenario).