package com.indra.book_my_show.Controllers;

import com.indra.book_my_show.Request.UserEntryDto;
import com.indra.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto) {

        try {
            String response = userService.addUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            String result = "User couldn't be added.";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

        }
    }



}
