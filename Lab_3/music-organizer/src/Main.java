import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MusicCollection[] categories = new MusicCollection[4];
        categories[0] = new MusicCollection();
        categories[1] = new MusicCollection();
        categories[2] = new MusicCollection();
        categories[3] = new MusicCollection();
        Scanner input = new Scanner(System.in);
        String inputString = "";
        while(!inputString.equals("exit")){
            System.out.print("1.please Enter the category first (Pop,Jazz,Rock,Country)\n" +
                    "2. if you want to handling the music player type \"music player\" ");
            inputString  = input.nextLine();
            switch (inputString){
                case "Pop":
                    printingMenu();
                    inputString = input.nextLine();
                    if(inputString.equals("add")){
                        MusicInfo temp = new MusicInfo();
                        System.out.print("please enter the file name: ");
                        temp.setFileAddress(input.nextLine());
                        System.out.print("please enter the singer name: ");
                        temp.setSingerName(input.nextLine());
                        System.out.print("please enter the distribution year: ");
                        temp.setDistributedYear(input.nextLine());
                        categories[0].addFile(temp);
                    }
                    else if(inputString.equals("add fav")){
                        System.out.print("note : the file name must be added before with the add command \n" +
                                "please enter the file name: ");
                        categories[0].addingFavouriteMusic(input.nextLine());
                    }
                    else if(inputString.equals("remove")){
                        System.out.print("please enter the index of the song that you want to remove");
                        categories[0].removeFile(input.nextInt());
                    }
                    else if(inputString.equals("remove fav")){
                        System.out.print("please enter the file address of the song that you want to remove");
                        categories[0].removeFavouriteFile(input.nextLine());
                    }
                    else if(inputString.equals("print info")){
                        categories[0].listAllFiles();
                    }
                    else if(inputString.equals("print info fav")){
                        categories[0].printFavouriteMusics();
                    }
                    else if(inputString.equals("search")){
                        System.out.print("please enter the name of the singer or the file name to search for you adn print the info :");
                        categories[0].searchMusic(input.nextLine());
                    }
                    break;
                case "Jazz":
                    printingMenu();
                    inputString = input.nextLine();
                    if(inputString.equals("add")){
                        MusicInfo temp = new MusicInfo();
                        System.out.print("please enter the file name: ");
                        temp.setFileAddress(input.nextLine());
                        System.out.print("please enter the singer name: ");
                        temp.setSingerName(input.nextLine());
                        System.out.print("please enter the distribution year: ");
                        temp.setDistributedYear(input.nextLine());
                        categories[1].addFile(temp);
                    }
                    else if(inputString.equals("add fav")){
                        System.out.print("note : the file name must be added before with the add command \n" +
                                "please enter the file name: ");
                        categories[1].addingFavouriteMusic(input.nextLine());
                    }
                    else if(inputString.equals("remove")){
                        System.out.print("please enter the index of the song that you want to remove");
                        categories[1].removeFile(input.nextInt());
                    }
                    else if(inputString.equals("remove fav")){
                        System.out.print("please enter the file address of the song that you want to remove");
                        categories[1].removeFavouriteFile(input.nextLine());
                    }
                    else if(inputString.equals("print info")){
                        categories[1].listAllFiles();
                    }
                    else if(inputString.equals("print info fav")){
                        categories[1].printFavouriteMusics();
                    }
                    else if(inputString.equals("search")){
                        System.out.print("please enter the name of the singer or the file name to search for you adn print the info :");
                        categories[1].searchMusic(input.nextLine());
                    }
                    break;
                case "Rock":
                    printingMenu();
                    inputString = input.nextLine();
                    if(inputString.equals("add")){
                        MusicInfo temp = new MusicInfo();
                        System.out.print("please enter the file name: ");
                        temp.setFileAddress(input.nextLine());
                        System.out.print("please enter the singer name: ");
                        temp.setSingerName(input.nextLine());
                        System.out.print("please enter the distribution year: ");
                        temp.setDistributedYear(input.nextLine());
                        categories[2].addFile(temp);
                    }
                    else if(inputString.equals("add fav")){
                        System.out.print("note : the file name must be added before with the add command \n" +
                                "please enter the file name: ");
                        categories[2].addingFavouriteMusic(input.nextLine());
                    }
                    else if(inputString.equals("remove")){
                        System.out.print("please enter the index of the song that you want to remove");
                        categories[2].removeFile(input.nextInt());
                    }
                    else if(inputString.equals("remove fav")){
                        System.out.print("please enter the file address of the song that you want to remove");
                        categories[2].removeFavouriteFile(input.nextLine());
                    }
                    else if(inputString.equals("print info")){
                        categories[2].listAllFiles();
                    }
                    else if(inputString.equals("print info fav")){
                        categories[2].printFavouriteMusics();
                    }
                    else if(inputString.equals("search")){
                        System.out.print("please enter the name of the singer or the file name to search for you adn print the info :");
                        categories[2].searchMusic(input.nextLine());
                    }
                    break;
                case "Country":
                    printingMenu();
                    inputString = input.nextLine();
                    if(inputString.equals("add")){
                        MusicInfo temp = new MusicInfo();
                        System.out.print("please enter the file name: ");
                        temp.setFileAddress(input.nextLine());
                        System.out.print("please enter the singer name: ");
                        temp.setSingerName(input.nextLine());
                        System.out.print("please enter the distribution year: ");
                        temp.setDistributedYear(input.nextLine());
                        categories[3].addFile(temp);
                    }
                    else if(inputString.equals("add fav")){
                        System.out.print("note : the file name must be added before with the add command \n" +
                                "please enter the file name: ");
                        categories[3].addingFavouriteMusic(input.nextLine());
                    }
                    else if(inputString.equals("remove")){
                        System.out.print("please enter the index of the song that you want to remove");
                        categories[3].removeFile(input.nextInt());
                    }
                    else if(inputString.equals("remove fav")){
                        System.out.print("please enter the file address of the song that you want to remove");
                        categories[3].removeFavouriteFile(input.nextLine());
                    }
                    else if(inputString.equals("print info")){
                        categories[3].listAllFiles();
                    }
                    else if(inputString.equals("print info fav")){
                        categories[3].printFavouriteMusics();
                    }
                    else if(inputString.equals("search")){
                        System.out.print("please enter the name of the singer or the file name to search for you adn print the info :");
                        categories[3].searchMusic(input.nextLine());
                    }
                    break;
                case "music player":
                    System.out.print("1.for playing a music type \"play\" \n" +
                            "2.please type \"stop\" for making the music stop \n" );
                    inputString = input.nextLine();
                    if(inputString.equals("play")){
                        System.out.print("please type the category you want to play music from: ");
                        String category = input.nextLine();
                        switch(category){
                            case "Pop":
                                System.out.print("please type the index of the number you want to play: ");
                                categories[0].startPlaying(input.nextInt());
                                break;
                            case "Jazz":
                                System.out.print("please type the index of the number you want to play: ");
                                categories[1].startPlaying(input.nextInt());
                                break;
                            case "Rock":
                                System.out.print("please type the index of the number you want to play: ");
                                categories[2].startPlaying(input.nextInt());
                                break;
                            case "Country":
                                System.out.print("please type the index of the number you want to play: ");
                                categories[3].startPlaying(input.nextInt());
                                break;
                        }
                    }
                    else if(inputString.equals("stop")){
                        categories[0].stopPlaying();
                        categories[1].stopPlaying();
                        categories[2].stopPlaying();
                        categories[3].stopPlaying();
                    }
                    break;
                default:
                    System.out.print("Wrong input Try again \n" +
                            "***********************************************************");
            }

        }

    }
    public static void printingMenu(){
        System.out.println("1.please type \"add\" for adding a music \n" +
                "2.please type \"add fav\" for adding to the favorite playlist \n" +
                "3.please type \"remove\" for removing a music from playlist \n" +
                "4.please enter \"remove fav\" for removing from the favorite playlist \n"+
                "5.please type \"print info\" for printing all the songs info \n" +
                "6.please type \"print info fav\" for printing all the favorite songs info \n" +
                "7.please type \"search\" for searching a music by its filename or singer \n" +
                "*******************************************************************************");
    }
}
