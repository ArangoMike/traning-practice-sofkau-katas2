package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {

    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        Double res = movies.stream()
                .map(x -> x.getRating())
                .reduce((aDouble, aDouble2) -> Double.max(aDouble, aDouble2))
                .get();
        System.out.println(res);
        return res;
    }
}
