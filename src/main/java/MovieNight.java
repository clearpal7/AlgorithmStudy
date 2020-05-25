import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {

        public static Boolean canViewAll(Collection<Movie> movies) {
            List<Movie> movieList = new ArrayList<>(movies);
            Collections.sort(movieList);

            for(int i = 1; i < movieList.size(); i++) {
                Movie before = movieList.get(i-1);
                Movie after = movieList.get(i);
                if(isOverLap(before, after))
                    return false;
            }
            return true;
        }

        private static boolean isOverLap(Movie before, Movie after) {
            if(before.getEnd().after(after.getStart()))
                return true;
            return false;
        }

        public static void main(String[] args) throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

            ArrayList<Movie> movies = new ArrayList<Movie>();
            movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 23:30")));
            movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
            movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

            System.out.println(MovieNight.canViewAll(movies));
        }
}

class Movie implements Comparable {
    private Date start, end;

    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(Object o) {
        Movie other = (Movie)o;
        return this.getStart().compareTo(other.getStart());
    }
}