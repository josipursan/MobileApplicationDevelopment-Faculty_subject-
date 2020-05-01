fun main()
{
    var playerHuman_cardSum = 0
    var playerComputer_cardSum = 0

    var positiveInput_upperCase = 'Y'
    var positiveInput_lowerCase = 'y'
    val computerNewCardChoices = listOf<String>("y", "n")

    var newDealer = dealer()

    var newPlayer_human = player()
    var newPlayer_computer = player()

    do
    {
        if(newPlayer_human.getCardSum() == 0 && newPlayer_computer.getCardSum() == 0)   //INITIAL DEAL
        {
            newPlayer_human.updateCardSum(newDealer.dealAnotherCard())
            playerHuman_cardSum = newPlayer_human.getCardSum()
            println("Human card sum : $playerHuman_cardSum")

            newPlayer_computer.updateCardSum(newDealer.dealAnotherCard())
            playerComputer_cardSum = newPlayer_computer.getCardSum()
        }
        else
        {
            newPlayer_human.updateCardSum(newDealer.dealAnotherCard())
            playerHuman_cardSum = newPlayer_human.getCardSum()
            println("Human card sum : $playerHuman_cardSum")

            var randomComputerChoice = computerNewCardChoices.random()
            if(newPlayer_computer.getCardSum() >= 17)
            {
                randomComputerChoice = computerNewCardChoices[1]
            }
            if(randomComputerChoice == computerNewCardChoices[0])
            {
                var newCardValue = newDealer.dealAnotherCard()
                if(newCardValue == 11 && ((newPlayer_computer.getCardSum() + newCardValue)>21))
                {
                    newCardValue = 1
                }
                newPlayer_computer.updateCardSum(newCardValue)
                playerComputer_cardSum = newPlayer_computer.getCardSum()
            }
            else
            {
                println("Computer didn't draw another card")
            }
        }

        if(playerHuman_cardSum > 21)
        {
            println("Player sum : $playerHuman_cardSum.\tComputer sum : $playerComputer_cardSum\nPlayer loses.")
            break
        }
        else if(playerComputer_cardSum > 21)
        {
            println("Player sum : $playerHuman_cardSum.\tComputer sum : $playerComputer_cardSum\nComputer loses.")
            break
        }
        else if(playerHuman_cardSum == 21 && playerComputer_cardSum < 21)
        {
            println("Player sum : $playerHuman_cardSum.\tComputer sum : $playerComputer_cardSum\tComputer loses, human wins.")
            break
        }
        else if(playerComputer_cardSum == 21 && playerHuman_cardSum < 21)
        {
            println("Player sum : $playerHuman_cardSum.\tComputer sum : $playerComputer_cardSum\tPlayer loses, computer wins.")
            break
        }
        else if (playerComputer_cardSum == 21 && playerHuman_cardSum == 21) {
            println("Player sum : $playerHuman_cardSum.\tComputer sum : $playerComputer_cardSum\tIt's a draw!")
            break
        }

        print("Do you want another card? : ")
        val userChoice = readLine()!!
    }while (userChoice == positiveInput_lowerCase.toString() || userChoice == positiveInput_upperCase.toString())

    println("Player sum : $playerHuman_cardSum \t Computer sum : $playerComputer_cardSum \n")
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




class player
{
    private var cardSum = 0

    fun getCardSum(): Int
    {
        return cardSum
    }
    fun updateCardSum(newCardValue : Int)
    {
        cardSum += newCardValue
    }
}

class dealer
{
    var cardDeck = mutableMapOf<String, Int>("Ace" to 4, "Two" to 4, "Three" to 4, "Four" to 4, "Five" to 4, "Six" to 4, "Seven" to 4, "Eight" to 4,
        "Nine" to 4, "Ten" to 4, "Jack" to 4, "Queen" to 4, "King" to 4)
    val cardList = listOf("Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King")
    val cardStrengths = mapOf("Jack" to 10, "Queen" to 10, "King" to 10, "Ace" to 11, "Two" to 2, "Three" to 3, "Four" to 4, "Five" to 5, "Six" to 6, "Seven" to 7,
        "Eight" to 8, "Nine" to 9, "Ten" to 10)

    private fun generateRandomCard(): String
    {
        var randomCard = cardList.random()

        while(cardDeck[randomCard] == 0)
        {
            randomCard = cardList.random()
            if(cardDeck[randomCard] != 0)
            {
                break
            }
        }
        return randomCard
    }

    private fun decrementAmountOfCardsInDeck(cardName : String)
    {
        var decrementedCardAmount = cardDeck.getOrDefault(cardName, 0) - 1
        cardDeck.put(cardName, decrementedCardAmount)
    }

    fun dealAnotherCard(): Int
    {
        var randomCard = generateRandomCard()
        decrementAmountOfCardsInDeck(randomCard)
        return cardStrengths[randomCard]!!
    }
}