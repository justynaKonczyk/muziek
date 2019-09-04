package be.vdab.muziek.controllers;

import be.vdab.muziek.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("album")
public class AlbumController {

    private AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public ModelAndView album(@PathVariable long id) {

        ModelAndView modelAndView = new ModelAndView("album");
        service.findById(id).ifPresent(album ->
                modelAndView.addObject(album)
        );

        return modelAndView;
    }
}
