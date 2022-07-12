package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// отличия анотации RestController от Controller состоит лишь в том что она добавляет ещё анотацию и ResponseBody
@RestController
// добавляем анотацию RequestMapping для того чтобы отделить внешний API от внутреннего который описан в MainPageController
@RequestMapping("/api")
@Api(description = "book data api")
public class BooksRestApiController {

    private final BookService bookService;

    public BooksRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

    // возвращение книг по заданному автору
    @GetMapping("/books/by-author")
    @ApiOperation("operation to get book list of bookshop by passed author first name")
    public ResponseEntity<List<Book>> booksByAuthor(@RequestParam("author") String authorName){
        // возвращаем экземпляр объекта ResponseEntity, вызываем метод ok(т.е. успешное выполнение запроса)
        // в качестве аргумента передаём список заданных авторов получаемый из bookService
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorName));
    }

    // возвращаем имя ниги
    @GetMapping("/books/by-title")
    @ApiOperation("get book by title")
    public  ResponseEntity<List<Book>> booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    // поиск книг по диапазону цен
    @GetMapping("/books/by-price-range")
    @ApiOperation("get book by price range from min price to max price")
    public ResponseEntity<List<Book>> priceRangeBooks(@RequestParam("min") Integer min, @RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min,max));
    }

    // книги с максимальнгой ценой
    @GetMapping("/books/with-max-discount")
    @ApiOperation("get list of book with max price")
    public ResponseEntity<List<Book>> maxDiscountBooks(){
        return ResponseEntity.ok(bookService.getBooksWithMaxDiscount());
    }

    // возвращаем бестселлеры
    @GetMapping("/book/bestseller")
    @ApiOperation("get bestseller books (which is_bestseller = 1)")
    public ResponseEntity<List<Book>> bestsellerBooks(){
        return ResponseEntity.ok(bookService.getBestseller());
    }

}
