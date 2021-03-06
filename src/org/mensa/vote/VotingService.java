package org.mensa.vote;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mensa.vote.model.Candidature;
import org.mensa.vote.model.Vote;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VotingService {

    @POST
    @Path("/candidates")
    Response addCandidate(final Candidature candidate);

    @DELETE
    @Path("/candidates/{id}")
    Response deleteCandidate(@PathParam("id") final String id);

    @GET
    @Path("/candidates/{id}")
    Candidature viewCandidateProfile(@PathParam("id") final String id);

    @PUT
    @Path("/candidates/{id}")
    Response editCandidate(@PathParam("id") final String id);

    @POST
    @Path("/votes")
    Response vote(final Vote vote);

    @GET
    @Path("/votes")
    List<Vote> viewAllVotes();

    @GET
    @Path("/votes?view=compact")
    Response viewResults();

    @POST
    @Path("/authenticate/{token}")
    Response authenticate(@PathParam("token") final String authToken);
}
