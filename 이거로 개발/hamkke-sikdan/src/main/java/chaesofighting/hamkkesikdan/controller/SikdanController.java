package chaesofighting.hamkkesikdan.controller;

import chaesofighting.hamkkesikdan.repository.SikdanResult;
import chaesofighting.hamkkesikdan.service.SikdanService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SikdanController {
    //입력값 키, 몸무게, 성별, 질환 , 운동정도(추가됨), 나이
    //(기초대사량 * 활동계수)
    //=> 입력값은 총칼로리량 질환정보 랜덤변수
    private final SikdanService sikdanService;
    private UserRequest request = new UserRequest();
    private Random random = new Random();

    //메인 페이지
    @RequestMapping("/")
    public String main() {
        return "index copy";  //index copy.html을 찾아감.
    }

    /*@GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test 123";
    }

    @GetMapping("/get-sikdan")
    @ResponseBody
    public String getSikdan(HttpServletRequest request) {
        String kcal = request.getParameter("kcal");
        return kcal;
    }*/


    //사용자 입력 페이지
    @GetMapping("/calculate") //리소스 -> 조회
    public String createForm(Model model) {
        model.addAttribute("userForm", new UserRequest());
        //model.addAttribute("msg", "test");
        //return "usersCalorie";
        return "calculate";
    }

    @GetMapping("/sikdan") //리소스 -> 조회
    public String dd(Model model) {
        model.addAttribute("userForm", new UserRequest());
        //model.addAttribute("msg", "test");
        //return "usersCalorie";
        return "sikdan";
    }

    //사용자 입력 페이지
    @PostMapping("/calculate") //리소스 서버에 저장
    public String receive(@RequestBody UserRequest request) { //결과 반환을 딱히 안해도 되는건가
        /*this.form.setCalorie(form.getCalorie());
        this.form.setSyndrome(form.getSyndrome());
        this.form.setRand(form.getRand());*/
        this.request.setTotalCalories(request.getTotalCalories());
        this.request.setSyndrome(request.getSyndrome());
        this.request.setRand(request.getRand());

        //잘 받았는지 체크
        System.out.println(this.request.getTotalCalories());
        System.out.println(this.request.getSyndrome());
        System.out.println(this.request.getRand());

        return "sikdan";
    }

    //식단 추천 페이지
    @GetMapping("/sikdans")
    @ResponseBody
    public SikdanResult sikdan(HttpServletRequest request) {
        int calorie = Integer.parseInt(request.getParameter("calorie"));
        int syndrome = Integer.parseInt(request.getParameter("syndrome"));

        log.info(Integer.toString(calorie));
        log.info(Integer.toString(syndrome));
        //int rand = Integer.parseInt(request.getParameter("rand"));
        SikdanResult sikdanResult = sikdanService.showSikdan(calorie, syndrome, 2); //random.nextInt(5)
        log.info(sikdanResult.getBreakfast());
        log.info(sikdanResult.getLunch());
        log.info(sikdanResult.getDinner());
        return sikdanResult;
    }

}
