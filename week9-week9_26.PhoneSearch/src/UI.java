import java.util.Scanner;

public class UI {
    /// ATRYBUTY OBIEKTÓW TEJ KLASY ///
    private Scanner reader;

    /// KONSTRUKTOR ///
    public UI(Scanner reader) {
        this.reader = reader;
    }

    /// METODY ///

    /// Metoda obsługująca pętle z menu ///
    public void userInterface() {

        /// Inicjalizacja książki adresowej ///
        PhoneAndAdressBook book = new PhoneAndAdressBook(reader);

        /// Wyświetlenie menu poczatkowego ///
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit");

        /// Petla "command" ///
        String userInput = "";
        while (!userInput.equals("x")) {
            System.out.println("");
            System.out.print("command: ");
            userInput = reader.nextLine();
            /// Dodaj numer do osoby ///
            if (userInput.equals("1")) {
                book.addNumberToPerson();
            }
            /// Szukaj numeru po osobie ///
            else if (userInput.equals("2")) {
                book.searchNumberByPerson();
            }
            /// Szukaj osoby po numerze ///
            else if (userInput.equals("3")) {
                book.searchPersonByNumber();
            }
            /// Dodaj adres do osoby ///
            else if (userInput.equals("4")) {
                book.addAddress();
            }
            /// Podaj wszystkie znane informacje o osobie ///
            else if (userInput.equals("5")) {
                System.out.print("whose information: ");
                String name = this.reader.nextLine();
                book.giveInfo(name);
            }
            /// Usuń wszelkie informacje o osobie ///
            else if (userInput.equals("6")) {
                book.deletePersonalInfo();
            }
            /// Wyszukaj po frazie ///
            else if (userInput.equals("7")) {
                book.searchByString();
            }

        }
    }


}
