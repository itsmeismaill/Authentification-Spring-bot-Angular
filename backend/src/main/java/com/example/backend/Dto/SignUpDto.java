package com.example.backend.Dto;


public record SignUpDto (String firstName, String lastName, String login, char[] password) { }