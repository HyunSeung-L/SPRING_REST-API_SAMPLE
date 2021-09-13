package org.hsl.sample_api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@ToString
public class UserVO extends Throwable {

    private int no;
    private String name;
    private String email;

    @JsonIgnore
    private String passwd;

    public static UserVOBuilder builder() {
        return new UserVOBuilder();
    }
}
