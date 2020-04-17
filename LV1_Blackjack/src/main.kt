import java.util.Scanner

fun main(args:Array<String>)
{

    /* Testing user input and checking user input */
    val reader = Scanner(System.`in`)

    /*
    print("Enter Y or y!")
    val userInput : String? = readLine()
    val correctInput : Char = 'y'
    val correctInputUpper : Char = 'Y'

    if(userInput != correctInput.toString() || userInput != correctInputUpper.toString())
    {
        println("That aint right nigga")
    }

    println("You have entered : ${userInput}")
    /* Testing user input and checking user input */

     */

    /* Testing creation of map for card strengths */


    /* Testing creation of map for card strengths */

    /* Testing creation of map for total card count */
    var cardDeck = mutableMapOf<String, Int>("Ace" to 4, "Two" to 4, "Three" to 0, "Four" to 0, "Five" to 0, "Six" to 0, "Seven" to 0, "Eight" to 0,
            "Nine" to 0, "Ten" to 0, "Jack" to 4, "Queen" to 4, "King" to 0)

    println(cardDeck)
    //cardDeck["Ace"] = 2     /* Mijenjanje broja asova u decku */
    //println(cardDeck)
    /* Testing creation of map for total card count */


    val newDealer = Dealer()
    println("Do you want to play? (y/n)")
    val correctInput : Char = 'y'
    val correctInputUpper : Char = 'Y'
    var playYesNo : String? = readLine()

    while(playYesNo == correctInput.toString() || playYesNo == correctInputUpper.toString())
    {
        newDealer.dealCard(cardDeck)
        var dealerSum = newDealer.getDealerCardSum()
        var playerSum = newDealer.getPlayerCardSum()

        if(dealerSum >= 22)
        {
            println("Dealer loses")
            break
        }
        else if(dealerSum == 21)
        {
            println("Dealer wins")
            break
        }
        else if(playerSum >= 22)
        {
            println("Player loses")
            break
        }
        else if(playerSum == 21)
        {
            println("Player wins")
            break
        }

        println("Another card? (y/n)")
        playYesNo = readLine()

    }
}



class Dealer
{
    private var dealerCardSum : Int = 0
    private var playerCardSum : Int = 0

    public fun getDealerCardSum():Int
    {
        println("Current dealer sum is $dealerCardSum")
        return dealerCardSum
    }

    public fun getPlayerCardSum():Int
    {
        println("Current player sum is $playerCardSum")
        return playerCardSum
    }

    public fun dealCard(mapCardDeck: MutableMap<String, Int>)
    {
        val cardList = listOf("Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King")
        val cardStrengths = mapOf("Jack" to 10, "Queen" to 10, "King" to 10, "Ace" to 1, "Two" to 2, "Three" to 3, "Four" to 4,
                "Five" to 5, "Six" to 6, "Seven" to 7, "Eight" to 8, "Nine" to 9, "Ten" to 10)

        var decrementCardAmount = 0

        var randomCard : String = cardList.random()

        while(mapCardDeck[randomCard] == 0)
        {
            randomCard = cardList.random()
            if(mapCardDeck[randomCard] != 0)
            {
                if(dealerCardSum >= 17)
                {
                    continue
                }
                else
                {
                    var decrementCardAmount = mapCardDeck.getOrDefault(randomCard, 0) - 1
                    mapCardDeck.put(randomCard, decrementCardAmount)
                    dealerCardSum += cardStrengths[randomCard]!!
                }
            }
        }

        randomCard = cardList.random()
        while(mapCardDeck[randomCard] == 0) {
            randomCard = cardList.random()

            if (mapCardDeck[randomCard] != 0)
            {
                decrementCardAmount = mapCardDeck.getOrDefault(randomCard, 0) - 1
                mapCardDeck.put(randomCard, decrementCardAmount)
                playerCardSum += cardStrengths[randomCard]!!
            }
        }
    }
}