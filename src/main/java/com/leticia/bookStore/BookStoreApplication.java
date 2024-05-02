package com.leticia.bookStore;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.repository.BookRepository;
import com.leticia.bookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;
    @Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category (null, "information", "book TI");
		Book book1 = new Book (null, "Clean Code", "Robertin Martin","Lorem Ipsum", cat1);

		cat1.getBooks ().addAll (Arrays.asList (book1));

		this.categoryRepository.saveAll (Arrays.asList (cat1));
		this.bookRepository.saveAll (Arrays.asList (book1));
	}
}
