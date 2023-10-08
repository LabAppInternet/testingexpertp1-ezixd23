package cat.tecnocampus.fgcstations;

import cat.tecnocampus.fgcstations.application.DTOs.FriendsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

@SpringBootTest
class FgCstationsApplicationTests {


    private TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAddFriend_ValidUsername() {
        String url = "http://localhost:" + port + "/api/users/friends";
        FriendsDTO validFriend = new FriendsDTO();
        validFriend.setUsername("validusername"); // Valid username (between 3 and 255 characters, lowercase)

        ResponseEntity<Void> response = restTemplate.postForEntity(url, validFriend, Void.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAddFriend_InvalidUsername() {
        String url = "http://localhost:" + port + "/api/users/friends";
        FriendsDTO invalidFriend = new FriendsDTO();
        invalidFriend.setUsername("ab"); // Invalid username (less than 3 characters, lowercase)

        ResponseEntity<Void> response = restTemplate.postForEntity(url, invalidFriend, Void.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
