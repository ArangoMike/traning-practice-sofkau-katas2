package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> movieList2 = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(),
                                "boxart",movie.getBoxarts().stream().reduce((a, b) -> {
                            BoxArt res = ((a.getHeight() * a.getWidth()) < (b.getHeight() * b.getWidth())) ? a : b;
                            return res;
                        })
                        .map(boxArt -> boxArt.getUrl())))
                .collect(Collectors.toList());

        System.out.println(movieList2.toString());

        return movieList2;
    }
}
