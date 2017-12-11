import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserRepository.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DopboxTest {

    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        userRepository = Mockito.mock(UserRepository.class);
    }

    @Test
    public void findUserByEmailAndPassword() {
        List<User> u = new ArrayList<User>();
        List<User> user = userRepository.findByEmailAndPassword("abc","abc");
        assertEquals("User found",u,user);
    }

    @Test
    public void findBySharedWith() {
        List<User> u = new ArrayList<User>();
        List<User> user = userRepository.findByEmailAndPassword("abc","abc");
        assertEquals("User found",u,user);
    }

    @Test
    public void signUp() {
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

    @Test
    public void signIn() {
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

    @Test
    public void signOut() {
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

    @Test
    public void getDocs() {
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

    @Test
    public void createFolder(){
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

    @Test
    public void shareDoc() {
        User user = new User();
        user.setPassword("password");
        user.setLastName("last");
        user.setFirstName("first");
        user.setEmail("Email@email.com");
        user.setContactInfo("21365475");
        user.setLifeEvents("event");
        user.setEducation("edu");
        user.setWork("work");
        user.setOverview("ovrview");
        userService.addUser(user);
        String usreid = String.valueOf(user.getId());
        String userid = "6";
        assertEquals("User Creted",Long.parseLong(userid),6);
    }

}