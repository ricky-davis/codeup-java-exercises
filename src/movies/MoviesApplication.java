package movies;
import util.Input;
import java.util.Arrays;
public class MoviesApplication {
    public static void main(String[] args) {
        Input input = new Input();
        boolean exit = false;
        Movie tempMoviesArray[] = MoviesArray.findAll();
        do {
            int choice;
            do {
                System.out.println("What would you like to do?\n" +
                        "\n" +
                        "0 - exit\n" +
                        "1 - view all movies\n" +
                        "2 - view movies in the animated category\n" +
                        "3 - view movies in the drama category\n" +
                        "4 - view movies in the horror category\n" +
                        "5 - view movies in the scifi category\n" +
                        "6 - Add a new movie");
                choice = input.getInt();
            } while (choice < 0 || choice > 6);
            String category = "";
            boolean add = false;
            switch (choice) {
                case 0:
                    exit = true;
                    return;
                case 1:
                    category = "all";
                    break;
                case 2:
                    category = "animated";
                    break;
                case 3:
                    category = "drama";
                    break;
                case 4:
                    category = "horror";
                    break;
                case 5:
                    category = "scifi";
                    break;
                case 6:
                    add = true;
                    break;
            }
            if(!add) {
                Movie[] filteredMovies = {};
                for (Movie movie : tempMoviesArray) {
                    if (movie.getCategory().equals(category) || category.equals("all")) {
                        filteredMovies = Arrays.copyOf(filteredMovies, filteredMovies.length + 1);
                        filteredMovies[filteredMovies.length - 1] = movie;
                    }
                }
                for (Movie movie : filteredMovies) {
                    System.out.println(movie.getName() + "  -- " + movie.getCategory());
                }
                System.out.println("\n\n\n");
            }else{
                String name;
                System.out.println("What is the name of the movie?");
                name = input.getString();
                System.out.println("What is the category of the movie?");
                category = input.getString();
                tempMoviesArray = Arrays.copyOf(tempMoviesArray, tempMoviesArray.length + 1);
                Movie newMovie = new Movie(name,category);
                tempMoviesArray[tempMoviesArray.length - 1] = newMovie;
                System.out.println("Added "+newMovie.getName()+" -- "+newMovie.getCategory());
            }
        }while(!exit);
    }
}
