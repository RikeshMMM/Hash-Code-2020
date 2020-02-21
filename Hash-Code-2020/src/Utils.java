public class Utils {

    public static int libraryScore(Library library) {

        int score = 0;
        score -= library.signUpTime * 50;
        score += library.booksPerDay * 3;

        for (Book book : library.books) {
            score += book.score;
        }

        return score;
    }
}
