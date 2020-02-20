public class Utils {

    public static int libraryScore(Library library) {

        int score = 0;
        score -= library.signUpTime * 5;
        score += library.booksPerDay * 5;


        for (Book book : library.books) {
            score += book.score;
        }

        return score;
    }
}
