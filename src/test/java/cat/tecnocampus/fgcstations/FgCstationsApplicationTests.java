package cat.tecnocampus.fgcstations;

import cat.tecnocampus.fgcstations.application.DTOs.FriendsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

@SpringBootTest
class FgCstationsApplicationTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
    }

    @Test
    public void testInvalidFriendUsername(){
        FriendsDTO invalidFriend = new FriendsDTO();
        invalidFriend.setUsername("A");
        ResponseEntity<ErrorResponse> response = restTemplate.postForEntity("http://localhost:8080/api/users/friends", invalidFriend, ErrorResponse.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
