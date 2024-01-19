package kr.co.kwonshzzang.bookmanager.bookmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private String city;      //시
    private String district;  //구
    @Column(name = "address_detail")
    private String detail;    //상세주소
    private String zipCode;   //우편번호
}
