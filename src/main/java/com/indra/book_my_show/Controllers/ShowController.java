package com.indra.book_my_show.Controllers;

import com.indra.book_my_show.Request.AddShowRequest;
import com.indra.book_my_show.Request.AddShowSeatsRequest;
import com.indra.book_my_show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    @Autowired
    private ShowService showService;


    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest) {
        String result = showService.addShow(addShowRequest);
        return result;
    }

    @PostMapping("/addShowSeats")
    public String addShowSeats(@RequestBody AddShowSeatsRequest showSeatsRequest) {
        String result = showService.addShowSeats(showSeatsRequest);
        return result;
    }
}
