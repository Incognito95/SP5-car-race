package rest;

import com.google.gson.Gson;
import dtos.RaceDTO;
import entities.*;

import java.sql.*;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import entities.Driver;
import facades.RaceFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {


    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    public static final RaceFacade RACE_FACADE = RaceFacade.getMovieFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public List<User> GetInfoFromUser() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <User> query = em.createQuery("SELECT u from User u where u.userName = :username", entities.User.class);
        List<User> result = query.getResultList();
        return result;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("CreateRace")
    public String AddMovieComment(String jsonString) throws SQLException {
        System.out.println(jsonString);
        RaceDTO mDTO = gson.fromJson(jsonString, RaceDTO.class);
        System.out.println("ID: " + mDTO.getId() + "Name: " + mDTO.getName() + " Date: " + mDTO.getDate() + " Time: " + mDTO.getTime() + " Location: " + mDTO.getLocation());
        RACE_FACADE.CreateComment(mDTO);
        return "{}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("races")
    public List<Race> ShowAllRaces() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Race> query = em.createQuery("SELECT r FROM Race r", entities.Race.class);
        List<Race> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("specific-cars")
    public List<Car> ShowAllCarsBelongingToSpecificRace() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createNativeQuery("SELECT race_id, race_name, brand , make, car_year FROM car INNER JOIN race WHERE brand = \"Williams\" AND race_id = 2");

        List<Car> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("specific-drivers")
    public List<Driver> ShowAllDriversInASpecificRace() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createNativeQuery("SELECT race_name, driver_name FROM driver INNER JOIN race WHERE race_name = \"British Grand Prix\"");

        List<Driver> result = query.getResultList();
        return result;
    }



}