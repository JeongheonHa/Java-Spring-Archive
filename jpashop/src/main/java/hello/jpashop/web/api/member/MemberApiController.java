package hello.jpashop.web.api.member;

import hello.jpashop.model.member.domain.Member;
import hello.jpashop.model.member.dto.*;
import hello.jpashop.model.member.service.MemberAssembler;
import hello.jpashop.model.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<MemberResponse> saveMember(@RequestBody @Valid MemberSignUpRequest request, BindingResult bindingResult) {

        Member member = MemberAssembler.toEntity(request);
        Long savedId = memberService.join(member);

        return new ResponseEntity<>(new MemberResponse(savedId, member.getName()), HttpStatus.OK);
    }

    @PutMapping("/api/members/{id}")
    public ResponseEntity<UpdateMemberResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateMemberRequest request, BindingResult bindingResult) {

        memberService.update(id, request);
        Member findMember = memberService.findById(id);

        return new ResponseEntity<>(new UpdateMemberResponse(findMember.getId(), findMember.getName()), HttpStatus.OK);
    }

    @GetMapping("/api/members")
    public ResponseEntity<MembersResponse> findMembers() {
        List<MemberResponse> collect = memberService.findMembers().stream()
                .map(m -> new MemberResponse(m.getId(), m.getName()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new MembersResponse(collect.size(), collect), HttpStatus.OK);
    }
}
