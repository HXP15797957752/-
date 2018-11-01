package cn.bluedot.framemarker.common;

public class Book {
    private Integer id;
    private String bookName;
    private Integer userid;
    
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", bookName=" + bookName + ", userid=" + userid + "]";
    }
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
}
