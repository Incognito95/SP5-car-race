//package facades;
//
//import dtos.MovieCommentDTO;
//import dtos.MovieDTO;
//import entities.Race;
//import entities.MovieInfo;
//import entities.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//
//public class MovieFacade {
//    private static EntityManagerFactory emf;
//    private static MovieFacade instance;
//
//    private MovieFacade() {
//    }
//
//    /**
//     *
//     * @param _emf
//     * @return the instance of this facade.
//     */
//    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new MovieFacade();
//        }
//        return instance;
//    }
//
//    public boolean CreateComment(MovieCommentDTO mDTO) {
//        EntityManager em = emf.createEntityManager();
//        User user = em.find(User.class, mDTO.getUsername());
//
//        if (user != null) {
//            Race race = em.find(Race.class, mDTO.getMovieId());
//
//            if (race != null) {
//                    MovieInfo movieInfo = new MovieInfo(mDTO.getComment(), mDTO.getRating(), race, user);
//                    user.AddMovieInfo(movieInfo);
//                    race.addMovieInfo(movieInfo);
//            }
//
//            em.getTransaction().begin();
//            em.merge(user);
//            em.merge(race);
//            em.getTransaction().commit();
//
//        }
//
//        return true;
//    }
//
//    public MovieDTO getMoviesById(long id) {
//        EntityManager em = emf.createEntityManager();
//        Race race = em.find(Race.class, id);
//        return new MovieDTO(race);
//    }
//
//
//    public String searchMovie(MovieDTO mDTO) {
//        EntityManager em = emf.createEntityManager();
//        Race race = em.find(Race.class, mDTO.getTitle());
//        return "you have searched for: " + race;
//
//    }
//
//
//    public MovieDTO getMovieByTitle(MovieDTO title) {
//        EntityManager em = emf.createEntityManager();
//        Race race = em.find(Race.class, title);
//        return new MovieDTO(race);
//    }
//
////    public static void main(String[] args) {
////        MovieFacade movieFacade = getMovieFacade(EMF_Creator.createEntityManagerFactory());
////        movieFacade.getMovieByTitle(new MovieDTO(1, "To protect his family from a powerful drug lord, skilled thief Mehdi and his expert team of robbers are pulled into a violent and deadly turf war.", "Ganglands", "ganglands.jpg"));
////    }
//
//}
