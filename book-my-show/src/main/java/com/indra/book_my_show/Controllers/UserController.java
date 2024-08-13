package com.indra.book_my_show.Controllers;

import com.indra.book_my_show.EntryDtos.UserEntryDto;
import com.indra.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserEntryDto userEntryDto) {
        return "";
    }

}
