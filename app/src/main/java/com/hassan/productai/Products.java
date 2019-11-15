package com.hassan.productai;


public class Products {
    private String image_link;
    private String price;
    private  String product_name;
    private  String prfile_link;
    private  int pid;

    public  Products()
    {

    }
    public Products(String image_link,String price,String product_name,String prfile_link) {
        this.image_link = image_link;
        this.price = price;
        this.product_name = product_name;
        this.prfile_link = prfile_link;
//        this.pid = pid;
    }

    public String getImage_link() {
        return image_link;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getPrfile_link() {
        return prfile_link;
    }

//    public int getPid() {
//        return pid;
//    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setPrfile_link(String prfile_link) {
        this.prfile_link = prfile_link;
    }

//    public void setPid(int pid) {
//        this.pid = pid;
//    }
}
