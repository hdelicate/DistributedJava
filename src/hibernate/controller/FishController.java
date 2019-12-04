package hibernate.controller;

import hibernate.entity.FishSpecies;
import hibernate.service.FishService;
import hibernate.service.FishingSpotService;
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
import java.util.List;

@Controller
    @RequestMapping("/fish")
    public class FishController {

        @Autowired
        private FishService fishService;
    @Autowired
    private FishingSpotService fishingSpotService;


        @RequestMapping("/list")
        public String listFish(Model theModel) {
            List<FishSpecies> theList = fishService.getFishes();

            theModel.addAttribute("fish", theList);

            return "list-fish";
        }

        @GetMapping("/search")
        public String search(@RequestParam("searchTerm") String theSearchTerm,
                             Model theModel) {

            List<FishSpecies> theList = fishService.getFishByName(theSearchTerm);

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
            FishSpecies existingFish = fishService.getFish(theId);

            theModel.addAttribute("aFish", existingFish);

            theModel.addAttribute("shops", fishingSpotService.getSpots());

            return "add-fish-form";
        }

        @GetMapping("/showAddFishForm")
        public String showAddFishForm(Model theModel) {
            FishSpecies plainFish = new FishSpecies();

            theModel.addAttribute("aFish", plainFish);

            theModel.addAttribute("shops", fishingSpotService.getSpots());

            return "add-fish-form";
        }

        @PostMapping("/save")
        public String saveFish(@RequestParam(name = "fishImage") MultipartFile file,
                                @Valid @ModelAttribute(name = "aFish") FishSpecies theFish,
                                BindingResult bindingResult,
                                Model theModel,
                                HttpServletRequest request) {
            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult);

                theModel.addAttribute("shops", fishingSpotService.getSpots());

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

