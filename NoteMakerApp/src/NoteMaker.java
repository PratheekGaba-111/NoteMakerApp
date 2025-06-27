import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class NoteMaker {
    static int counter = 1;
    static int flag = 0;
    static boolean pri = false;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        print();
        while(value){
            try{
                System.out.println("Enter your choice-");
                int ch = Integer.parseInt(sc.next());

                switch(ch){
                    case 1:
                        String s1 = null;
                        addNewNote(s1);
                        break;
                    case 2:
                        String s = null;
                        appendNewNote(s);
                        break;
                    case 3:
                        try{
                            if(flag == 1){
                                viewNotes();
                            }
                            else{
                                System.out.println("Sorry the Notes File is empty!!");
                            }
                        }
                        catch(FileNotFoundException e){
                            System.out.println("Sorry the Notes File is not created!!");
                        }
                        break;
                    case 4:
                        try{
                            searchNote();
                        }
                        catch(FileNotFoundException f){
                            System.out.println("Sorry the Notes File is not created!!");
                        }
                        catch(IOException e){
                            System.out.println();
                        }
                        break;
                    case 5:
                        try{
                            deleteNote();
                        }
                        catch(FileNotFoundException f){
                            System.out.println("Sorry the Notes File is not created!!");
                        }
                        catch(IOException e){
                            System.out.println();
                        }

                        break;
                    case 6:
                        try{
                            deleteNotes();
                        }
                        catch(Exception e){

                        }
                        break;
                    case 7:
                        print();
                        break;
                    case 8:
                        value = false;
                        break;

                    default:
                        System.out.println("Invalid choice please reenter");
                        ch = sc.nextInt();
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input type please re - enter");
            }
        }
    }
    static void addNewNote(String s1){
        try{
            if(s1 == null){
                System.out.println("Enter the note which you want to enter!!");
                Scanner sc = new Scanner(System.in);
                s1 = sc.nextLine();
            }
            FileWriter wr1 = new FileWriter("Notes.txt",false);
            counter = 1;
            flag = 1;
            wr1.write("--- NOTE "+ counter +" ---\n");
            wr1.write(s1+ "\n");
            wr1.close();
            counter++;
            if(pri != true){
                System.out.println("Note Added successfully :)");
            }
            pri = false;
        }catch(IOException e){
            System.out.println();
        }
    }
    static void appendNewNote(String s){
        try{
            if(s == null){
                System.out.println("Enter the note which you want to enter!!");
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine();
            }
            FileWriter wr1 = new FileWriter("Notes.txt",true);

            flag = 1;
            wr1.write("--- NOTE "+ counter +" ---\n");
            wr1.write(s+ "\n");
            counter++;
            wr1.close();
            if(pri != true){
                System.out.println("Note Added successfully :)");
            }
            pri = false;
        }catch(IOException e){
            System.out.println();
        }
    }
    static void viewNotes() throws FileNotFoundException{
        try{
            FileReader reader = new FileReader("Notes.txt");
            int ch;
            flag = 1;
            while((ch = reader.read()) != -1){
                System.out.print((char) ch);
            }
            reader.close();
        }
        catch(Exception e){
            System.out.println();
        }
    }
    static void searchNote() throws FileNotFoundException,IOException{
        try{
            flag = 1;
            BufferedReader br = new BufferedReader(new FileReader("Notes.txt"));
            String line;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Keyword to search");
            String keyword = sc.next();
            StringBuilder currentNote = new StringBuilder();
            boolean foundAny = false;
            while((line = br.readLine()) != null){
                if(line.startsWith("--- NOTE")){
                    //previous one can have
                    if(currentNote.toString().toLowerCase().contains(keyword.toLowerCase())){
                        System.out.println(currentNote.toString());
                        foundAny = true;
                    }
                    //reset note
                    currentNote.setLength(0);
                }
                currentNote.append(line).append("\n");

            }
            //last one is left over so check thati
            if(currentNote.toString().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(currentNote.toString());
                foundAny = true;
            }
            if(!foundAny){
                System.out.println("No Matching notes found!");
            }
        }catch(Exception e){

        }

    }
    static void deleteNote() throws FileNotFoundException,IOException{
        try{
            BufferedReader br = new BufferedReader(new FileReader("Notes.txt"));
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter note number to delete");
            int num = sc.nextInt() + 48;
            ArrayList<String> list = new ArrayList<>();
            String x;
            int value = 1;
            while((x = br.readLine()) != null){
                value = 1;
                if(x.startsWith("--- NOTE")){
                    for (char c : x.toCharArray()){
                        if(c == num){
                            value = 0;
                            break;
                        }
                    }
                }
                String str = br.readLine();
//                str = br.readLine();

                if(value != 0){
                    list.add(str);
                }
                else{
                     System.out.println(x + " is the note deleted");
                }
            }
            if(list == null){
                flag = 0;
            }
            counter = 1;
            for(String s : list){
                if(!s.startsWith("--- NOTE")){
                    if(counter == 1){
                        pri = true;
                        addNewNote(s);
                    }
                    else{
                        pri = true;
                        appendNewNote(s);
                    }
                }
            }
        }
        catch(Exception e){

        }
    }
    static void deleteNotes() throws IOException{
        try{
            FileWriter fr = new FileWriter("Notes.txt");
            counter = 1;
            flag = 0;
            System.out.println("The Note file are cleared");
            fr.close();
        }
        catch(Exception e){

        }
    }
    static void print(){
        System.out.println();
        System.out.println("------WELCOME TO NOTES APP------");
        System.out.println("1. Add a new note");
        System.out.println("2. Append a new note");
        System.out.println("3. View all notes");
        System.out.println("4. Search a note");
        System.out.println("5. Delete a note");
        System.out.println("6. Delete all notes");
        System.out.println("7. Menu");
        System.out.println("8. Exit");
    }
}
