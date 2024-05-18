package com.amaap.trainthetroop.controller.dto;

import com.amaap.trainthetroop.controller.valueobject.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {
    @Test
    void shouldBeAbleToTestEqualityOfTwoInstancesOfResponse() {
        // arrange && act
        Response response1 = new Response(HttpStatus.OK, "Success");
        Response response2 = new Response(HttpStatus.OK, "Success");
        Response response3 = new Response(HttpStatus.BAD_REQUEST, "Error");
        Response response4 = new Response(HttpStatus.OK, "Error");
        Response response5 = new Response(HttpStatus.BAD_REQUEST, "Success");


        // assert
        assertTrue(response1.equals(response2));
        assertTrue(response1.equals(response1));
        assertFalse(response1.equals(response3));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(new String("string")));
        assertFalse(response1.equals(response4));
        assertFalse(response1.equals(response5));
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