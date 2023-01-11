package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        Predicate<BoxArt> boxArtPredicate = b -> b.getHeight().equals(200) && b.getWidth().equals(150);

        List<Map> movieLists2 = movieLists.stream()
                .flatMap(x -> x.getVideos().stream())
                .map(z -> {
                    BoxArt boxArt = z.getBoxarts().stream().filter(boxArtPredicate).findAny().get();
                    return ImmutableMap.of("id", z.getId(), "title", z.getTitle(), "boxart", boxArt);
                }).collect(Collectors.toList());

        return movieLists2;
    }
}
