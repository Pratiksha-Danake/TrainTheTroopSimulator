package com.amaap.trainthetroop.controller.dto;

import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ResponseTest {
    @Test
    void shouldBeAbleToTestEqualityOfTwoInstancesOfResponse() {
        // arrange && act
        Response response1 = new Response(HttpStatus.OK, "Success");
        Response response2 = new Response(HttpStatus.OK, "Success");
        Response response3 = new Response(HttpStatus.BAD_REQUEST, "Error");

        // assert
        assertEquals(response1, response2);
        assertEquals(response1, response1);
        assertNotEquals(response1, response3);
        assertNotEquals(response1, null);
        assertNotEquals(response1, "String");
    }

    @Test
    void shouldBeAbleToGetHashCode() {
        // arrange && act
        Response response1 = new Response(HttpStatus.OK, "Success");
        Response response2 = new Response(HttpStatus.OK, "Success");

        // assert
        assertEquals(response1.hashCode(), response2.hashCode());
    }
}