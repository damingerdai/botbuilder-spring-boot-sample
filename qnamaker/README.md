# QnA Maker

Bot Framework v4 QnA Maker bot sample.

## To try this sample locally
- From the root of this project folder:
    - Build the sample using `mvn package`
    - Run it by using `java -jar .\qnamaker.jar`

## Testing the bot using Bot Framework Emulator
[Bot Framework Emulator](https://github.com/microsoft/botframework-emulator) is a desktop application that allows bot developers to test and debug their bots on localhost or running remotely through a tunnel.

- Install the latest Bot Framework Emulator from [here](https://github.com/Microsoft/BotFramework-Emulator/releases)

### Connect to the bot using Bot Framework Emulator
- Launch Bot Framework Emulator
- File -> Open Bot
- Enter a Bot URL of `http://localhost:8080/api/messages`

### Create a QnAMaker Application to enable QnA Knowledge Bases

QnA knowledge base setup and application configuration steps can be found [here](https://aka.ms/qna-instructions).

## Interacting with the bot

QnA Maker enables you to power a question and answer service from your semi-structured content.

One of the basic requirements in writing your own bot is to seed it with questions and answers. In many cases, the questions and answers already exist in content like FAQ URLs/documents, product manuals, etc. With QnA Maker, users can query your application in a natural, conversational manner. QnA Maker uses machine learning to extract relevant question-answer pairs from your content. It also uses powerful matching and ranking algorithms to provide the best possible match between the user query and the questions.