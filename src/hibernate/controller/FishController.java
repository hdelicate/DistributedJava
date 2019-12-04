package hibernate.controller;

import hibernate.entity.FishSpecies;
import hibernate.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

    @Controller
    @RequestMapping("/fish")
    public class FishController {

        @Autowired
        private FishService fishService;



        @RequestMapping("/list")
        public String listFish(Model theModel) {
            List<FishSpecies> theList = fishService.getFish();

            theModel.addAttribute("fish", theList);

            return "list-fish";
        }

        @GetMapping("/search")
        public String search(@RequestParam("searchTerm") String theSearchTerm,
                             Model theModel) {

            List<Fish> theList = fishService.getFishByName(theSearchTerm);

            theModel.addAttribute("fish", theList);

            return "list-fish";
        }

        @GetMapping("/delete")
        public String deleteFish(@RequestParam("fishId") int theId){
            fishService.deleteFish(theId);

            return "redirect:/fish/list";
        }

        @RequestMapping("/showUpdateFishForm")
        public String showUpdateFishForm(@RequestParam("fishId") int theId,
                                          Model theModel) {
            Fish existingFish = fishService.getFish(theId);

            theModel.addAttribute("aFish", existingFish);

            theModel.addAttribute("shops", fishShopService.getShops());

            return "add-fish-form";
        }

        @GetMapping("/showAddFishForm")
        public String showAddFishForm(Model theModel) {
            Fish plainFish = new Fish();

            theModel.addAttribute("aFish", plainFish);

            theModel.addAttribute("shops", fishShopService.getShops());

            return "add-fish-form";
        }

        @PostMapping("/save")
        public String saveFish(@RequestParam(name = "fishImage") MultipartFile file,
                                @Valid @ModelAttribute(name = "aFish") Fish theFish,
                                BindingResult bindingResult,
                                Model theModel,
                                HttpServletRequest request) {
            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult);

                theModel.addAttribute("shops", fishShopService.getShops());

                return "add-fish-form";
            }

            fishService.saveFish(theFish, file, request.getServletContext().getRealPath("/"));

            return "redirect:/fish/list";
        }


        @InitBinder
        public void initBinder(WebDataBinder webDataBinder) {
            StringTrimmerEditor ste = new StringTrimmerEditor(true);

            webDataBinder.registerCustomEditor(String.class, ste);
        }
    }

