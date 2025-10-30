package cat.itacademy.s04.t01.userapi;

import cat.itacademy.s04.t01.userapi.controller.UserController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import cat.itacademy.s04.t01.userapi.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Test
    public void getUsersReturnAnEmptyListInitially() throws Exception{
    mockMvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
    }
    @Test
    public void createUserReturnsUserWithId()throws Exception{
        User newUser = new User();
        newUser.setName("Andres");
        newUser.setEmail(("andrescalvo01@gmail.com"));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",not(empty())))
                .andExpect(jsonPath("$.name", is("Andres")))
                .andExpect(jsonPath("$.email", is("andrescalvo01@gmail.com")));
    }
    @Test
    public void getUserByIdReturnsCorrectUser()throws Exception{
        User newUser= new User();
        newUser.setName("Andres");
        newUser.setEmail("andres.calvo01@gmail.com");

        String response= mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        User createdUser = objectMapper.readValue(response, User.class);
        UUID id = createdUser.getId();

        mockMvc.perform(get("/users/{id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.toString())))
                .andExpect(jsonPath("$.name", is("Andres")));

    }

    @Test
    void getUserById_returnsNotFoundIfMissing() throws Exception {
        mockMvc.perform(get("/users/{id"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getUsersWithName_Param_returnsFilteredUsers() throws Exception {
        User user1 = new User();
        user1.setName("Jordi");
        user1.setEmail("jordi@gmail.com");

        User user2 = new User();
        user2.setName("Ana");
        user2.setEmail("ana@gmail.com");

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user1)));

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user2)));

        mockMvc.perform(get("/users?name=jo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", hasSize(1)))
                .andExpect(jsonPath("$[0].name", containsStringIgnoringCase("jo")));
    }
}
