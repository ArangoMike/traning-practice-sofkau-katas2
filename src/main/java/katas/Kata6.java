package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        String url = movies.stream()
                .flatMap(x ->
                        x.getBoxarts().stream())
                .reduce((a, b) -> {
                    BoxArt res = ((a.getHeight() * a.getWidth()) >= (b.getHeight() * b.getWidth())) ? a : b;
                    return res;

                }).map(f -> f.getUrl())
                .get();

        System.out.println(url);

        return url;
    }
}
