package Udemy.No_14_TypeErasure;

public class Info<T> {
    private T info;

    public Info(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;   
    }
}

/*
 * 上面的程式實際 compile 時會變成
 * public class Info {
        private Object info;

        public Info(Object info) {
            this.info = info;
        }

        public Object getInfo() {
            return this.info;   
        }
    }
 */

 
