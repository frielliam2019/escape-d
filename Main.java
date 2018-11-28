import java.util.Scanner;

public class Main {

    public static boolean inFoyer = true;
    public static boolean inLibrary;
    public static boolean inConservatory;
    public static boolean chestOpen = false;
    public static boolean hasMatches = false;
    public static boolean candleLit = false;
    public static boolean doorFoyerLocked = true;
    public static boolean doorFoyerOpen = false;
    public static boolean walkedNorthFoyer = false;
    public static boolean hasPen = false;
    public static boolean hasBook = false;
    public static boolean bookTitled = false;
    public static boolean doorLibraryLocked = true;
    public static boolean doorLibraryOpen = false;
    public static boolean walkedNorthLibrary = false;
    public static boolean trumpet = false;
    public static boolean piano = false;
    public static boolean drum = false;
    public static boolean doorConservatoryLocked = true;
    public static boolean doorConservatoryOpen = false;
    public static boolean walkedNorthConservatory = false;
    public static boolean gameWon = false;
    public static int movesLeftOver=30;
    public static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

    //System.out.println("\nType 'help me' if you need help with a list of command verbs and nouns. Make sure\nto always type two word commands, consisting of 1 verb and 1 noun. e.g. 'help me'. \nFor a list of cheats. You should look at the code. \n\n\n");

