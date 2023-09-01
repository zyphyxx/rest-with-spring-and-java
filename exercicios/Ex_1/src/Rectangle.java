public class Rectangle {
    private double width;
    private double height;

    public Rectangle(){
        width = 3.00;
        height = 4.00;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    //metodos
    public double area(){
       return getWidth()*getHeight();
    }
    public double perimeter(){
        return Math.pow(getWidth(),2)+Math.pow(getHeight(),2);
    }
    public double diagonal(){
        return Math.sqrt(Math.pow(getWidth(),2) + Math.pow(getHeight(),2));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
