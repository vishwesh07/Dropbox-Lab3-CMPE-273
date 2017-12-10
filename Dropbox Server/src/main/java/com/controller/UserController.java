package com.controller;

import com.entity.Document;
import com.entity.User;
import com.service.DocumentService;
import com.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DocumentService documentService;

    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.addUser(user);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
    }

    @PostMapping(path="/getFiles",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFiles(@RequestBody String data)
    {
        JSONObject jsonObject = new JSONObject(data);
        System.out.println("Data: "+data);
        List<Document> l= documentService.getFiles(jsonObject.getString("owner"),jsonObject.getString("path"));
        System.out.println("List "+ l);
        return new ResponseEntity(l,HttpStatus.OK);
    }

    @PostMapping(path="/signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("User: "+user);
        session.setAttribute("name",jsonObject.getString("email"));
        List<User> l= userService.checkUserExists(jsonObject.getString("email"));
        System.out.println("List "+ l);
        if(l.size() >= 1){
            System.out.println("!!User Already Exists!!");
            return new ResponseEntity("!!User Already Exists!!",HttpStatus.FORBIDDEN);
        }
        else{
            System.out.println("User Added");
            userService.addUser(new User(jsonObject.getString("firstName"),jsonObject.getString("lastName"),jsonObject.getString("email"),jsonObject.getString("password"),jsonObject.getString("overview"),jsonObject.getString("work"),jsonObject.getString("education"),jsonObject.getString("contactInfo"),jsonObject.getString("lifeEvents")));
            try {

                File f;
                boolean bool;

                // returns pathnames for files and directory
                f = new File("D:\\SJSU Study Docs\\Fall 17\\Courses\\273 Shim\\Labs\\Lab 3\\Dropbox\\Dropbox Server\\src\\public\\"+jsonObject.getString("email"));

                // create
                bool = f.mkdir();

                // print
                System.out.print("Directory created ? "+bool);

            } catch(Exception e) {

                // if any error occurs
                e.printStackTrace();
            }
            JSONObject json = new JSONObject();
            Map test = new HashMap();
            test.put("email", "uno");
            return new ResponseEntity(l,HttpStatus.CREATED);
        }
    }

    @PostMapping(path="/signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("User: "+user);
        session.setAttribute("name",jsonObject.getString("username"));
        List<User> l= userService.login(jsonObject.getString("username"),jsonObject.getString("password"));
        System.out.println("List "+ l);
        if(l.size() == 1){
            return new ResponseEntity(l,HttpStatus.OK);
        }
        else{
            return new ResponseEntity(l,HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/signOut")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }
}