        System.out.println("Make sure to always type two word commands, consisting of 1 verb and 1 noun. e.g. 'help me'.  \n");
        System.out.println("Verbs for use: \n|open   ||  close|\n|light  ||   read|\n|write  ||   play|\n|look   ||    get|\n|walk   |\nNouns for use vary from room to room, explore and look to see objects.\n\n");
        System.out.printf("\nYou wake up and can't remember anything. You're in a room. It seems to be a foyer. \nIn this foyer, there is a bench, a chest, an unlit candle, and a note. The only way \nout is a door to the north. It sits closed while you lay on the ground. You \nstand up, hoping you can get out of this unfamiliar situation.\n");
        Foyer();
        inLibrary=true;
        System.out.printf("As you walk into the next room, you realize it is a library. Along the wall with all \nthe books there is a desk. On the desk is a pen, and a scroll. There is another \ndoor to the north that is locked. You think of your likelihood of getting out,\nyour confidence is now lacking. The books on the shelves are the same.\n\n");
        Library();
        inConservatory=true;
        System.out.printf("Leaving the library gives you hope that you can get out and survive. This next room \nyou walk into is a conservatory. There are three instruments, a trumpet, a drum, \nand a piano. The way out, is a door to the north, but as always, it is locked.\nA piece of sheet music is on a stand in the center of the room.\n");
        Conservatory();
        gameWon = true;
        System.out.printf("Once the door opens, you feel a sense freedom. You run outside to the blinding light. All of \na sudden you wake up and can't remember anything. You're in a room. It seems to be a foyer. In this foyer, \nthere is a bench, a chest, an unlit candle, and a note. The only way out is a door \nto the north. It sits closed while you lay on the ground. You stand up, hoping you can \nget out of this unfamiliar situation.\n");
        System.out.printf("You have completed the game. Congratulations!");



        }

    public static void moveCounter() {
        movesLeftOver--;
        if (movesLeftOver > 0) {
            System.out.printf("You have %d moves left.\n\n", movesLeftOver);
        }
        else {
            System.out.println("You have no more moves. You Lose.");
            System.exit(0);
        }
        }


        public static boolean Foyer() {
            System.out.print(">>");
            if (inFoyer==true) {
                String verb = scan.next();
                String noun = scan.next();
                switch (verb) {
//                    case "help":
//                        switch (noun){
//                            case "me":
//                                System.out.println("List of Verbs: \n\nopen || close \nlight || read\nwrite || play \nlook || get\n walk");
//                                break;
//                            default:
//                                System.out.println("Type 'help me' for a list of commands.");
//                                break;
//                        }
//                        break;
                    case"tp":
                        switch(noun) {
                            case"foyer":
                                System.out.println("You are already there, that would be a waste of a teleport.");
                                break;
                            case"library":
                                inFoyer =false;
                                inLibrary = true;
                                System.out.println("You teleported to the Library.");
                                Library();
                                break;
                            case"conservatory":
                                inFoyer = false;
                                inConservatory = true;
                                System.out.println("You teleported to the Conservatory.");
                                Conservatory();
                                break;
                            default:
                                break;
                        }
                        break;
                    case "open":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't open the bench.");
                                break;
                            case "chest":
                                System.out.println("You opened the chest to find a box of matches.");
                                chestOpen = true;
                                break;
                            case "candle":
                                System.out.println("You can't open the candle.");
                                break;
                            case "note":
                                System.out.println("You can't open the note.");
                                break;
                            case "door":
                                if (!doorFoyerLocked) {
                                    System.out.println("You opened the door to the north.");
                                    doorFoyerOpen = true;
                                }
                                else{
                                    System.out.println("You tug at the door, but it will not budge.");
                                }
                                break;
                            default:
                                System.out.println("You opened nothing.");
                                break;
                        }
                        break;
                    case "close":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't close the bench.");
                                break;
                            case "chest":
                                System.out.println("You closed the chest, wasting a move.");
                                break;
                            case "candle":
                                System.out.println("You can't close the candle.");
                                break;
                            case "note":
                                System.out.println("You can't close the note.");
                                break;
                            default:
                                System.out.println("You closed nothing.");
                                break;
                        }
                        break;
                    case "light":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't light the bench.");
                                break;
                            case "chest":
                                System.out.println("You can't light the chest.");
                                break;
                            case "candle":
                                if (hasMatches == true) {
                                    candleLit = true;
                                } else {
                                    System.out.println("You do not have anything to light the candle with.");
                                }
                                break;
                            case "note":
                                System.out.println("You can't light the note.");
                                break;
                            default:
                                System.out.println("You lit nothing.");
                                break;
                        }
                        break;
                    case "read":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't read the bench.");
                                break;
                            case "chest":
                                System.out.println("You can't read the chest.");
                                break;
                            case "candle":
                                System.out.println("You can't read the candle.");
                                break;
                            case "note":
                                System.out.println("You read the note. It says 'May my light show you the way'. You think to yourself, this is a Jesus candle.");

                                break;
                            default:
                                System.out.println("You read nothing.");
                                break;
                        }
                        break;
                    case "write":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't write on the bench.");
                                break;
                            case "chest":
                                System.out.println("You can't write on the chest.");
                                break;
                            case "candle":
                                System.out.println("You can't write on the candle.");
                                break;
                            case "note":
                                System.out.println("You can't write on the note.");
                                break;
                            default:
                                System.out.println("You wrote on nothing.");
                                break;
                        }
                        break;
                    case "play":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't play the bench.");
                                break;
                            case "chest":
                                System.out.println("You can't play the chest.");
                                break;
                            case "candle":
                                System.out.println("You can't play the candle.");
                                break;
                            case "note":
                                System.out.println("You can't play the note.");
                                break;
                            default:
                                System.out.println("You played nothing.");
                                break;
                        }
                        break;
                    case "look":
                        switch (noun) {
                            case "bench":
                                System.out.println("You look at the bench. On it there is a note sitting on top.");
                                break;
                            case "chest":
                                System.out.println("You look at the chest, it is closed.");
                                break;
                            case "candle":
                                System.out.println("You look at the candle, it sits in the middle of the room.");
                                break;
                            case "note":
                                System.out.println("You look at the note, there is writing on it.");
                                break;
                            default:
                                System.out.println("You have looked at noting in particular.");
                                break;
                        }

                        break;
                    case "get":
                        switch (noun) {
                            case "bench":
                                System.out.println("You can't get the bench.");
                                break;
                            case "chest":
                                System.out.println("You can't get the chest.");
                                break;
                            case "candle":
                                System.out.println("You can't get the candle.");
                                break;
                            case "note":
                                System.out.println("You can't get the note.");
                                break;
                            case "matches":
                                if (chestOpen == true) {
                                    System.out.println("You picked up the matches");
                                    hasMatches = true;
                                } else {
                                    System.out.println("Where are these matches you want to get?");
                                }
                                break;
                            default:
                                System.out.println("You got nothing.");
                                break;
                        }
                        break;
                    case "walk":
                        switch (noun) {
                        case"north":
                            if(doorFoyerOpen) {
                                System.out.println("You walked out of the foyer through the door to the north.");
                                inLibrary = true;
                                inFoyer= false;
                                walkedNorthFoyer=true;
                            }
                            else{
                                System.out.println("There is a door to the north, but it is closed.");
                            }
                            break;
                            default:
                                System.out.println("You cannot walk that way. There is a wall there.");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Invalid Command");
                        break;

                }
                if(inFoyer=true) {
                    if (hasMatches == true) {
                        if (hasMatches && candleLit == true&&doorFoyerLocked) {
                            doorFoyerLocked = false;
                            System.out.println("You light the candle, there is a loud noise to the north. The door to the north is now unlocked.");
                            moveCounter();
                            Foyer();

                        }
                        else{
                            if(walkedNorthFoyer) {
                                inFoyer = false;
                                inLibrary = true;
                            }
                            else{
                                moveCounter();
                                Foyer();
                            }
                        }
                    }
                    else{
                        moveCounter();
                        Foyer();
                    }
                }
                else {
                    inFoyer=false;
                }
                return inFoyer = false;
            }
            return inLibrary = true;
        }

    public static boolean Library() {
        System.out.print(">>");
        if (inLibrary==true) {
            String verb = scan.next();
            String noun = scan.next();
            switch (verb) {
                case "tp":
                    switch (noun) {
                        case"library":
                            System.out.println("You are already there, that would be a waste of a teleport.");
                            break;
                        case "foyer":
                            inLibrary = false;
                            inFoyer = true;
                            System.out.println("You teleported to the Foyer.");
                            Foyer();
                            break;
                        case "conservatory":
                            inLibrary = false;
                            inConservatory = true;
                            System.out.println("You teleported to the Conservatory.");
                            Conservatory();
                        break;
                         default:
                    break;
                    }
                case "open":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You can't open the shelves.");
                            break;
                        case "book":
                            System.out.println("You open the book to reveal that there is no writing inside.");
                            break;
                        case "pen":
                            System.out.println("You cannot open the pen");
                            break;
                        case "scroll":
                            System.out.println("The scroll, unravels, there is writing that says, 'Share your story.' ");
                            break;
                        case "door":
                            if(!doorLibraryLocked){
                                doorLibraryOpen = true;
                                System.out.println("You opened the door in the library, leading to the next room.");
                            }
                            else{
                                System.out.println("As you turn and pull the knob of the door, you find it is locked and cannot get out.");
                            }
                            break;
                        default:
                            System.out.println("You opened nothing.");
                            break;
                    }
                    break;
                case "close":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You cannot close the shelves.");
                            break;
                        case "book":
                            System.out.println("There is no need to close the book.");
                            break;
                        case "pen":
                            System.out.println("You cannot close the pen.");
                            break;
                        case "scroll":
                            System.out.println("There is no need to close the scroll.");
                            break;
                        default:
                            System.out.println("You closed nothing.");
                            break;
                    }
                    break;
                case "light":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You have nothing to light with.");
                            break;
                        case "book":
                            System.out.println("You have nothing to light with.");
                            break;
                        case "pen":
                            System.out.println("You have nothing to light with. ");
                            break;
                        case "scroll":
                            System.out.println("You have nothing to light with. ");
                            break;
                        default:
                            System.out.println("You lit nothing.");
                            break;
                    }
                    break;
                case "read":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You read the shelves, you read nothing.");
                            break;
                        case "book":
                            System.out.println("You read the book, the title says 'The Autobiography of ... '. It is incomplete.");
                            break;
                        case "pen":
                            System.out.println("You read the pen, it is a Bic 2.0 Ballpoint pen.");
                            break;
                        case "scroll":
                            System.out.println("You read the scroll. It says, 'Share your Story'.");
                            break;
                        default:
                            System.out.println("You read nothing.");
                            break;
                    }
                    break;
                case "write":
                    if(hasPen==true){
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You wrote, 'I waz here' on the shelves.");
                            break;
                        case "book":
                            if(hasBook==true){
                            System.out.print("You can write on the book, there is only space for one more word. \nThe Autobiography of ");
                            String bookTitle = scan.next();
                            System.out.println("The book is now titled: 'The Autobiography of "+bookTitle+"'.");
                            bookTitled=true;}
                            else{System.out.println("You would write on the book, but it is not in your hands.");}
                            break;
                        case "pen":
                            System.out.println("You cannot write anything right now.");
                            break;
                        case "scroll":
                            System.out.println("You don't feel like writing on this nice scroll.");
                            break;
                        default:
                            System.out.println("You wrote on nothing.");
                            break;
                    }}
                    else{System.out.println("You have nothing to write with.");}
                    break;
                case "play":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("No playing on the shelves. That is dangerous.");
                            break;
                        case "book":
                            System.out.println("You are bored of the book, because you already played with it.");
                            break;
                        case "pen":
                            System.out.println("No need to play with the pen right now.");
                            break;
                        case "scroll":
                            System.out.println("You can't play with the scroll.");
                            break;
                        default:
                            System.out.println("You can't play that.");
                            break;
                    }
                    break;
                case "look":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You look at the shelves. There is an open book on one of shelves. ");
                            break;
                        case "book":
                            System.out.println("You look at the book, it is only halfway titled saying: 'The Autobiography of ...'.");
                            break;
                        case "pen":
                            System.out.println("You look at the pen, it is a blue ballpoint pen.");
                            break;
                        case "scroll":
                            System.out.println("You look at the scroll, it says, 'Share your story.'.");
                            break;
                        default:
                            System.out.println("You have looked at noting in particular.");
                            break;
                    }

                    break;
                case "get":
                    switch (noun) {
                        case "shelves":
                        case "shelf":
                            System.out.println("You got no shelves.");
                            break;
                        case "book":
                            System.out.println("You picked up the open book from the shelves. ");
                            hasBook=true;
                            break;
                        case "pen":
                            System.out.println("You picked up the pen.");
                            hasPen=true;
                            break;
                        case "scroll":
                            System.out.println("You picked up the scroll, it says 'Share your story.'.");
                            break;
                        default:
                            System.out.println("You got nothing.");
                            break;
                    }
                    break;
                case "walk":
                    switch (noun) {
                    case"north":
                        if(doorLibraryOpen) {
                            System.out.println("You walked out of the library through the door to the north.");
                            inConservatory = true;
                            inLibrary = false;
                            walkedNorthLibrary=true;
                        }
                        else{
                            System.out.println("There is a door to the north, but it is closed.");
                        }
                        break;
                    default:
                        System.out.println("You cannot walk that way. There is a wall there.");
                        break;
                }
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;

            }
            if(inLibrary=true) {
                if (hasPen == true||hasBook==true) {
                    if (hasPen==true&&hasBook == true) {
                        if(bookTitled==true&&doorLibraryLocked){
                            doorLibraryLocked = false;
                            System.out.println("After you titled the rest of the autobiography, there is a loud noise to the north. The door to the north is now unlocked.\n");
                            moveCounter();
                            Library();
                        }
                        else{
                            if(walkedNorthLibrary) {
                                inLibrary = false;
                                inConservatory = true;
                            }
                            else{
                                moveCounter();
                                Library();
                            }
                        }
                    }
                    else{
                        moveCounter();
                        Library();
                    }
                }
                else{
                    moveCounter();
                    Library();
                }
            }
            else {
                inLibrary=false;
            }
            return inLibrary = false;
        }
        else {
            Library();
        }
        return inConservatory = true;
    }
    public static boolean Conservatory() {
        System.out.print(">>");
        if (inConservatory==true) {
            String verb = scan.next();
            String noun = scan.next();
            switch (verb) {
                case "tp":
                    switch (noun) {
                        case"conservatory":
                            System.out.println("You are already there, that would be a waste of a teleport.");
                            break;
                        case "foyer":
                            inConservatory = false;
                            inFoyer = true;
                            System.out.println("You teleported to the Foyer.");
                            Foyer();
                            break;
                        case "library":
                            inConservatory = false;
                            inLibrary = true;
                            System.out.println("You teleported to the Library.");
                            Library();
                            break;
                        default:
                            break;
                    }
                case "open":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You can't open the trumpet.");
                            break;
                        case "piano":
                            System.out.println("You can't open the piano.");
                            break;
                        case "drum":
                            System.out.println("You can't open the drum.");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You open the sheet music, there are no notes written. However, it says 'Timbre, Tone, and Time'.");
                            break;
                        case "door":
                            if(!doorConservatoryLocked){
                                doorConservatoryOpen = true;
                                System.out.println("You opened the door in the conservatory. You taste freedom. ");
                            }
                            else{
                                System.out.println("Alright, all the other doors in this terrible situation have been locked. Try to figure out the dang way to unlock it.");
                            }
                            break;
                        default:
                            System.out.println("You opened nothing.");
                            break;
                    }
                    break;
                case "close":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You cannot close the trumpet.");
                            break;
                        case "piano":
                            System.out.println("There is no need to close the piano.");
                            break;
                        case "drum":
                            System.out.println("You cannot close the drum.");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("There is no need to close the sheet music.");
                            break;
                        default:
                            System.out.println("You closed nothing.");
                            break;
                    }
                    break;
                case "light":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You cannot light the trumpet on fire. ");
                            break;
                        case "piano":
                            System.out.println("You cannot light the piano on fire. ");
                            break;
                        case "drum":
                            System.out.println("You cannot light the drum on fire.");
                            break;
                        case "music":
                            System.out.println("You cannot light the sheet music on fire. ");
                            break;
                        default:
                            System.out.println("You lit nothing.");
                            break;
                    }
                    break;
                case "read":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("The side of the trumpet says Yamaha.");
                            break;
                        case "drum":
                            System.out.println("You read the side of the drum, it says Mapex.");
                            break;
                        case "piano":
                            System.out.println("You read the piano, it says Kingsbury..");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You read the sheet music. It says, 'Timbre, Tone, and Time'.");
                            break;
                        default:
                            System.out.println("You read nothing.");
                            break;
                    }
                    break;
                case "write":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You cannot write on the trumpet.");
                            break;
                        case "piano":
                            System.out.print("You don't want to be rude and write on the piano.");
                            break;
                        case "drum":
                            System.out.println("You don't want to write on the drum.");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You don't write anything on the sheet music.");
                            break;
                        default:
                            System.out.println("You wrote on nothing.");
                            break;
                        }
                    break;
                case "play":
                    switch (noun) {
                        case "trumpet":
                            if (trumpet==false) {
                                System.out.println("*Timbre*");
                                trumpet = true;
                            }
                            else{
                                piano=false;
                                trumpet=false;
                                drum=false;
                                System.out.println("You played the trumpet, but it didn't sound right.");
                            }
                            break;
                        case "piano":
                            if(trumpet==true){
                                if(piano==false){
                                    System.out.println("*Tone*");
                                    piano=true;
                                }
                                else{
                                    piano=false;
                                    trumpet=false;
                                    drum=false;
                                    System.out.println("You played the piano, but it didn't sound right.");
                                }
                            }
                            else{
                                piano=false;
                                trumpet=false;
                                drum=false;
                                System.out.println("You played the piano, but it didn't sound right.");
                            }
                            break;
                        case "drum":
                            if(trumpet==true){
                                if(piano==true){
                                    if(drum==false) {
                                        System.out.println("*Time*");
                                        drum = true;
                                    }
                                    else{
                                        piano=false;
                                        trumpet=false;
                                        drum=false;
                                        System.out.println("You played the drum, but it didn't sound right.");
                                    }
                                }
                                else{
                                    piano=false;
                                    trumpet=false;
                                    drum=false;
                                    System.out.println("You played the drum, but it didn't sound right.");
                                }
                            }
                            else{
                                piano=false;
                                trumpet=false;
                                drum=false;
                                System.out.println("You played the drum, but it didn't sound right.");
                            }
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You can't play the music sheet.");
                            break;
                        default:
                            System.out.println("You can't play that.");
                            break;
                    }
                    break;
                case "look":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You look at the trumpet, it sure is shiny.");
                            break;
                        case "drum":
                            System.out.println("You look at the drum, it is black and white.");
                            break;
                        case "piano":
                            System.out.println("You look at the piano, it is a black grand piano.");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You look at the music sheet, it says, 'Timbre, Tone, and Time'.");
                            break;
                        default:
                            System.out.println("You have looked at noting in particular.");
                            break;
                    }

                    break;
                case "get":
                    switch (noun) {
                        case "trumpet":
                            System.out.println("You picked up the trumpet");
                            break;
                        case "drum":
                            System.out.println("You picked up the drum.");
                            break;
                        case "piano":
                            System.out.println("You picked up the piano.");
                            break;
                        case "music":
                        case "sheet":
                            System.out.println("You picked us the sheet music.");
                            break;
                        default:
                            System.out.println("You got nothing. ");
                            break;
                    }
                    break;
                case "walk":
                    switch (noun) {
                        case"north":
                            if(doorConservatoryOpen) {
                                inConservatory = false;
                                walkedNorthConservatory=true;
                            }
                            else{
                                System.out.println("There is a door to the north, but it is closed.");
                            }
                            break;
                        default:
                            System.out.println("You cannot walk that way. There is a wall there.");
                            break;
                    }
                break;
                default:
                    System.out.println("Invalid Command");
                    break;

            }
            if(inConservatory==true){
                if (piano==true){
                    if (trumpet==true){
                        if(drum==true&&doorConservatoryLocked){
                            doorConservatoryLocked = false;
                            System.out.println("You played all the instruments in the correct order.\nOnce you hit the drum, a loud click sounds.");
                            moveCounter();
                            Conservatory();
                        }
                        else{
                            if(walkedNorthConservatory) {
                                inConservatory = false;
                            }
                            else{
                                moveCounter();
                                Conservatory();
                            }
                        }

                    }
                    else{
                        moveCounter();
                        Conservatory();
                    }
                }
                else{
                    moveCounter();
                    Conservatory();
                }
            }
            return inConservatory = false;
        }
        else {
            Conservatory();
        }
        return gameWon = true;
    }



    }









