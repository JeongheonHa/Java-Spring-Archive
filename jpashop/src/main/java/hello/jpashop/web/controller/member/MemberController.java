package hello.jpashop.web.controller.member;

import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.domain.vo.Address;
import hello.jpashop.model.member.dto.MemberSignUpRequest;
import hello.jpashop.model.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String signUpFrom(Model model) {
        model.addAttribute("memberSignUpRequest", new MemberSignUpRequest());
        return "signup";
    }

    @PostMapping("/members/new")
    public String signUpMember(@Validated MemberSignUpRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        Member member = request.toEntity(request.getName(), request.getCity(), request.getStreet(), request.getZipcode());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "memberList";
    }
}
