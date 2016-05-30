package org.lombok.demo;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * Created by daijiajia on 16/5/30.
 */
@Builder
@Data
public class Passenger {

    String name;

    int age;

    String gender;

    @Singular
    List<Address> addresses;

}
