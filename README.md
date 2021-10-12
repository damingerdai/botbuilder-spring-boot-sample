# botbuilder-spring-boot-sample

The sample for the [botbuilder-spring-boot-starter](https://github.com/PowerBotKit/botbuilder-spring-boot).

## Requirement

1. [maven](http://maven.apache.org/)
2. [jdk 1.8+](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
3. [Bot Framework Emulator](https://github.com/microsoft/botframework-emulator)

## Samples

|  #   | Sample Name |  Description | Link |
| :--: | :---------- | :----------- | :--- |
| 2  |Echo bot  |Demonstrates how to receive and send messages. | [Java Code](./echo-bot) |
| 3  |Welcome user   |Introduces activity types and provides a welcome message on conversation update activity. | [Java Code](./welcome-bot) |
| 5  |Multi&nbsp;turn&nbsp;prompts    | Demonstrates how to use waterfall dialog, prompts, and component dialog to create a simple interaction that asks the user for name, age, and prints back that information.          | [Java Code](./multi-turn-prompt) |
| 6  |Using cards          | Introduces all card types including thumbnail, audio, media etc. Builds on Welcoming user + multi-prompt bot by presenting a card with buttons in welcome message that route to appropriate dialog.     | [Java Code](./using-cards) |
| 7  |Adaptive cards | Demonstrates how the multi-turn dialog can use a card to get user input for name and age. | [Java Code](./using-adaptive-cards) |
| 8  |Suggested actions    | Demonstrates how to enable your bot to present buttons that the user can tap to provide input.   | [Java Code](./suggested-actions) |
| 11 |QnA Maker (simple)   | Demonstrates how to use QnA Maker to have simple single-turn conversations | [Java Code](./qnamaker) |