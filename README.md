"# Onu" 

The cardTest class contains a number of tests to check if different methods are functioning correctly.


Classes game logic should worry about:

-GameStart: will start the game when constructed, hypothetically. Incomplete, as other classes are also incomplete

-Hands: has array "hands" as a member variable. hands is an array of every player's hands. It, and each player's starting hands are
created automatically when GameStart is constructed.
    getHand(int player): given the number of a player, will return that player's hand. Player numbers begin at ONE, not zero.
        Attempting to get the hand of player zero will likely return an error.
    drawHand(int Player, DeckImage deckImage): given the number of a player and the DeckImage of the deck, will display a player's deck
        on the screen within the bounds of the window. (Don't worry aboud deckImage too much, just use the identically named one already declared in the GUI class.)

-Hand: has arraylist "cards" as a member variable, an arraylist of each card in the hand. Player hands are created automatically when Hands is constructed, and upon construction a Hand will automatically draw its first seven cards.
    draw(): will draw a card from the deck into the hand. If the deck is empty, it will automatically be reshuffled.
    playCard(int index): Places the card at the given index of the hand on top of the discard pile. Currently, this does not update any
        graphics, nor does it advance to the next player's turn.
    
-GUI: GUI IS A SINGLETON, and must be accessed with getInstance() instead of new. It automatically creates the main game window, and contains methods that draw different elements of the UI.
    drawDiscard(): draws the discard pile.
    drawDeck(): draws the deck.

I think these are all you really need to worry about actually but let me know if there's confusion