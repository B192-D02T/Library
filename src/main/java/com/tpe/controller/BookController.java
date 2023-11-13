package com.tpe.controller;

import com.tpe.entity.Book;
import com.tpe.service.BookService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/hi")
    public ModelAndView selamlama()
    {
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Merhaba,sayfama hoş geldiniz.");
        mav.addObject("messagebody","Burası deneme sayfasıdır");
        mav.addObject("submessage","Alt başlıklar da buraya yazılacak diye planladık");
        return mav;
    }
    @GetMapping("/new")
     public String formAtesle(@ModelAttribute("book") Book book){
     return "bookForm";
    }
    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "bookForm";
        }
        bookService.saveBook(book);
        return "redirect:/books";
    }
    @GetMapping
    public ModelAndView getAllBooks(){
    List<Book> tumKitaplar=bookService.getAllBooks();
    ModelAndView mav=new ModelAndView();
    mav.addObject("bookList",tumKitaplar);
    mav.setViewName("books");
    return mav;
    }
    @GetMapping("/update")
    public ModelAndView fromCek(@RequestParam("id") Long id)
    {
        Book bulunanKitap=bookService.FindByBookId(id);
        ModelAndView mav =new ModelAndView();
        mav.addObject("book",bulunanKitap);
        mav.setViewName("bookForm");
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String ogrenciSil(@PathVariable("id") Long id){
       bookService.delete(id);

       return "redirect:/books";
    }


}
