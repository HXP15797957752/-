package cn.bluedot.framemarker.dao;

/**
 * @author asus
 * Dao中的异常
 */

public class DaoException extends RuntimeException {
    public DaoException(){
        super("");
    }
    
    public DaoException(String str){
        super(str);
    }
}   
