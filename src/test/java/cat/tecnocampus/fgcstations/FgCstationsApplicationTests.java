package cat.tecnocampus.fgcstations;

import cat.tecnocampus.fgcstations.application.DTOs.FriendsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FgCstationsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    FriendsDTO validF;
    @Test
    void testUsernameFriend() throws Exception{
        validF = new FriendsDTO();
        validF.setUsername("valid");
        validF.setFriends();

        String friend = """
                    {"username": "valid",
                     "friends": ["tina"] 
                    }
                    """;
        }


    /*
    @Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Test
    public void testAddFriend_ValidUsername() {
        String url = "http://localhost:" + port + "/api/users/friends";
        FriendsDTO validFriend = new FriendsDTO();
        validFriend.setUsername("validusername"); // Valid username (between 3 and 255 characters, lowercase)

        ResponseEntity<Void> response = restTemplate.postForEntity(url, validFriend, Void.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    */
}
