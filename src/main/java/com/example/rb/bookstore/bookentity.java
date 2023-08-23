package com.example.rb.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="book1")
@Getter
@NoArgsConstructor
public class bookentity {
    @Id
    private String bookname;

    @Column
    private int bookdate;

    @Column
    private String bookcontent;

    @Column
    private int bookavailable;

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    public void setBookdate(int bookdate) {
        this.bookdate = bookdate;
    }

    public void setBookavailable(int bookavailable) {
        this.bookavailable = bookavailable;
    }
}

   


