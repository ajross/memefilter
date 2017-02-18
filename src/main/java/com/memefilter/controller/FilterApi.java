package com.memefilter.controller;

import java.io.File;

import com.memefilter.model.MemeText;
import com.memefilter.model.RealMeaning;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;


@Api(value = "filter", description = "the filter API")
public interface FilterApi {

    @ApiOperation(value = "Filters the supplied image for annoying quotes and returns a more realistic memeText.", notes = "The service will attempt to extract the text from the posted image, find a match in the database, and create a new image to return. The returned image will include the 'real' meaning behind the text in the supplied image. ", response = File.class, tags = {"Filters",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A filtered image", response = File.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = File.class)})
    @RequestMapping(value = "/filter/image",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = "multipart/form-data",
            method = RequestMethod.POST)
    CompletableFuture<ResponseEntity<File>> filterImagePost(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile image);


    @ApiOperation(value = "Returns the true meaning behind the supplied meme text.", notes = "Searches for a match for the supplied memeText against the database. Returns the true meaning behind the supplied memeText. ", response = RealMeaning.class, responseContainer = "List", tags = {"Filters",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of price estimates by product", response = RealMeaning.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = RealMeaning.class)})
    @RequestMapping(value = "/filter/text",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    CompletableFuture<ResponseEntity<RealMeaning>> filterTextPost(@ApiParam(value = "The memeText to be filtered.", required = true) @RequestBody MemeText memeText);

}
