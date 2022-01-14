package facades;

import dtos.RaceDTO;
import entities.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RaceFacade {
    private static EntityManagerFactory emf;
    private static RaceFacade instance;

    private RaceFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static RaceFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RaceFacade();
        }
        return instance;
    }

    public boolean CreateComment(RaceDTO mDTO) {
        EntityManager em = emf.createEntityManager();
        Race race = em.find(Race.class, mDTO.getName());

        if (race != null) {
//            Race race2 = new Race(mDTO.getId(), mDTO.getDate(), mDTO.getTime(), mDTO.getLocation());

            em.getTransaction().begin();
            em.merge(race);
//            em.merge(race2);
            em.getTransaction().commit();

        }

        return true;
    }

//    public MovieDTO getMoviesById(long id) {
//        EntityManager em = emf.createEntityManager();
//        Movie movie = em.find(Movie.class, id);
//        return new MovieDTO(movie);
//    }
//
//
//    public String searchMovie(MovieDTO mDTO) {
//        EntityManager em = emf.createEntityManager();
//        Movie movie = em.find(Movie.class, mDTO.getTitle());
//        return "you have searched for: " + movie;
//
//    }
//
//
//    public MovieDTO getMovieByTitle(MovieDTO title) {
//        EntityManager em = emf.createEntityManager();
//        Movie movie = em.find(Movie.class, title);
//        return new MovieDTO(movie);
//    }

//    public static void main(String[] args) {
//        MovieFacade movieFacade = getMovieFacade(EMF_Creator.createEntityManagerFactory());
//        movieFacade.getMovieByTitle(new MovieDTO(1, "To protect his family from a powerful drug lord, skilled thief Mehdi and his expert team of robbers are pulled into a violent and deadly turf war.", "Ganglands", "ganglands.jpg"));
//    }

}
